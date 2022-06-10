package com.kix.assessment.ui.Surveyor_SignIn;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.village_activity.Activity_Village_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

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
        this.et_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {

            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                if(s.length()<8)
                    Fragment_Svr_SignIn.this.til_svrMobile.setError(getString(R.string.error_mobile_no));
                else Fragment_Svr_SignIn.this.til_svrMobile.setError(null);
            }
        });
    }

    @Click(R.id.rl_parentLayout)
    public void hideKeyboard(){
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(this.getActivity()));
    }

    @Click(R.id.btn_signIn)
    public void signIn(){
        FastSave.getInstance().saveString(Kix_Constant.SESSIONID, "NA");
        if(!this.et_mobile.getText().toString().isEmpty() && !this.et_password.getText().toString().isEmpty()){
            final Modal_Surveyor surveyorLogin = KixDatabase.getDatabaseInstance(this.getActivity()).getSurveyorDao().getSurveyorLogin(this.et_mobile.getText().toString(), this.et_password.getText().toString());
            if (surveyorLogin == null) {
                Toast.makeText(this.getActivity(), this.getString(R.string.invalid_mobno_pass), Toast.LENGTH_SHORT).show();
            } else {
/*
                Intent intent = new Intent(getActivity(), Activity_Household_.class);
                intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorLogin.getSvrCode());
                FastSave.getInstance().saveString(Kix_Constant.BOOKLET,surveyorLogin.getSvrBooklet());
                FastSave.getInstance().saveString(Kix_Constant.SURVEYOR_NAME,surveyorLogin.getSvrName());
                FastSave.getInstance().saveString(Kix_Constant.SURVEYOR_CODE,surveyorLogin.getSvrCode());
                String selectedCountryName = KIX_Utility.getLanguageCode(surveyorLogin.getSvrCountry());
                FastSave.getInstance().saveString(Kix_Constant.COUNTRY_NAME, surveyorLogin.getSvrCountry());
                KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
                startActivity(intent);
*/
                final Intent intent = new Intent(this.getActivity(), Activity_Village_.class);
                intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorLogin.getSvrCode());
//                FastSave.getInstance().saveString(Kix_Constant.BOOKLET,surveyorLogin.getSvrBooklet());
                FastSave.getInstance().saveString(Kix_Constant.SURVEYOR_NAME,surveyorLogin.getSvrName());
                FastSave.getInstance().saveString(Kix_Constant.SURVEYOR_CODE,surveyorLogin.getSvrCode());
                final String selectedCountryName = KIX_Utility.getLanguageCode(surveyorLogin.getSvrCountry());
                FastSave.getInstance().saveString(Kix_Constant.COUNTRY_NAME, surveyorLogin.getSvrCountry());
                KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
                this.startActivity(intent);
            }
        } else {
            Toast.makeText(this.getActivity(), this.getString(R.string.enter_mobno_pass), Toast.LENGTH_SHORT).show();
        }
    }
}
