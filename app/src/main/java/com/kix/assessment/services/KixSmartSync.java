package com.kix.assessment.services;

import static com.kix.assessment.KIXApplication.abandonedScoreDao;
import static com.kix.assessment.KIXApplication.attendanceDao;
import static com.kix.assessment.KIXApplication.householdDao;
import static com.kix.assessment.KIXApplication.logDao;
import static com.kix.assessment.KIXApplication.scoreDao;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.KIXApplication.statusDao;
import static com.kix.assessment.KIXApplication.studentDao;
import static com.kix.assessment.KIXApplication.surveyorDao;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.AbandonedScore;
import com.kix.assessment.modal_classes.Attendance;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Modal_Session;
import com.kix.assessment.modal_classes.Modal_Status;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.modal_classes.Score;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class KixSmartSync { //extends AutoSync {
    private static final String TAG = KixSmartSync.class.getSimpleName();
    private static final int BUFFER = 10000;
    public static String courseCount = "";

    public static void pushUsageToServer(final Boolean isPressed) {
        try {
            final String programID = "";
            final JSONObject rootJson = new JSONObject();
            final Gson gson = new Gson();

            final JSONArray abandonedScoreArray = new JSONArray();
            final List<AbandonedScore> newAbandonedScore = abandonedScoreDao.getAllNotSentAbandonedScores();
            for (final AbandonedScore abandonedScore : newAbandonedScore)
                abandonedScoreArray.put(new JSONObject(gson.toJson(abandonedScore)));

            final JSONArray attendanceArray = new JSONArray();
            final List<Attendance> newAttendance = attendanceDao.getNewAttendances();
            for (final Attendance att : newAttendance)
                attendanceArray.put(new JSONObject(gson.toJson(att)));

            final JSONArray householdArray = new JSONArray();
            final List<Modal_Household> newHousehold = householdDao.getAllNewHouseholds();
            for (final Modal_Household hld : newHousehold)
                householdArray.put(new JSONObject(gson.toJson(hld)));

            final JSONArray logArray = new JSONArray();
            final List<Modal_Log> allLogs = logDao.getAllLogs();
            for (final Modal_Log log : allLogs)
                logArray.put(new JSONObject(gson.toJson(log)));

            final JSONArray scoreArray = new JSONArray();
            final List<Score> newScores = scoreDao.getAllNotSentScores();
            for (final Score score : newScores)
                scoreArray.put(new JSONObject(gson.toJson(score)));

            final JSONArray sessionArray = new JSONArray();
            final List<Modal_Session> newSessions = sessionDao.getAllNewSessions();
            for (final Modal_Session session : newSessions)
                sessionArray.put(new JSONObject(gson.toJson(session)));

            final JSONArray studentArray = new JSONArray();
            final List<Modal_Student> newStudents = studentDao.getAllNewStudents();
            for (final Modal_Student std : newStudents)
                studentArray.put(new JSONObject(gson.toJson(std)));

            final JSONArray surveyorArray = new JSONArray();
            final List<Modal_Surveyor> newSurveyor = surveyorDao.getAllNewSurveyor();
            for (final Modal_Surveyor svr : newSurveyor)
                surveyorArray.put(new JSONObject(gson.toJson(svr)));

            final JSONObject metadataJson = new JSONObject();
            final List<Modal_Status> metadata = statusDao.getAllStatuses();
            for (final Modal_Status status : metadata) {
                metadataJson.put(status.getStatusKey(), status.getValue());
            }
            metadataJson.put(Kix_Constant.SCORE_COUNT, scoreArray.length());

            rootJson.put(Kix_Constant.METADATA, metadataJson);
            rootJson.put(Kix_Constant.ABANDONEDSCORE, abandonedScoreArray);
            rootJson.put(Kix_Constant.ATTENDANCE, attendanceArray);
            rootJson.put(Kix_Constant.HOUSEHOLD, householdArray);
            rootJson.put(Kix_Constant.SCORE, scoreArray);
            rootJson.put(Kix_Constant.SESSION, sessionArray);
            rootJson.put(Kix_Constant.STUDENTS, studentArray);
            rootJson.put(Kix_Constant.SURVEYOR, surveyorArray);
            rootJson.put(Kix_Constant.LOGS, logArray);

            FastSave.getInstance().saveString(Kix_Constant.SCORE_COUNT, ""+scoreArray.length());
            FastSave.getInstance().saveString(Kix_Constant.STUDENT_COUNT, ""+studentArray.length());
            FastSave.getInstance().saveString(Kix_Constant.VILLAGE_COUNT, ""+householdArray.length());
            FastSave.getInstance().saveString(Kix_Constant.SURVEYOR_COUNT, ""+surveyorArray.length());

            Log.e("KIX : ", String.valueOf(rootJson));
            KixSmartSync.pushDataToServer(rootJson, KixSmartSync.courseCount);

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    //before pushing zipping the json and then pushing
    public static void pushDataToServer(final JSONObject data, final String courseCount) {
        try {
            final String uuID = "" + KIX_Utility.getUUID();
            final String filepathstr = KIXApplication.kixPath + "/" + uuID; // file path to save
            final File filepath = new File(filepathstr + ".json"); // file path to save

            if (filepath.exists())
                filepath.delete();
            final FileWriter writer = new FileWriter(filepath);
            writer.write(String.valueOf(data));
            writer.flush();
            writer.close();

            final String[] s = new String[1];

            // Type the path of the files in here
            s[0] = filepathstr + ".json";
            // first parameter is d files second parameter is zip file name
            KixSmartSync.zip(s, filepathstr + ".zip", filepath);

            if (KIXApplication.wiseF.isDeviceConnectedToMobileNetwork() || KIXApplication.wiseF.isDeviceConnectedToWifiNetwork()) {
                KixSmartSync.pushDataToInternet(Kix_Constant.PUSH_API, uuID, filepathstr, data);
            }

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void pushDataToInternet(final String url, final String uuID, final String filepathstr, final JSONObject data) {
        AndroidNetworking.upload(url)
                .addHeaders("Content-Type", "file/zip")
                .addMultipartFile("file", new File(filepathstr + ".zip"))
                .addHeaders("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyMjYzNzAyNX0.zwrt5F67Q7_WE2lrmr7_cWKzlDtWCyImmvHJGA6ynas")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(final String response) {
                        Log.e("PushData", "DATA PUSH " + response);
                        if (response.equalsIgnoreCase("Successfully pushed")) {
                            new File(filepathstr + ".zip").delete();
                            KixSmartSync.setSentFlag();
                            final EventMessage msg = new EventMessage();
                            msg.setMessage(Kix_Constant.SUCCESSFULLYPUSHED);
                            msg.setPushData(data.toString());
                            EventBus.getDefault().post(msg);
                        } else {
                            Log.e("PushData", "onResponse Failed :  " + response);
                            new File(filepathstr + ".zip").delete();
                            final EventMessage msg = new EventMessage();
                            msg.setMessage(Kix_Constant.PUSHFAILED);
                            EventBus.getDefault().post(msg);
                        }
                    }

                    @Override
                    public void onError(final ANError anError) {
                        //Fail - Show dialog with failure message.
                        new File(filepathstr + ".zip").delete();
                        final EventMessage msg = new EventMessage();
                        msg.setMessage(Kix_Constant.PUSHFAILED);
                        EventBus.getDefault().post(msg);
                        Log.e("Error::", anError.getErrorDetail());
//                        Log.e("Error::", anError.getMessage());
                        Log.e("Error::", anError.getResponse().toString());
                    }
                });
    }

    public static void setSentFlag() {
        studentDao.updateSentFlag();
        surveyorDao.updateSentFlag();
        householdDao.updateSentFlag();
        logDao.updateSentFlag();
        attendanceDao.updateSentFlag();
        sessionDao.updateSentFlag();
        scoreDao.updateSentFlag();
        abandonedScoreDao.updateSentFlag();
    }

    public static void zip(final String[] _files, final String zipFileName, final File filepath) {
        try {
            BufferedInputStream origin = null;
            final FileOutputStream dest = new FileOutputStream(zipFileName);
            final ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

            final byte[] data = new byte[KixSmartSync.BUFFER];
            for (int i = 0; i < _files.length; i++) {
                Log.v("Compress", "Adding: " + _files[i]);
                final FileInputStream fi = new FileInputStream(_files[i]);
                origin = new BufferedInputStream(fi, KixSmartSync.BUFFER);
                final ZipEntry entry = new ZipEntry(_files[i].substring(_files[i].lastIndexOf("/") + 1));
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, KixSmartSync.BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }

            out.close();
            filepath.delete();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
