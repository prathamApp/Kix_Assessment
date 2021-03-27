package com.kix.assessment.ui.Surveyor_SignIn;

import android.content.Intent;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

    @ViewById(R.id.et_email)
    EditText et_email;
    @ViewById(R.id.et_password)
    EditText et_password;
    @ViewById(R.id.rl_parentLayout)
    RelativeLayout rl_parentLayout;

    public Fragment_Svr_SignIn() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){

    }

    @Click(R.id.rl_parentLayout)
    public void hideKeyboard(){
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(getActivity()));
    }

    @Click(R.id.btn_signIn)
    public void signIn(){
        if(!et_email.getText().toString().isEmpty() && !et_password.getText().toString().isEmpty()){
            Modal_Surveyor surveyorLogin = KixDatabase.getDatabaseInstance(getActivity()).getSurveyorDao().getSurveyorLogin(et_email.getText().toString(),et_password.getText().toString());
            if (surveyorLogin == null) {
                Toast.makeText(getActivity(), "Invalid Email or Password.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getActivity(), Activity_Household_.class);
                intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorLogin.getSvr_Code());
                FastSave.getInstance().saveString(Kix_Constant.BOOKLET,surveyorLogin.getSvr_Booklet());
                startActivity(intent);
                Toast.makeText(getActivity(), "Login Success..", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Please Enter Email and Password!", Toast.LENGTH_SHORT).show();
        }
    }
}
