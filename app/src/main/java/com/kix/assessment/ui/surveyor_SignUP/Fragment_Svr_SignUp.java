package com.kix.assessment.ui.surveyor_SignUP;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.ui.Surveyor_SignIn.Fragment_Svr_SignIn;
import com.kix.assessment.ui.Surveyor_SignIn.Fragment_Svr_SignIn_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Objects;

import androidx.fragment.app.Fragment;

import static com.kix.assessment.KIXApplication.contentDao;
import static com.kix.assessment.KIXApplication.surveyorDao;

@EFragment(R.layout.fragment_svr_sign_up)
public class Fragment_Svr_SignUp extends Fragment {

    @ViewById(R.id.et_svrName)
    TextInputEditText tie_svrName;
    @ViewById(R.id.et_svrEmail)
    TextInputEditText tie_svrEmail;
    @ViewById(R.id.et_svrMobile)
    TextInputEditText tie_svrMobile;
    @ViewById(R.id.spinner_booklet)
    Spinner spinner_booklet;
    @ViewById(R.id.et_svrPassword)
    TextInputEditText tie_svrPassword;

    @ViewById(R.id.til_svrName)
    TextInputLayout til_svrName;
    @ViewById(R.id.til_svrEmail)
    TextInputLayout til_svrEmail;
    @ViewById(R.id.til_svrMobile)
    TextInputLayout til_svrMobile;
    @ViewById(R.id.til_svrPassword)
    TextInputLayout til_svrPassword;

    @ViewById(R.id.ll_parentLayer)
    LinearLayout ll_parentLayout;

    ArrayList<String> booklet = new ArrayList<>();

    public Fragment_Svr_SignUp() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        booklet = (ArrayList<String>) contentDao.getBooklets();
        //todo : delete after testing
/*        for (int i=0;i<bklt.size();i++){
            booklet.add(bklt.get(i));
            Log.e("KIX bklt: ",booklet.get(i));
        }*/
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, booklet);
        spinner_booklet.setAdapter(spinnerArrayAdapter);

        tie_svrMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()<10)
                    til_svrMobile.setError("Mobile No. should be 10 digit.");
                else til_svrMobile.setError(null);
            }
        });

        tie_svrEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!isValidEmail(s.toString())) til_svrEmail.setError("Invalid Email! (Ex. abc@gmail.com)");
                else til_svrEmail.setError(null);
            }
        });

        tie_svrPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()<3) til_svrPassword.setError("Minimum 3 characters required!");
                else til_svrPassword.setError(null);
            }
        });
    }

    @Click(R.id.ll_parentLayer)
    public void hideKeyboard(){
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(getActivity()));
    }

    @Click(R.id.btn_svrSignUp)
    public void signUp() {
        if (!tie_svrName.getText().toString().isEmpty() && !tie_svrMobile.getText().toString().isEmpty()
                && !tie_svrPassword.getText().toString().isEmpty()) {
            if(isValidEmail(tie_svrEmail.getText().toString())) {
                if(tie_svrMobile.getText().toString().length()==10) {
                    if(tie_svrPassword.getText().toString().length()>=3) {
                        Modal_Surveyor surveyor = KixDatabase.getDatabaseInstance(getActivity()).getSurveyorDao().getSurveyorByMobile(tie_svrMobile.getText().toString());
                        if (surveyor != null) {
                            Toast.makeText(getActivity(), "Profile is already saved..", Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                Modal_Surveyor modal_surveyor = new Modal_Surveyor();
                                modal_surveyor.setSvrName(tie_svrName.getText().toString());
                                modal_surveyor.setSvrEmail(tie_svrEmail.getText().toString());
                                modal_surveyor.setSvrMobile(tie_svrMobile.getText().toString());
                                modal_surveyor.setSvrPassword(tie_svrPassword.getText().toString());
                                modal_surveyor.setSvrCode(String.valueOf(KIX_Utility.getUUID()));
                                modal_surveyor.setSvrBooklet(spinner_booklet.getSelectedItem().toString());
                                modal_surveyor.setSentFlag(0);
                                surveyorDao.insertSurveyor(modal_surveyor);
                                BackupDatabase.backup(getActivity());
                                Toast.makeText(getActivity(), "Signed Up Successfully!!", Toast.LENGTH_SHORT).show();
                                KIX_Utility.showFragment(getActivity(), new Fragment_Svr_SignIn_(), R.id.splash_frame,
                                        null, Fragment_Svr_SignIn.class.getSimpleName());
                            } catch (Exception e){
                                Toast.makeText(getActivity(), "Booklet Not Found!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(getActivity(), "Minimum 3 characters required for Password!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Invalid Mobile No.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "Invalid Email Id!", Toast.LENGTH_SHORT).show();
                til_svrEmail.setError("Invalid Email! (Ex. abc@gmail.com)");
            }
        } else {
            Toast.makeText(getActivity(), "All Fields Are Mandatory!!", Toast.LENGTH_SHORT).show();
        }
    }

    public final static boolean isValidEmail(CharSequence email) {
        if(email.toString().isEmpty()) return true;
        else return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
