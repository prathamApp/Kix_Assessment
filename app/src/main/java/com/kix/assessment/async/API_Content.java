package com.kix.assessment.async;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.kix.assessment.interfaces.API_Content_Result;
import com.kix.assessment.kix_utils.Kix_Constant;


public class API_Content {

    Context mContext;
    API_Content_Result apiContentResult;
    static String responseAPI = "";

    /**
     * @param context
     * @param apiContentResult This contains the fetching of data from API and giving the result.
     *                         Instance from the calling method is used to return the result back.
     * @param apiContentResult is used to return the result back to the calling class.
     *                         if success - requestType and response is sent to receivedContent() method.
     *                         else only requestType is sent to receivedError() method.
     */

    public API_Content(Context context, API_Content_Result apiContentResult) {
        this.mContext = context;
        this.apiContentResult = apiContentResult;
    }

    public void getAPIContent(final String requestType, String url, String nodeId) {
        try {
            String url_id, studId;
//            SCAPP_55008
//            studId = FastSave.getInstance().getString(CURRENT_STUDENT_ID, "");
            url_id = url + nodeId + Kix_Constant.DEVICE_ID_STR + "divId" + Kix_Constant.STUDENT_ID_STR + "studId";
            Log.d("API_Content_LOG", "getAPIContent: " + nodeId);
            Log.d("API_Content_LOG", "url_id: " + url_id);
            AndroidNetworking.get(url_id)
                    .addHeaders("Content-Type", "application/json")
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String response) {
                            //Success - Send requestType and response to the calling class.
                            if (apiContentResult != null)
                                apiContentResult.receivedContent(requestType, response);
                        }

                        @Override
                        public void onError(ANError anError) {
                            try {
                                Log.d("Error:", anError.getErrorDetail());
                                // Log.d("Error::", anError.getResponse().toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            //Success - Send requestType and response to the calling class.
                            if (apiContentResult != null)
                                apiContentResult.receivedError(requestType);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void getInternetTimeApi(final String requestType, String url) {
//        try {
//            Log.d("API_Content_LOG", "getAPIContent: " + url);
//            AndroidNetworking.get(url)
//                    .addHeaders("Content-Type", "application/json")
//                    .build()
//                    .getAsString(new StringRequestListener() {
//                        @Override
//                        public void onResponse(String response) {
//                            //Success - Send requestType and response to the calling class.
//                            if (apiContentResult != null)
//                                apiContentResult.receivedContent(requestType, response);
//                        }
//
//                        @Override
//                        public void onError(ANError anError) {
//                            try {
//                                Log.d("Error:", anError.getErrorDetail());
//                                // Log.d("Error::", anError.getResponse().toString());
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                            //Success - Send requestType and response to the calling class.
//                            if (apiContentResult != null)
//                                apiContentResult.receivedError(requestType);
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void downloadImage(String url, String filename) {
//        File dir = new File(KIXApplication.kixPath /*+ "" + App_Thumbs_Path*/); //Creating an internal dir;
//        if (!dir.exists()) dir.mkdirs();
//        AndroidNetworking.download(url, dir.getAbsolutePath(), filename)
//                .setPriority(Priority.HIGH)
//                .setExecutor(Executors.newSingleThreadExecutor())
//                .build()
//                .startDownload(new DownloadListener() {
//                    @Override
//                    public void onDownloadComplete() {
//                        Log.d("image::", "DownloadComplete");
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        Log.d("image::", "Not Downloaded");
//                    }
//                });
//    }

}
