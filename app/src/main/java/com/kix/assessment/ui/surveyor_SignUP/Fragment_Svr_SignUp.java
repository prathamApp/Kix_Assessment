package com.kix.assessment.ui.surveyor_SignUP;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
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

import java.util.Objects;

import androidx.fragment.app.Fragment;

import static com.kix.assessment.KIXApplication.surveyorDao;

@EFragment(R.layout.fragment_svr_sign_up)
public class Fragment_Svr_SignUp extends Fragment {

    @ViewById(R.id.et_svrName)
    EditText tv_svrName;
    @ViewById(R.id.et_svrEmail)
    EditText tv_svrEmail;
    @ViewById(R.id.et_svrMobile)
    EditText tv_svrMobile;
    @ViewById(R.id.spinner_booklet)
    Spinner spinner_booklet;
    @ViewById(R.id.et_svrPassword)
    TextInputEditText tv_svrPassword;

    @ViewById(R.id.ll_parentLayer)
    LinearLayout ll_parentLayout;

    public Fragment_Svr_SignUp() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        spinner_booklet.setAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.spinner_booklet, R.layout.support_simple_spinner_dropdown_item));
    }

    @Click(R.id.ll_parentLayer)
    public void hideKeyboard(){
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(getActivity()));
    }

    @Click(R.id.btn_svrSignUp)
    public void signUp() {
        if (!tv_svrName.getText().toString().isEmpty() && !tv_svrEmail.getText().toString().isEmpty()
                && !tv_svrMobile.getText().toString().isEmpty() && !tv_svrPassword.getText().toString().isEmpty()) {

            Modal_Surveyor surveyor = KixDatabase.getDatabaseInstance(getActivity()).getSurveyorDao().getSurveyorByEmail(tv_svrEmail.getText().toString());
            if (surveyor != null) {
                Toast.makeText(getActivity(), "Profile is already saved..", Toast.LENGTH_SHORT).show();
            } else {
                Modal_Surveyor modal_surveyor = new Modal_Surveyor();
                modal_surveyor.setSvr_Name(tv_svrName.getText().toString());
                modal_surveyor.setSvr_Email(tv_svrEmail.getText().toString());
                modal_surveyor.setSvr_Mobile(tv_svrMobile.getText().toString());
                modal_surveyor.setSvr_Password(tv_svrPassword.getText().toString());
                modal_surveyor.setSvr_Code(String.valueOf(KIX_Utility.getUUID()));
                modal_surveyor.setSvr_Booklet(spinner_booklet.getSelectedItem().toString());
                surveyorDao.insertSurveyor(modal_surveyor);
                BackupDatabase.backup(getActivity());
                Toast.makeText(getActivity(), "Signed Up Successfully!!", Toast.LENGTH_SHORT).show();
                KIX_Utility.showFragment(getActivity(), new Fragment_Svr_SignIn_(), R.id.splash_frame,
                        null, Fragment_Svr_SignIn.class.getSimpleName());
            }
        } else {
            Toast.makeText(getActivity(), "All Fields Are Mandatory!!", Toast.LENGTH_SHORT).show();
        }
    }
}
