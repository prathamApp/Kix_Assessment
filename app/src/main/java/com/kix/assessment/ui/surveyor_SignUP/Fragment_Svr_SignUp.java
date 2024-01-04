package com.kix.assessment.ui.surveyor_SignUP;

import static com.kix.assessment.KIXApplication.surveyorDao;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.MSAT.Model_Country;
import com.kix.assessment.modal_classes.Modal_Sort_Booklet;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.Surveyor_SignIn.Fragment_Svr_SignIn;
import com.kix.assessment.ui.Surveyor_SignIn.Fragment_Svr_SignIn_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EFragment(R.layout.fragment_svr_sign_up)
public class Fragment_Svr_SignUp extends Fragment {

    @ViewById(R.id.et_svrName)
    TextInputEditText tie_svrName;
    @ViewById(R.id.et_svrEmail)
    TextInputEditText tie_svrEmail;
    @ViewById(R.id.et_svrMobile)
    TextInputEditText tie_svrMobile;
//    @ViewById(R.id.spinner_booklet)
//    Spinner spinner_booklet;
    @ViewById(R.id.spinner_country)
    Spinner spinner_country;
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
//    @ViewById(R.id.ll_spinnerBooklet)
//    LinearLayout ll_spinnerBooklet;

    ArrayList<String> booklet = new ArrayList<>();
    ArrayList<String> countryList = new ArrayList<>();
    List<Modal_Sort_Booklet> modal_sort_bookletList = new ArrayList<>();
    ArrayAdapter<String> spinnerArrayAdapter;
    ArrayAdapter<String> adapterCountry;
    int countryPos;
    String mySelectedCountry = "NA";

    public Fragment_Svr_SignUp() {
        // Required empty public constructor
    }

    public static final boolean isValidEmail(CharSequence email) {
        if(email.toString().isEmpty()) return true;
        else return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

/*
    public void setNewBooklet(String selectedCountry) {
        ll_spinnerBooklet.setVisibility(View.VISIBLE);
        mySelectedCountry = selectedCountry;
        FastSave.getInstance().saveString(Kix_Constant.COUNTRY_NAME, mySelectedCountry);
        booklet = new ArrayList<>();
        booklet = (ArrayList<String>) contentDao.getBooklets(mySelectedCountry);
        Modal_Sort_Booklet modal_sort_booklet;
        for(int i=0; i<booklet.size(); i++) {
            String[] separated = booklet.get(i).split(" ");
            modal_sort_booklet = new Modal_Sort_Booklet();
            modal_sort_booklet.setBooklet_Name(booklet.get(i));
            modal_sort_booklet.setBooklet_No(Integer.parseInt(separated[1]));
            modal_sort_bookletList.add(modal_sort_booklet);
        }

        Collections.sort(modal_sort_bookletList, (o1, o2) -> o1.getBooklet_No() - o2.getBooklet_No());
        booklet= new ArrayList<>();

        for (int j=0;j<modal_sort_bookletList.size();j++)
            booklet.add(modal_sort_bookletList.get(j).booklet_Name);
        if(spinnerArrayAdapter == null) {
            spinnerArrayAdapter = new ArrayAdapter<String>
                    (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, booklet);
            spinner_booklet.setAdapter(spinnerArrayAdapter);
        }else{
            spinnerArrayAdapter.notifyDataSetChanged();
        }

    }
*/

    @AfterViews
    public void initialize() {
//        ll_spinnerBooklet.setVisibility(View.GONE);

        countryList = new ArrayList<>();
        countryList.add(getResources().getString(R.string.select_country));
        //this.countryList.addAll(contentDao.getCountryList());

        try {
            final Model_Country countryName;
            final String jsonStr = KIX_Utility.getDataJsonAsString(this.getActivity());
            final Gson gson = new Gson();
            final Type type = new TypeToken<Model_Country>() {
            }.getType();

            countryName = gson.fromJson(jsonStr, type);
            this.countryList.add(countryName.getCountry());
            Log.e("CountryName : ", this.countryList.toString());

        } catch (final Exception e){
            e.printStackTrace();
        }

        adapterCountry = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item, countryList);
        spinner_country.setAdapter(adapterCountry);

        spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryPos = position;
                mySelectedCountry = parent.getItemAtPosition(position).toString();
//                if(position>0) {
//                    setNewBooklet(""+parent.getItemAtPosition(position).toString());
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tie_svrMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()<8)
                    til_svrMobile.setError(Fragment_Svr_SignUp.this.getString(R.string.error_mobile_no));
                else til_svrMobile.setError(null);
            }
        });

        tie_svrEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if(!isValidEmail(s.toString())) til_svrEmail.setError(Fragment_Svr_SignUp.this.getString(R.string.error_email));
                else til_svrEmail.setError(null);
            }
        });

        tie_svrPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()<3) til_svrPassword.setError(Fragment_Svr_SignUp.this.getString(R.string.error_password));
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
                && !tie_svrPassword.getText().toString().isEmpty() && countryPos !=0) {
            if(isValidEmail(tie_svrEmail.getText().toString())) {
                if(this.tie_svrMobile.getText().toString().length()>=7 && this.tie_svrMobile.getText().toString().length()<=20) {
                    if(tie_svrPassword.getText().toString().length()>=3) {
                        Modal_Surveyor surveyor = KixDatabase.getDatabaseInstance(getActivity()).getSurveyorDao().getSurveyorByMobile(tie_svrMobile.getText().toString());
                        if (surveyor != null) {
                            Toast.makeText(getActivity(), this.getString(R.string.profile_already), Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                Modal_Surveyor modal_surveyor = new Modal_Surveyor();
                                modal_surveyor.setSvrName(tie_svrName.getText().toString());
                                modal_surveyor.setSvrEmail(tie_svrEmail.getText().toString());
                                modal_surveyor.setSvrMobile(tie_svrMobile.getText().toString());
                                modal_surveyor.setSvrPassword(tie_svrPassword.getText().toString());
                                modal_surveyor.setSvrCode(String.valueOf(KIX_Utility.getUUID()));
//                                modal_surveyor.setSvrBooklet(spinner_booklet.getSelectedItem().toString());
                                modal_surveyor.setSvrRegistrationDate(KIX_Utility.getCurrentDateTime());
                                modal_surveyor.setSvrCountry(mySelectedCountry);
                                modal_surveyor.setDeviceId(KIX_Utility.getDeviceID());
                                modal_surveyor.setSentFlag(0);
                                surveyorDao.insertSurveyor(modal_surveyor);

                                String selectedLanguageCode = KIX_Utility.getLanguageCode(mySelectedCountry);
                                KIX_Utility.setMyLocale(getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
                                //                                Toast.makeText(getActivity(), "Signed Up Successfully!!", Toast.LENGTH_SHORT).show();
                                KIX_Utility.showFragment(getActivity(), new Fragment_Svr_SignIn_(), R.id.splash_frame,
                                        null, Fragment_Svr_SignIn.class.getSimpleName());
                            } catch (Exception e){
                                Toast.makeText(getActivity(), this.getString(R.string.invalid_data), Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(getActivity(), this.getString(R.string.error_password), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), this.getString(R.string.error_mobile_no), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), this.getString(R.string.error_email), Toast.LENGTH_SHORT).show();
                til_svrEmail.setError(this.getString(R.string.error_email));
            }
        } else {
            Toast.makeText(getActivity(), this.getString(R.string.all_fields_mandatory), Toast.LENGTH_SHORT).show();
        }
    }
}
