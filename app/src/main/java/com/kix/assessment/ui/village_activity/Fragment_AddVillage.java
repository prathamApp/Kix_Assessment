package com.kix.assessment.ui.village_activity;

import static com.kix.assessment.KIXApplication.villageDao;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_add_village)
public class Fragment_AddVillage extends Fragment {

    @ViewById(R.id.et_VillageName)
    TextInputEditText et_VillageName;
    @ViewById(R.id.et_District)
    TextInputEditText et_District;
    @ViewById(R.id.et_State)
    TextInputEditText et_State;

    @ViewById(R.id.tv_TitleLBL)
    TextView tv_TitleLBL;
    String surveyorCode, villageId, selectedLanguageCode;
    ArrayAdapter adapterCountry;

    public Fragment_AddVillage() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize() {
        if (this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            this.villageId = this.getArguments().getString(Kix_Constant.VILLAGE_ID);
            final Modal_Village modalVillage = villageDao.getVillageByVillId(this.villageId);
            this.tv_TitleLBL.setText("Edit Village");
            this.et_VillageName.setText(modalVillage.getVillageName());
            this.et_District.setText(modalVillage.getVillageDistrict());
            this.et_State.setText(modalVillage.getVillageState());
        }
        this.surveyorCode = this.getArguments().getString(Kix_Constant.SURVEYOR_CODE);
    }

    @Click(R.id.btn_save)
    public void saveVillage() {
        if (!this.et_VillageName.getText().toString().isEmpty() && !this.et_District.getText().toString().isEmpty()
                && !this.et_State.getText().toString().isEmpty()) {
            if (this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
                villageDao.updateVillage(this.et_VillageName.getText().toString(),
                        this.et_District.getText().toString(),
                        this.et_State.getText().toString(),
                        this.villageId, FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India"));
                Toast.makeText(this.getActivity(), "Village Edited Successfully!", Toast.LENGTH_SHORT).show();
                this.getFragmentManager().popBackStack();
            }else
                this.insertVillage();
        } else
            Toast.makeText(this.getActivity(), "All fields are mandatory!", Toast.LENGTH_SHORT).show();
    }

    private void insertVillage() {
        final String villageID = KIX_Utility.getUUID().toString();
        final Modal_Village modalVillage = new Modal_Village();
        modalVillage.setVillageId("" + villageID);
        modalVillage.setVillageName(this.et_VillageName.getText().toString());
        modalVillage.setVillageDistrict(this.et_District.getText().toString());
        modalVillage.setVillageState(this.et_State.getText().toString());
        modalVillage.setVillageDate("" + KIX_Utility.getCurrentDateTime());
        modalVillage.setSvrCode(this.surveyorCode);
        modalVillage.setCountryName(FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India"));
        modalVillage.setSentFlag(0);
        villageDao.insertVillage(modalVillage);
        BackupDatabase.backup(this.getActivity());
        Toast.makeText(this.getActivity(), "Village Added Successfully!", Toast.LENGTH_SHORT).show();
        final Intent intent = new Intent(this.getActivity(), Activity_Village_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, this.surveyorCode);
        intent.putExtra(Kix_Constant.VILLAGE_ID, villageID);
        this.startActivity(intent);
    }

}
