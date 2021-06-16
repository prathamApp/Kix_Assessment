package com.kix.assessment.ui.surveyor_SignUP;

import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.kix.assessment.KIXApplication.contentDao;
import static com.kix.assessment.KIXApplication.surveyorDao;

@EFragment(R.layout.fragment_svr_sign_up)
public class Fragment_Svr_SignUp extends Fragment {

    @ViewById(R.id.et_svrName)
    EditText tv_svrName;
    @ViewById(R.id.et_svrEmail)
    EditText tv_svrEmail;
    @ViewById(R.id.et_svrMobile)
    EditText tv_svrMobile;
/*    @ViewById(R.id.spinner_booklet)
    Spinner spinner_booklet;*/
    @ViewById(R.id.et_svrPassword)
    TextInputEditText tv_svrPassword;

    @ViewById(R.id.ll_parentLayer)
    LinearLayout ll_parentLayout;

    ArrayList<String> booklet = new ArrayList<>();

    public Fragment_Svr_SignUp() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        List<String> bklt = contentDao.getBooklets();
        for (int i=0;i<bklt.size();i++){
            booklet.add(bklt.get(i));
            Log.e("KIX bklt: ",booklet.get(i));
        }
/*        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, booklet);
        spinner_booklet.setAdapter(spinnerArrayAdapter);*/
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
                modal_surveyor.setSvrName(tv_svrName.getText().toString());
                modal_surveyor.setSvrEmail(tv_svrEmail.getText().toString());
                modal_surveyor.setSvrMobile(tv_svrMobile.getText().toString());
                modal_surveyor.setSvrPassword(tv_svrPassword.getText().toString());
                modal_surveyor.setSvrCode(String.valueOf(KIX_Utility.getUUID()));
//                modal_surveyor.setSvr_Booklet(spinner_booklet.getSelectedItem().toString());
                modal_surveyor.setSentFlag(0);
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
