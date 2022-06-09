package com.kix.assessment.ui.village_activity;

import static com.kix.assessment.KIXApplication.villageDao;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.BackupDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Location;
import com.kix.assessment.modal_classes.Modal_Village;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.json.JSONArray;

import java.io.InputStream;
import java.lang.reflect.Type;

@EFragment(R.layout.fragment_add_village)
public class Fragment_AddVillage extends Fragment {

    @ViewById(R.id.spn_Village)
    Spinner spn_Village;
    @ViewById(R.id.spn_District)
    Spinner spn_District;
    @ViewById(R.id.spn_State)
    Spinner spn_State;
    /*
        @ViewById(R.id.et_VillageName)
        TextInputEditText et_VillageName;
        @ViewById(R.id.et_District)
        TextInputEditText et_District;
        @ViewById(R.id.et_State)
        TextInputEditText et_State;
    */
    @ViewById(R.id.tv_TitleLBL)
    TextView tv_TitleLBL;

    Modal_Location modal_location;
    String surveyorCode, villageId, selectedLanguageCode;
    String stateName, villageName, districtName, villageBooklet;
    ArrayAdapter adapterCountry;
    ArrayAdapter adapterVillage, adapterDistrict, adapterState;
    Modal_Village modalVillage;
    Context mContext;
    int statePos, distPos, villPos, EditState, EditDist, EditVil;

    public Fragment_AddVillage() {
        // Required empty public constructor
    }
    int StatesEpos, DistEpos, VillEpos;

    @AfterViews
    public void initialize() {
        this.mContext = this.getActivity();
        if (getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            EditState = EditDist = EditVil = 0;
            villageId = getArguments().getString(Kix_Constant.VILLAGE_ID);
            this.modalVillage = villageDao.getVillageByVillId(villageId);
            tv_TitleLBL.setText(this.getString(R.string.update_village));
/*            this.et_VillageName.setText(modalVillage.getVillageName());
            this.et_District.setText(modalVillage.getVillageDistrict());
            this.et_State.setText(modalVillage.getVillageState());*/
        } else {
            EditState = 1;
            EditDist = 1;
            EditVil = 1;
        }
        this.getStateList("state_lists", this.modalVillage);
        surveyorCode = getArguments().getString(Kix_Constant.SURVEYOR_CODE);
    }

    public void getStateList(final String jsonName, final Modal_Village modalVillage) {
        final JSONArray jsonArr = null;
        try {
            //InputStream is = new FileInputStream(ApplicationClass.pradigiPath + "/.FCA/"+FastSave.getInstance().getString(FC_Constants.LANGUAGE, FC_Constants.HINDI)+"/RC/" + jasonName);
            final InputStream is = this.mContext.getAssets().open("state_lists_jsons" + "/" + jsonName + ".json");
            final int size = is.available();
            final byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            final String jsonStr = new String(buffer);
//            jsonArr = new JSONArray(jsonStr);
            final Gson gson = new Gson();
            final Type type = new TypeToken<Modal_Location>() {
            }.getType();
            this.modal_location = gson.fromJson(jsonStr, type);
            //returnStoryNavigate = jsonObj.getJSONArray();
            this.setStates(modalVillage);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    @UiThread
    public void setStates(final Modal_Village modalVillage) {
        StatesEpos = 0;
        DistEpos = 0;
        VillEpos = 0;
        final String[] statesArray = new String[this.modal_location.getStateList().size()];
        for (int i = 0; i < this.modal_location.getStateList().size(); i++) {
            statesArray[i] = this.modal_location.getStateList().get(i).getStateName();
            if (this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
                if (this.modal_location.getStateList().get(i).getStateName()
                        .equalsIgnoreCase(modalVillage.getVillageState())) {
                    this.StatesEpos = i;
                    for (int j = 0; j < this.modal_location.getStateList().get(StatesEpos).getDistrictList().size(); j++) {
                        if (this.modal_location.getStateList().get(StatesEpos).getDistrictList().get(j).getDistrictName()
                                .equalsIgnoreCase(modalVillage.getVillageDistrict())) {
                            DistEpos = j;
                            for (int q = 0; q < this.modal_location.getStateList().get(StatesEpos)
                                    .getDistrictList().get(DistEpos).getVillageList().size(); q++) {
                                if (this.modal_location.getStateList().get(StatesEpos)
                                        .getDistrictList().get(DistEpos).getVillageList().get(q).getVillageName()
                                        .equalsIgnoreCase(modalVillage.getVillageName()))
                                    this.VillEpos = q;
                            }
                        }
                    }
                }
            }
        }
        this.adapterState = new ArrayAdapter(this.getActivity(), R.layout.spinner_item, statesArray);
        this.spn_State.setAdapter(this.adapterState);
        if (EditState < 1 && this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            EditState++;
            this.statePos = this.StatesEpos;
            this.spn_State.setSelection(this.statePos);
        }
        this.spn_State.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                Fragment_AddVillage.this.statePos = position;
                Fragment_AddVillage.this.stateName = Fragment_AddVillage.this.modal_location.getStateList().get(Fragment_AddVillage.this.statePos).getStateName();
                Fragment_AddVillage.this.setDistricts(Fragment_AddVillage.this.statePos, modalVillage);
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {

            }
        });
    }

    @UiThread
    public void setDistricts(final int statePos, final Modal_Village modalVillage) {
        final String[] districtsArray = new String[this.modal_location.getStateList().get(statePos).getDistrictList().size()];
        for (int i = 0; i < this.modal_location.getStateList().get(statePos).getDistrictList().size(); i++) {
            districtsArray[i] = this.modal_location.getStateList().get(statePos).getDistrictList().get(i).getDistrictName();
        }
        this.adapterDistrict = new ArrayAdapter(this.getActivity(), R.layout.spinner_item, districtsArray);
        this.spn_District.setAdapter(this.adapterDistrict);
        if (EditDist < 1 && this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            EditDist++;
            this.distPos = this.DistEpos;
            this.spn_District.setSelection(this.distPos);
        }
        this.spn_District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                Fragment_AddVillage.this.distPos = position;
                Fragment_AddVillage.this.districtName = Fragment_AddVillage.this.modal_location.getStateList().get(statePos)
                        .getDistrictList().get(Fragment_AddVillage.this.distPos).getDistrictName();
                Fragment_AddVillage.this.setVillages(Fragment_AddVillage.this.distPos, modalVillage);
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {

            }
        });
    }

    @UiThread
    public void setVillages(final int distPoss, final Modal_Village modalVillage) {
        distPos = this.distPos;
        final String[] villageArray = new String[this.modal_location.getStateList().get(this.statePos)
                .getDistrictList().get(this.distPos).getVillageList().size()];
        for (int i = 0; i < this.modal_location.getStateList().get(this.statePos)
                .getDistrictList().get(this.distPos).getVillageList().size(); i++) {
            villageArray[i] = this.modal_location.getStateList().get(this.statePos)
                    .getDistrictList().get(this.distPos).getVillageList().get(i).getVillageName();
        }
        this.adapterVillage = new ArrayAdapter(this.getActivity(), R.layout.spinner_item, villageArray);
        this.spn_Village.setAdapter(this.adapterVillage);

        if (EditVil < 1 && this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            EditVil++;
            this.villPos = this.VillEpos;
//            villageBooklet = modal_location.getStateList().get(statePos)
//                    .getDistrictList().get(distPos).getVillageList().get(villPos).getContentBooklet();
            this.spn_Village.setSelection(this.villPos);
        }

        this.spn_Village.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                Fragment_AddVillage.this.villPos = position;
                Fragment_AddVillage.this.villageName = Fragment_AddVillage.this.modal_location.getStateList().get(Fragment_AddVillage.this.statePos)
                        .getDistrictList().get(Fragment_AddVillage.this.distPos).getVillageList().get(Fragment_AddVillage.this.villPos).getVillageName();
//                villageBooklet = modal_location.getStateList().get(statePos)
//                        .getDistrictList().get(distPos).getVillageList().get(villPos).getContentBooklet();
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }

        });
    }

    @Click(R.id.btn_save)
    public void saveVillage() {

        FastSave.getInstance().saveString(Kix_Constant.BOOKLET, this.villageBooklet);

        if (getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            villageDao.updateVillage(this.villageName,
                    this.districtName,
                    this.stateName,
                    villageId, FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India"),
                    this.villageBooklet);
            Toast.makeText(getActivity(), getString(R.string.vill_Updated_success), Toast.LENGTH_SHORT).show();
            getFragmentManager().popBackStack();
        } else
            insertVillage();
/*
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
*/
//            Toast.makeText(this.getActivity(), "All fields are mandatory!", Toast.LENGTH_SHORT).show();
    }

    private void insertVillage() {
        String villageID = KIX_Utility.getUUID().toString();
        Modal_Village modalVillage = new Modal_Village();
        modalVillage.setVillageId("" + villageID);
        modalVillage.setVillageName(this.villageName);
        modalVillage.setVillageDistrict(this.districtName);
        modalVillage.setVillageState(this.stateName);
        modalVillage.setCreatedOn("" + KIX_Utility.getCurrentDateTime());
        modalVillage.setVillageBooklet(this.villageBooklet);
        modalVillage.setSvrCode(surveyorCode);
        modalVillage.setCountryName(FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India"));
        modalVillage.setSentFlag(0);
        villageDao.insertVillage(modalVillage);
        BackupDatabase.backup(getActivity());
        Toast.makeText(getActivity(), getString(R.string.vill_added_success), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), Activity_Village_.class);
        intent.putExtra(Kix_Constant.SURVEYOR_CODE, surveyorCode);
        intent.putExtra(Kix_Constant.VILLAGE_ID, villageID);
        startActivity(intent);
/*
        final String villageID = KIX_Utility.getUUID().toString();
        final Modal_Village modalVillage = new Modal_Village();
        modalVillage.setVillageId("" + villageID);
        modalVillage.setVillageName(this.et_VillageName.getText().toString());
        modalVillage.setVillageDistrict(this.et_District.getText().toString());
        modalVillage.setVillageState(this.et_State.getText().toString());
        modalVillage.setCreatedOn("" + KIX_Utility.getCurrentDateTime());
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
*/
    }

}
