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
        mContext = getActivity();
        if (this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            this.EditState = this.EditDist = this.EditVil = 0;
            this.villageId = this.getArguments().getString(Kix_Constant.VILLAGE_ID);
            modalVillage = villageDao.getVillageByVillId(this.villageId);
            this.tv_TitleLBL.setText(getString(R.string.update_village));
/*            this.et_VillageName.setText(modalVillage.getVillageName());
            this.et_District.setText(modalVillage.getVillageDistrict());
            this.et_State.setText(modalVillage.getVillageState());*/
        } else {
            this.EditState = 1;
            this.EditDist = 1;
            this.EditVil = 1;
        }
        getStateList("state_lists", modalVillage);
        this.surveyorCode = this.getArguments().getString(Kix_Constant.SURVEYOR_CODE);
    }

    public void getStateList(String jsonName, Modal_Village modalVillage) {
        JSONArray jsonArr = null;
        try {
            //InputStream is = new FileInputStream(ApplicationClass.pradigiPath + "/.FCA/"+FastSave.getInstance().getString(FC_Constants.LANGUAGE, FC_Constants.HINDI)+"/RC/" + jasonName);
            InputStream is = mContext.getAssets().open("state_lists_jsons" + "/" + jsonName + ".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String jsonStr = new String(buffer);
//            jsonArr = new JSONArray(jsonStr);
            Gson gson = new Gson();
            Type type = new TypeToken<Modal_Location>() {
            }.getType();
            modal_location = gson.fromJson(jsonStr, type);
            //returnStoryNavigate = jsonObj.getJSONArray();
            setStates(modalVillage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @UiThread
    public void setStates(Modal_Village modalVillage) {
        this.StatesEpos = 0;
        this.DistEpos = 0;
        this.VillEpos = 0;
        String[] statesArray = new String[modal_location.getStateList().size()];
        for (int i = 0; i < modal_location.getStateList().size(); i++) {
            statesArray[i] = modal_location.getStateList().get(i).getStateName();
            if (getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
                if (modal_location.getStateList().get(i).getStateName()
                        .equalsIgnoreCase(modalVillage.getVillageState())) {
                    StatesEpos = i;
                    for (int j = 0; j < modal_location.getStateList().get(this.StatesEpos).getDistrictList().size(); j++) {
                        if (modal_location.getStateList().get(this.StatesEpos).getDistrictList().get(j).getDistrictName()
                                .equalsIgnoreCase(modalVillage.getVillageDistrict())) {
                            this.DistEpos = j;
                            for (int q = 0; q < modal_location.getStateList().get(this.StatesEpos)
                                    .getDistrictList().get(this.DistEpos).getVillageList().size(); q++) {
                                if (modal_location.getStateList().get(this.StatesEpos)
                                        .getDistrictList().get(this.DistEpos).getVillageList().get(q).getVillageName()
                                        .equalsIgnoreCase(modalVillage.getVillageName()))
                                    VillEpos = q;
                            }
                        }
                    }
                }
            }
        }
        adapterState = new ArrayAdapter(getActivity(), R.layout.spinner_item, statesArray);
        spn_State.setAdapter(adapterState);
        if (this.EditState < 1 && getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            this.EditState++;
            statePos = StatesEpos;
            spn_State.setSelection(statePos);
        }
        spn_State.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statePos = position;
                stateName = modal_location.getStateList().get(statePos).getStateName();
                setDistricts(statePos, modalVillage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @UiThread
    public void setDistricts(int statePos, Modal_Village modalVillage) {
        String[] districtsArray = new String[modal_location.getStateList().get(statePos).getDistrictList().size()];
        for (int i = 0; i < modal_location.getStateList().get(statePos).getDistrictList().size(); i++) {
            districtsArray[i] = modal_location.getStateList().get(statePos).getDistrictList().get(i).getDistrictName();
        }
        adapterDistrict = new ArrayAdapter(getActivity(), R.layout.spinner_item, districtsArray);
        spn_District.setAdapter(adapterDistrict);
        if (this.EditDist < 1 && getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            this.EditDist++;
            distPos = DistEpos;
            spn_District.setSelection(distPos);
        }
        spn_District.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                distPos = position;
                districtName = modal_location.getStateList().get(statePos)
                        .getDistrictList().get(distPos).getDistrictName();
                setVillages(distPos, modalVillage);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @UiThread
    public void setVillages(int distPoss, Modal_Village modalVillage) {
        this.distPos = distPos;
        String[] villageArray = new String[modal_location.getStateList().get(statePos)
                .getDistrictList().get(distPos).getVillageList().size()];
        for (int i = 0; i < modal_location.getStateList().get(statePos)
                .getDistrictList().get(distPos).getVillageList().size(); i++) {
            villageArray[i] = modal_location.getStateList().get(statePos)
                    .getDistrictList().get(distPos).getVillageList().get(i).getVillageName();
        }
        adapterVillage = new ArrayAdapter(getActivity(), R.layout.spinner_item, villageArray);
        spn_Village.setAdapter(adapterVillage);

        if (this.EditVil < 1 && getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            this.EditVil++;
            villPos = VillEpos;
            villageBooklet = modal_location.getStateList().get(statePos)
                    .getDistrictList().get(distPos).getVillageList().get(villPos).getContentBooklet();
            spn_Village.setSelection(villPos);
        }

        spn_Village.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                villPos = position;
                villageName = modal_location.getStateList().get(statePos)
                        .getDistrictList().get(distPos).getVillageList().get(villPos).getVillageName();
                villageBooklet = modal_location.getStateList().get(statePos)
                        .getDistrictList().get(distPos).getVillageList().get(villPos).getContentBooklet();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }

    @Click(R.id.btn_save)
    public void saveVillage() {

        FastSave.getInstance().saveString(Kix_Constant.BOOKLET, villageBooklet);

        if (this.getArguments().getString(Kix_Constant.EDIT_VILLAGE) != null) {
            villageDao.updateVillage(villageName,
                    districtName,
                    stateName,
                    this.villageId, FastSave.getInstance().getString(Kix_Constant.COUNTRY_NAME, "Hindi-India"),
                    villageBooklet);
            Toast.makeText(this.getActivity(), "Village Edited Successfully!", Toast.LENGTH_SHORT).show();
            this.getFragmentManager().popBackStack();
        } else
            this.insertVillage();
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
        final String villageID = KIX_Utility.getUUID().toString();
        final Modal_Village modalVillage = new Modal_Village();
        modalVillage.setVillageId("" + villageID);
        modalVillage.setVillageName(villageName);
        modalVillage.setVillageDistrict(districtName);
        modalVillage.setVillageState(stateName);
        modalVillage.setVillageDate("" + KIX_Utility.getCurrentDateTime());
        modalVillage.setVillageBooklet(villageBooklet);
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
/*
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
*/
    }

}
