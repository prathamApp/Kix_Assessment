package com.kix.assessment.ui.surveyor_SignUP;

import static com.kix.assessment.KIXApplication.contentDao;
import static com.kix.assessment.KIXApplication.surveyorDao;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kix.assessment.R;
import com.kix.assessment.dbclasses.KixDatabase;
import com.kix.assessment.kix_utils.KIX_Utility;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.modal_classes.Modal_Sort_Booklet;
import com.kix.assessment.modal_classes.Modal_Surveyor;
import com.kix.assessment.services.shared_preferences.FastSave;
import com.kix.assessment.ui.Surveyor_SignIn.Fragment_Svr_SignIn;
import com.kix.assessment.ui.Surveyor_SignIn.Fragment_Svr_SignIn_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

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

    public static final boolean isValidEmail(final CharSequence email) {
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

        this.countryList = new ArrayList<>();
        this.countryList.add(this.getResources().getString(R.string.select_country));
        this.countryList.addAll(contentDao.getCountryList());

        this.adapterCountry = new ArrayAdapter<String>(this.getActivity(),R.layout.support_simple_spinner_dropdown_item, this.countryList);
        this.spinner_country.setAdapter(this.adapterCountry);

        this.spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                Fragment_Svr_SignUp.this.countryPos = position;
                Fragment_Svr_SignUp.this.mySelectedCountry = parent.getItemAtPosition(position).toString();
//                if(position>0) {
//                    setNewBooklet(""+parent.getItemAtPosition(position).toString());
//                }
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {

            }
        });

        this.tie_svrMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {
            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
            }

            @Override
            public void afterTextChanged(final Editable s) {
                if(s.length()<10)
                    Fragment_Svr_SignUp.this.til_svrMobile.setError("Mobile No. should be 10 digit.");
                else Fragment_Svr_SignUp.this.til_svrMobile.setError(null);
            }
        });

        this.tie_svrEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) { }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) { }

            @Override
            public void afterTextChanged(final Editable s) {
                if(!Fragment_Svr_SignUp.isValidEmail(s.toString())) Fragment_Svr_SignUp.this.til_svrEmail.setError("Invalid Email! (Ex. abc@gmail.com)");
                else Fragment_Svr_SignUp.this.til_svrEmail.setError(null);
            }
        });

        this.tie_svrPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) { }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) { }

            @Override
            public void afterTextChanged(final Editable s) {
                if(s.length()<3) Fragment_Svr_SignUp.this.til_svrPassword.setError("Minimum 3 characters required!");
                else Fragment_Svr_SignUp.this.til_svrPassword.setError(null);
            }
        });
    }

    @Click(R.id.ll_parentLayer)
    public void hideKeyboard(){
        KIX_Utility.HideInputKeypad(Objects.requireNonNull(this.getActivity()));
    }

    @Click(R.id.btn_svrSignUp)
    public void signUp() {
        if (!this.tie_svrName.getText().toString().isEmpty() && !this.tie_svrMobile.getText().toString().isEmpty()
                && !this.tie_svrPassword.getText().toString().isEmpty() && this.countryPos !=0) {
            if(Fragment_Svr_SignUp.isValidEmail(this.tie_svrEmail.getText().toString())) {
                if(this.tie_svrMobile.getText().toString().length()==10) {
                    if(this.tie_svrPassword.getText().toString().length()>=3) {
                        final Modal_Surveyor surveyor = KixDatabase.getDatabaseInstance(this.getActivity()).getSurveyorDao().getSurveyorByMobile(this.tie_svrMobile.getText().toString());
                        if (surveyor != null) {
                            Toast.makeText(this.getActivity(), "Profile is already saved..", Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                final Modal_Surveyor modal_surveyor = new Modal_Surveyor();
                                modal_surveyor.setSvrName(this.tie_svrName.getText().toString());
                                modal_surveyor.setSvrEmail(this.tie_svrEmail.getText().toString());
                                modal_surveyor.setSvrMobile(this.tie_svrMobile.getText().toString());
                                modal_surveyor.setSvrPassword(this.tie_svrPassword.getText().toString());
                                modal_surveyor.setSvrCode(String.valueOf(KIX_Utility.getUUID()));
//                                modal_surveyor.setSvrBooklet(spinner_booklet.getSelectedItem().toString());
                                modal_surveyor.setSvrRegistrationDate(KIX_Utility.getCurrentDateTime());
                                modal_surveyor.setSvrCountry(this.mySelectedCountry);
                                modal_surveyor.setSentFlag(0);
                                surveyorDao.insertSurveyor(modal_surveyor);

                                final String selectedLanguageCode = KIX_Utility.getLanguageCode(this.mySelectedCountry);
                                KIX_Utility.setMyLocale(this.getActivity(), FastSave.getInstance().getString(Kix_Constant.LANGUAGE_CODE, "en"), FastSave.getInstance().getString(Kix_Constant.COUNTRY_CODE, "IN"));
                                //                                Toast.makeText(getActivity(), "Signed Up Successfully!!", Toast.LENGTH_SHORT).show();
                                KIX_Utility.showFragment(this.getActivity(), new Fragment_Svr_SignIn_(), R.id.splash_frame,
                                        null, Fragment_Svr_SignIn.class.getSimpleName());
                            } catch (final Exception e){
                                Toast.makeText(this.getActivity(), "Invalid Data!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(this.getActivity(), "Minimum 3 characters required for Password!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this.getActivity(), "Invalid Mobile No.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this.getActivity(), "Invalid Email Id!", Toast.LENGTH_SHORT).show();
                this.til_svrEmail.setError("Invalid Email! (Ex. abc@gmail.com)");
            }
        } else {
            Toast.makeText(this.getActivity(), "All Fields Are Mandatory!!", Toast.LENGTH_SHORT).show();
        }
    }
}
