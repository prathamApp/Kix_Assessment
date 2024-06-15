package com.kix.assessment.async;

import static com.kix.assessment.KIXApplication.getStoragePath;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.kix.assessment.KIXApplication;
import com.kix.assessment.R;
import com.kix.assessment.custom.CustomLodingDialog;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.EventMessage;
import com.kix.assessment.modal_classes.Modal_PushResponse;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@EBean
public class PushDataBaseZipToServer {

    private final boolean pushImageSuccessfull = false;
    private final int BUFFER = 10000;
    CustomLodingDialog pushDialog;
    //    LottieAnimationView push_lottie;
    TextView txt_push_dialog_msg;
    //    TextView txt_push_error;
    RelativeLayout rl_btn;
    Button ok_btn;
    private Context context;
    private boolean pushSuccessfull = false;
    private boolean showUi = false;


    public PushDataBaseZipToServer(Context context) {
        this.context = context;
        showUi = false;
    }

    /**
     * This method begins the process of pushing data to server.
     * Locally stored data is collected and added to its respective JsonArray defined globally above.
     *
     * @param showUi is used to show the push Dialog.
     */
    @Background
    public void startDataBasePush(Context context, boolean showUi) {
        if (KIXApplication.wiseF.isDeviceConnectedToWifiNetwork() || KIXApplication.wiseF.isDeviceConnectedToMobileNetwork()) {
            this.context = context;
            this.showUi = showUi;
            //Show Dialog
            showPushDialog(context);
            //Here data is fetched from local database and added to a list and then passed to JsonArray.
            try {
                pushSuccessfull = false;
                //Checks if device is connected to wifi
                pushDataToServer(context, Kix_Constant.PUSH_DB_API);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, context.getString(R.string.check_internet), Toast.LENGTH_SHORT).show();
        }
    }

    //Custom loading dialog is shown
    @UiThread
    public void showPushDialog(Context context) {
        if (showUi) {
            pushDialog = new CustomLodingDialog(context);
            pushDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            pushDialog.setContentView(R.layout.push_dialog);
            Objects.requireNonNull(pushDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            pushDialog.setCancelable(false);
            pushDialog.setCanceledOnTouchOutside(false);
            pushDialog.show();

            txt_push_dialog_msg = pushDialog.findViewById(R.id.dia_title);
            ok_btn = pushDialog.findViewById(R.id.dia_btn_ok);

//            ok_btn.setVisibility(View.GONE);
            ok_btn.setOnClickListener(v -> {
                pushDialog.dismiss();
            });
        }
    }

    public void zip(List<String> _files, String zipFileName, File filepath) {
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(zipFileName);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

            byte[] data = new byte[BUFFER];
            for (int i = 0; i < _files.size(); i++) {
                Log.v("Compress", "Adding: " + _files.get(i));
                FileInputStream fi = new FileInputStream(_files.get(i));
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(_files.get(i).substring(_files.get(i).lastIndexOf("/") + 1));
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }

            out.close();
//            new File(zipFileName).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Call only this method, do the data collection before
    public void pushDataToServer(Context context, String... url) {
        try {
//            String newdata = compress(String.valueOf(data));
            BackupDatabase.backup(context);
//            String fielName = "KDB_" + Kix_RandomString.unique();
//            String fielName = KIX_Utility.getDeviceID()+"_"+KIX_Utility.getCurrentDateTime2();
            String fielName = KIX_Utility.getDeviceID() + "_" + KIX_Utility.getTimeInMilli();
            String filePathStr = getStoragePath().getAbsolutePath()
                    + "/KixBackup/" + fielName; // file path to save
            // Type the path of the files in here
            File dir = new File(getStoragePath().getAbsolutePath() + "/KixBackup/");
            File[] db_files = dir.listFiles();
            Log.d("FC_RandomString", "DB ZIP NAME " + fielName);
            if (db_files != null) {
                List<String> fileNameListStrings = new ArrayList<>();
                for (int i = 0; i < db_files.length; i++)
                    if (db_files[i].exists() && db_files[i].isFile() && db_files[i].getName().contains("kix"))
                        fileNameListStrings.add(db_files[i].getAbsolutePath());
                zip(fileNameListStrings, filePathStr + ".zip", new File(filePathStr));
                Log.d("FC_RandomString", filePathStr + ".zip");
                AndroidNetworking.upload(url[0])
                        .addHeaders("Content-Type", "file/zip")
                        .addMultipartFile("zip", new File(filePathStr + ".zip"))
//                        .addMultipartFile("file", new File(filePathStr + ".zip"))
//                        .addHeaders("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyMjYzNzAyNX0.zwrt5F67Q7_WE2lrmr7_cWKzlDtWCyImmvHJGA6ynas")
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsString(new StringRequestListener() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("PushData", "DB ZIP PUSH " + response);
                                new File(filePathStr + ".zip").delete();
                                Gson gson = new Gson();
                                Modal_PushResponse pushResponse = gson.fromJson(response, Modal_PushResponse.class);
                                if (pushResponse.status.equalsIgnoreCase("success")) {
//                                if (pushResponse.isSuccess()/*equalsIgnoreCase("success")*/) {
                                    Log.d("PushData", "DB ZIP PUSH SUCCESS");
                                    pushSuccessfull = true;
                                    EventMessage msg = new EventMessage();
                                    msg.setMessage(Kix_Constant.DBSUCCESSFULLYPUSHED);
                                    EventBus.getDefault().post(msg);
                                }else{
                                    pushSuccessfull = false;
                                    new File(filePathStr + ".zip").delete();
                                    EventMessage msg = new EventMessage();
                                    msg.setMessage(Kix_Constant.PUSHFAILED);
                                    EventBus.getDefault().post(msg);
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                //Fail - Show dialog with failure message.
                                Log.d("PushData", "Data push FAIL");
                                Log.d("PushData", "ERROR  " + anError);
                                pushSuccessfull = false;
                                new File(filePathStr + ".zip").delete();
                                EventMessage msg = new EventMessage();
                                msg.setMessage(Kix_Constant.PUSHFAILED);
                                EventBus.getDefault().post(msg);
                            }
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}