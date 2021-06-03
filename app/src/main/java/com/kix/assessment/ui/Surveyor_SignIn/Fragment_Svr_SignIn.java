package com.kix.assessment.ui.Surveyor_SignIn;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.household_activity.Activity_Household_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

import androidx.fragment.app.Fragment;

@EFragment(R.layout.fragment_svr_sign_in)
public class Fragment_Svr_SignIn extends Fragment {

    @ViewById(R.id.tie_mobile)
    TextInputEditText et_mobile;
    @ViewById(R.id.tie_password)
    TextInputEditText et_password;
    @ViewById(R.id.rl_parentLayout)
    RelativeLayout rl_parentLayout;

    @ViewById(R.id.til_svrMobile)
    TextInputLayout til_svrMobile;

    public Fragment_Svr_SignIn() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        et_mobile.addTextChangedListener(new TextWatcher() {
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
    }

    @Click(R.id.rl_parentLayout)
    public void hideKeyboard(){
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(getActivity()));
    }

    @Click(R.id.btn_signIn)
    public void signIn(){
        if(!et_mobile.getText().toString().isEmpty() && !et_password.getText().toString().isEmpty()){
            Modal_Surveyor surveyorLogin = KixDatabase.getDatabaseInstance(getActivity()).getSurveyorDao().getSurveyorLogin(et_mobile.getText().toString(),et_password.getText().toString());
            if (surveyorLogin == null) {
                Toast.makeText(getActivity(), "Invalid Mobile No. or Password.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getActivity(), Activity_Household_.class);
                intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorLogin.getSvrCode());
                FastSave.getInstance().saveString(Kix_Constant.BOOKLET,surveyorLogin.getSvrBooklet());
                FastSave.getInstance().saveString(Kix_Constant.SURVEYOR_NAME,surveyorLogin.getSvrName());
                FastSave.getInstance().saveString(Kix_Constant.SURVEYOR_CODE,surveyorLogin.getSvrCode());
                startActivity(intent);
                Toast.makeText(getActivity(), "Login Success..", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Please Enter Mobile No. and Password!", Toast.LENGTH_SHORT).show();
        }
    }
}
