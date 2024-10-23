package com.kix.assessment.custom.catcho;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.kix.assessment.custom.catcho.error.CatchoError;


/**
 * The type Catcho report activity.
 */
public class CatchoReportActivity extends AppCompatActivity implements View.OnClickListener {
    private CatchoError mError;
    private EditText title, description, deviceInfo, senderEmail;
    private CatchoTags.EmailMode emailMode;
    private String[] recipientEmail;
    private String smtpEmail, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
      //  setContentView(R.layout.activity_catcho_report);
        init();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CatchoTags.REPORT, mError);
        outState.putString(CatchoTags.TITLE, title.getText().toString());
        outState.putString(CatchoTags.EMAIL, senderEmail.getText().toString());
        outState.putString(CatchoTags.DESCRIPTION, description.getText().toString());
        outState.putStringArray(CatchoTags.RECIPIENT_EMAIL, recipientEmail);
        outState.putString(CatchoTags.SMTP_EMAIL, smtpEmail);
        outState.putString(CatchoTags.PASSWORD, password);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            mError = (CatchoError) savedInstanceState.getSerializable(CatchoTags.REPORT);
            deviceInfo.setText(savedInstanceState.getString(CatchoTags.REPORT));
            title.setText(savedInstanceState.getString(CatchoTags.TITLE));
            description.setText(savedInstanceState.getString(CatchoTags.DESCRIPTION));
            recipientEmail = savedInstanceState.getStringArray(CatchoTags.RECIPIENT_EMAIL);
            smtpEmail = savedInstanceState.getString(CatchoTags.SMTP_EMAIL);
            password = savedInstanceState.getString(CatchoTags.PASSWORD);
        }
    }

    private void init() {
     // title = (EditText) findViewById(R.id.catcho_bug_title);
     // description = (EditText) findViewById(R.id.catcho_bug_description);
     // deviceInfo = (EditText) findViewById(R.id.catcho_device_info);
     // senderEmail = (EditText) findViewById(R.id.catcho_email);
     // FloatingActionButton sendButton = (FloatingActionButton) findViewById(R.id.catcho_fab_send);
     // if (sendButton != null) {
     //     sendButton.setOnClickListener(this);
     // }
     // Intent intent = getIntent();
     // if (intent != null) {
     //     mError = (CatchoError) intent.getSerializableExtra(Catcho.ERROR);
     //     emailMode = (CatchoTags.EmailMode) intent.getSerializableExtra(CatchoTags.EMAIL_MODE);
     //     recipientEmail = intent.getStringArrayExtra(CatchoTags.RECIPIENT_EMAIL);
     //     smtpEmail = intent.getStringExtra(CatchoTags.SMTP_EMAIL);
     //     password = intent.getStringExtra(CatchoTags.PASSWORD);
     //     deviceInfo.setText(mError.toString());

      //  }

    }

    @Override
    public void onClick(View view) {
       /* switch (emailMode) {*/
       /*     case DEFAULT:*/
       /*         sendEmailViaIntent();*/

       /*         break;*/
       /*     case G_MAIL_SENDER:*/
       /*         sendEmailViaSMTP();*/
       /*         break;*/
       /* }*/
    }

   /* private void sendEmailViaIntent() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, recipientEmail);
        i.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT, description.getText() + "\n" + mError);
        try {
            startActivity(Intent.createChooser(i, getResources().getString(R.string.catcho_send_email)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(CatchoReportActivity.this, getResources().getText(R.string.catcho_no_email_clients), Toast.LENGTH_SHORT).show();
        }
    }

    private void sendEmailViaSMTP() {

        try {
            GMailSender gMailSender = new GMailSender(smtpEmail, password);
            gMailSender.sendMail(title.getText().toString(), description.getText() + "\n" + mError, senderEmail.getText().toString(), recipientEmail);

        } catch (MessagingException e) {
            Toast.makeText(CatchoReportActivity.this, getResources().getText(R.string.catcho_err_send_msg), Toast.LENGTH_SHORT).show();
        }


    }


    public static Intent getCallingIntent(Context context, CatchoTags.EmailMode emailMode, String[] recipientEmail, String smtpEmail, String password, CatchoError errorReport) {
        Intent intent = new Intent(context, CatchoReportActivity.class);
        intent.putExtra(CatchoTags.EMAIL_MODE, emailMode);
        intent.putExtra(CatchoTags.RECIPIENT_EMAIL, recipientEmail);
        intent.putExtra(CatchoTags.SMTP_EMAIL, smtpEmail);
        intent.putExtra(CatchoTags.PASSWORD, password);
        intent.putExtra(Catcho.ERROR, errorReport);
        return intent;
    }*/
}
