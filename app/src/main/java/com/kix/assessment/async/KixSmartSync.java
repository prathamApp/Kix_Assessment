package com.kix.assessment.async;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Attendance;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_Household;
import com.kix.assessment.modal_classes.Modal_Log;
import com.kix.assessment.modal_classes.Modal_Session;
import com.kix.assessment.modal_classes.Modal_Status;
import com.kix.assessment.modal_classes.Modal_Student;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.modal_classes.Score;

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

import static com.kix.assessment.KIXApplication.attendanceDao;
import static com.kix.assessment.KIXApplication.householdDao;
import static com.kix.assessment.KIXApplication.logDao;
import static com.kix.assessment.KIXApplication.scoreDao;
import static com.kix.assessment.KIXApplication.sessionDao;
import static com.kix.assessment.KIXApplication.statusDao;
import static com.kix.assessment.KIXApplication.studentDao;
import static com.kix.assessment.KIXApplication.surveyorDao;


public class KixSmartSync { //extends AutoSync {
    private static final String TAG = KixSmartSync.class.getSimpleName();
    private static int BUFFER = 10000;
    public static String courseCount="";

/*    @Override
    protected void onCreate(Context context) {
        super.onCreate(context);
    }*/

    public static void pushUsageToServer(Boolean isPressed) {
        try {
            String programID = "";
            JSONObject rootJson = new JSONObject();
            Gson gson = new Gson();
            //iterate through all new sessions
            JSONArray sessionArray = new JSONArray();
            List<Modal_Session> newSessions = sessionDao.getAllNewSessions();
            for (Modal_Session session : newSessions) {
                //fetch all logs
                JSONArray logArray = new JSONArray();
                List<Modal_Log> allLogs = logDao.getAllLogs(session.getSessionID());
                for (Modal_Log log : allLogs)
                    logArray.put(new JSONObject(gson.toJson(log)));

                //fetch attendance
                JSONArray attendanceArray = new JSONArray();
                List<Attendance> newAttendance = attendanceDao.getNewAttendances(session.getSessionID());
                for (Attendance att : newAttendance) {
                    attendanceArray.put(new JSONObject(gson.toJson(att)));
                }
                //fetch Scores & convert to Json Array
                JSONArray scoreArray = new JSONArray();
                List<Score> newScores = scoreDao.getAllNewScores(session.getSessionID());
                for (Score score : newScores) {
                    scoreArray.put(new JSONObject(gson.toJson(score)));
                }
                // fetch Session Data
                JSONObject sessionJson = new JSONObject();
                sessionJson.put(Kix_Constant.SESSIONID, session.getSessionID());
                sessionJson.put(Kix_Constant.FROMDATE, session.getFromDate());
                sessionJson.put(Kix_Constant.TODATE, session.getToDate());
                sessionJson.put(Kix_Constant.SCORE, scoreArray);
                sessionJson.put(Kix_Constant.ATTENDANCE, attendanceArray);
                sessionJson.put(Kix_Constant.LOGS, logArray);

                sessionArray.put(sessionJson);
            }
            // send if new records found
            if (newSessions.size() > 0) {
                //fetch Students & convert to Json Array
                JSONArray studentArray = new JSONArray();
                    List<Modal_Student> newStudents = studentDao.getAllNewStudents();
                    for (Modal_Student std : newStudents)
                        studentArray.put(new JSONObject(gson.toJson(std)));

                //fetch Surveyor & convert to Json Array
                JSONArray surveyorArray = new JSONArray();
                    List<Modal_Surveyor> newSurveyor = surveyorDao.getAllNewSurveyor();
                    for (Modal_Surveyor svr : newSurveyor)
                        surveyorArray.put(new JSONObject(gson.toJson(svr)));

                //fetch Household & convert to Json Array
                JSONArray householdArray = new JSONArray();
                    List<Modal_Household> newHousehold = householdDao.getAllNewHouseholds();
                    for (Modal_Household hld : newHousehold)
                        householdArray.put(new JSONObject(gson.toJson(hld)));

                //fetch updated status
                JSONObject metadataJson = new JSONObject();
                List<Modal_Status> metadata = statusDao.getAllStatuses();
                for (Modal_Status status : metadata) {
                    metadataJson.put(status.getStatusKey(), status.getValue());
                }
                metadataJson.put(Kix_Constant.SCORE_COUNT, (metadata.size() > 0) ? metadata.size() : 0);
                rootJson.put(Kix_Constant.SURVEYOR, surveyorArray);
                rootJson.put(Kix_Constant.HOUSEHOLD, householdArray);
                rootJson.put(Kix_Constant.STUDENTS, studentArray);
                rootJson.put(Kix_Constant.SESSION, sessionArray);
                rootJson.put(Kix_Constant.METADATA, metadataJson);
                Log.e("KIX : ", String.valueOf(rootJson));
                pushDataToServer(rootJson,courseCount);
            }/* else {
                if (isPressed) {
                    EventMessage msg = new EventMessage();
                    msg.setMessage(Kix_Constant.SUCCESSFULLYPUSHED);
                    EventBus.getDefault().post(msg);
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //before pushing zipping the json and then pushing
    public static void pushDataToServer(JSONObject data, String courseCount) {
        try {
            String uuID = "" + KIX_Utility.getUUID();
            String filepathstr = KIXApplication.kixPath +"/"+ uuID; // file path to save
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
        AndroidNetworking.upload(url)
                .addHeaders("Content-Type", "file/zip")
                .addMultipartFile("file", new File(filepathstr + ".zip"))
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("PushData", "DATA PUSH "+response);
//                        new File(filepathstr + ".zip").delete();
                        EventMessage msg = new EventMessage();
                        msg.setMessage(Kix_Constant.SUCCESSFULLYPUSHED);
                        msg.setPushData(data.toString());
                        EventBus.getDefault().post(msg);
                    }

                    @Override
                    public void onError(ANError anError) {
                        //Fail - Show dialog with failure message.
                        EventMessage msg = new EventMessage();
                        msg.setMessage(Kix_Constant.PUSHFAILED);
                        EventBus.getDefault().post(msg);
                        Log.e("Error::", anError.getErrorDetail());
                        Log.e("Error::", anError.getMessage());
                        Log.e("Error::", anError.getResponse().toString());
                    }
                });
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
