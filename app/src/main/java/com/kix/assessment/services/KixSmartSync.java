package com.kix.assessment.services;

import static com.kix.assessment.KIXApplication.abandonedScoreDao;
import static com.kix.assessment.KIXApplication.attendanceDao;
import static com.kix.assessment.KIXApplication.householdDao;
import static com.kix.assessment.KIXApplication.householdInformationDao;
import static com.kix.assessment.KIXApplication.logDao;
import static com.kix.assessment.KIXApplication.parentInformationDao;
import static com.kix.assessment.KIXApplication.scoreDao;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.KIXApplication.statusDao;
import static com.kix.assessment.KIXApplication.studentDao;
import static com.kix.assessment.KIXApplication.surveyorDao;
import static com.kix.assessment.KIXApplication.villageDao;
import static com.kix.assessment.KIXApplication.villageInformationDao;

import android.os.Environment;
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
import com.kix.assessment.modal_classes.Modal_HIF;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Modal_PIF;
import com.kix.assessment.modal_classes.Modal_Session;
import com.kix.assessment.modal_classes.Modal_Status;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.modal_classes.Modal_VIF;
import com.kix.assessment.modal_classes.Modal_Village;
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

    public static void pushUsageToServer(Boolean isPressed) {
        try {
            final String programID = "";
            JSONObject rootJson = new JSONObject();
            Gson gson = new Gson();

            JSONArray abandonedScoreArray = new JSONArray();
            List<AbandonedScore> newAbandonedScore = abandonedScoreDao.getAllNotSentAbandonedScores();
            for (AbandonedScore abandonedScore : newAbandonedScore)
                abandonedScoreArray.put(new JSONObject(gson.toJson(abandonedScore)));

            JSONArray attendanceArray = new JSONArray();
            List<Attendance> newAttendance = attendanceDao.getNewAttendances();
            for (Attendance att : newAttendance)
                attendanceArray.put(new JSONObject(gson.toJson(att)));

            JSONArray householdArray = new JSONArray();
            List<Modal_Household> newHousehold = householdDao.getAllNewHouseholds();
            for (Modal_Household hld : newHousehold)
                householdArray.put(new JSONObject(gson.toJson(hld)));

            JSONArray HIFArray = new JSONArray();
            List<Modal_HIF> newModal_hifs = householdInformationDao.getAllNewHIF();
            for (Modal_HIF hif : newModal_hifs)
                HIFArray.put(new JSONObject(gson.toJson(hif)));

            JSONArray logArray = new JSONArray();
            List<Modal_Log> allLogs = logDao.getAllLogs();
            for (Modal_Log log : allLogs)
                logArray.put(new JSONObject(gson.toJson(log)));

            JSONArray PIFArray = new JSONArray();
            List<Modal_PIF> allPIF = parentInformationDao.getAllPIF();
            for (Modal_PIF modal_pif : allPIF)
                PIFArray.put(new JSONObject(gson.toJson(modal_pif)));

            JSONArray scoreArray = new JSONArray();
            List<Score> newScores = scoreDao.getAllNotSentScores();
            for (Score score : newScores)
                scoreArray.put(new JSONObject(gson.toJson(score)));

            JSONArray sessionArray = new JSONArray();
            List<Modal_Session> newSessions = sessionDao.getAllNewSessions();
            for (Modal_Session session : newSessions)
                sessionArray.put(new JSONObject(gson.toJson(session)));

            JSONArray studentArray = new JSONArray();
            List<Modal_Student> newStudents = studentDao.getAllNewStudents();
            for (Modal_Student std : newStudents)
                studentArray.put(new JSONObject(gson.toJson(std)));

            JSONArray surveyorArray = new JSONArray();
            List<Modal_Surveyor> newSurveyor = surveyorDao.getAllNewSurveyor();
            for (Modal_Surveyor svr : newSurveyor)
                surveyorArray.put(new JSONObject(gson.toJson(svr)));

            JSONArray villageArray = new JSONArray();
            List<Modal_Village> newVillages = villageDao.getAllNewVillages();
            for (Modal_Village modal_village : newVillages)
                villageArray.put(new JSONObject(gson.toJson(modal_village)));

            JSONArray VIFArray = new JSONArray();
            List<Modal_VIF> newVifs = villageInformationDao.getAllNewVIF();
            for (Modal_VIF modal_vif : newVifs)
                VIFArray.put(new JSONObject(gson.toJson(modal_vif)));

            JSONObject metadataJson = new JSONObject();
            List<Modal_Status> metadata = statusDao.getAllStatuses();
            for (Modal_Status status : metadata) {
                metadataJson.put(status.getStatusKey(), status.getValue());
            }
            metadataJson.put(Kix_Constant.SCORE_COUNT, scoreArray.length());
            metadataJson.put(Kix_Constant.STUDENT_COUNT, studentArray.length());
            metadataJson.put(Kix_Constant.VILLAGE_COUNT, villageArray.length());
            metadataJson.put(Kix_Constant.SURVEYOR_COUNT, surveyorArray.length());
            metadataJson.put(Kix_Constant.HOUSEHOLD_COUNT, householdArray.length());

            rootJson.put(Kix_Constant.METADATA, metadataJson);
            rootJson.put(Kix_Constant.ABANDONEDSCORE, abandonedScoreArray);
            rootJson.put(Kix_Constant.ATTENDANCE, attendanceArray);
            rootJson.put(Kix_Constant.HOUSEHOLD, householdArray);
            rootJson.put(Kix_Constant.HIF, HIFArray);
            rootJson.put(Kix_Constant.PIF, PIFArray);
            rootJson.put(Kix_Constant.SCORE, scoreArray);
            rootJson.put(Kix_Constant.SESSION, sessionArray);
            rootJson.put(Kix_Constant.STUDENTS, studentArray);
            rootJson.put(Kix_Constant.SURVEYOR, surveyorArray);
            rootJson.put(Kix_Constant.VILLAGE, villageArray);
            rootJson.put(Kix_Constant.VIF, VIFArray);
            rootJson.put(Kix_Constant.LOGS, logArray);

            FastSave.getInstance().saveString(Kix_Constant.SCORE_COUNT, ""+scoreArray.length());
            FastSave.getInstance().saveString(Kix_Constant.STUDENT_COUNT, ""+studentArray.length());
            FastSave.getInstance().saveString(Kix_Constant.VILLAGE_COUNT, ""+villageArray.length());
            FastSave.getInstance().saveString(Kix_Constant.SURVEYOR_COUNT, ""+surveyorArray.length());
            FastSave.getInstance().saveString(Kix_Constant.HOUSEHOLD_COUNT, ""+surveyorArray.length());

            Log.e("KIX : ", String.valueOf(rootJson));
            pushDataToServer(rootJson, courseCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //before pushing zipping the json and then pushing
    public static void pushDataToServer(JSONObject data, String courseCount) {
        try {
            String uuID = "" + KIX_Utility.getUUID();
//            final String filepathstr = KIXApplication.kixPath + "/" + uuID; // file path to save
            String filepathstr = Environment.getExternalStorageDirectory() + "/" + Kix_Constant.KIX_BACKUP + "/" + uuID; // file path to save
            File filepath = new File(filepathstr + ".json"); // file path to save

            if (filepath.exists())
                filepath.delete();
            FileWriter writer = new FileWriter(filepath);
            writer.write(String.valueOf(data));
            writer.flush();
            writer.close();

            String[] s = new String[1];

            // Type the path of the files in here
            s[0] = filepathstr + ".json";
            // first parameter is d files second parameter is zip file name
            zip(s, filepathstr + ".zip", filepath);

            if (KIXApplication.wiseF.isDeviceConnectedToMobileNetwork() || KIXApplication.wiseF.isDeviceConnectedToWifiNetwork()) {
                pushDataToInternet(Kix_Constant.PUSH_API, uuID, filepathstr, data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pushDataToInternet(String url, String uuID, String filepathstr, JSONObject data) {
        Log.e("TAG", "pushDataToInternet: "+filepathstr);
        AndroidNetworking.upload(url)
                .addHeaders("Content-Type", "file/zip")
                .addMultipartFile("file", new File(filepathstr + ".zip"))
                .addHeaders("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyMjYzNzAyNX0.zwrt5F67Q7_WE2lrmr7_cWKzlDtWCyImmvHJGA6ynas")
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("PushData", "DATA PUSH " + response);
                        if (response.equalsIgnoreCase("Successfully pushed")) {
//                            new File(filepathstr + ".zip").delete();
                            setSentFlag();
                            EventMessage msg = new EventMessage();
                            msg.setMessage(Kix_Constant.SUCCESSFULLYPUSHED);
                            msg.setPushData(data.toString());
                            EventBus.getDefault().post(msg);
                        } else {
                            Log.e("PushData", "onResponse Failed :  " + response);
//                            new File(filepathstr + ".zip").delete();
                            EventMessage msg = new EventMessage();
                            msg.setMessage(Kix_Constant.PUSHFAILED);
                            EventBus.getDefault().post(msg);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        //Fail - Show dialog with failure message.
//                        new File(filepathstr + ".zip").delete();
                        EventMessage msg = new EventMessage();
                        msg.setMessage(Kix_Constant.PUSHFAILED);
                        EventBus.getDefault().post(msg);
                        Log.e("Error::", anError.getErrorDetail());
//                        Log.e("Error::", anError.getMessage());
                        Log.e("Error::", anError.getResponse().toString());
                    }
                });
    }

    public static void setSentFlag() {
        //TODO Change this and also add new tables.
//        studentDao.updateSentFlag();
//        surveyorDao.updateSentFlag();
//        householdDao.updateSentFlag();
//        logDao.updateSentFlag();
//        attendanceDao.updateSentFlag();
//        sessionDao.updateSentFlag();
//        scoreDao.updateSentFlag();
//        abandonedScoreDao.updateSentFlag();
    }

    public static void zip(String[] _files, String zipFileName, File filepath) {
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(zipFileName);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

            byte[] data = new byte[BUFFER];
            for (int i = 0; i < _files.length; i++) {
                Log.v("Compress", "Adding: " + _files[i]);
                FileInputStream fi = new FileInputStream(_files[i]);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(_files[i].substring(_files[i].lastIndexOf("/") + 1));
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }

            out.close();
            filepath.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
