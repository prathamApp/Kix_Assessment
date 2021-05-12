package com.kix.assessment.ui.profile.fragment_setBooklet;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.kix.assessment.R;
import com.kix.assessment.kix_utils.Kix_Constant;
import com.kix.assessment.services.shared_preferences.FastSave;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.fragment.app.Fragment;

import static com.kix.assessment.KIXApplication.bookletDao;
import static com.kix.assessment.KIXApplication.countryDao;
import static com.kix.assessment.KIXApplication.languageDao;

@EFragment(R.layout.fragment_set_booklet)
public class Fragment_SetBooklet extends Fragment {

    @ViewById(R.id.set_spinner_country)
    Spinner spinner_country;

    @ViewById(R.id.set_spinner_language)
    Spinner spinner_language;

    @ViewById(R.id.set_spinner_booklet)
    Spinner spinner_booklet;

    ArrayList<String> booklet = new ArrayList<>();

    public Fragment_SetBooklet() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        List<String> countryList = countryDao.getCountryList();
        countryList.add(0,"Country");
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, countryList);
        spinner_country.setAdapter(adapterCountry);
    }

    @ItemSelect(R.id.set_spinner_country)
    public void countrySpinner(boolean sel){
        if(!(spinner_country.getSelectedItemPosition()==0)){
            List<String> languageList = languageDao.getLanguageList(spinner_country.getSelectedItem().toString());
            languageList.add(0,"Language");
            ArrayAdapter<String> adapterLanguage = new ArrayAdapter<String>
                    (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, languageList);
            spinner_language.setAdapter(adapterLanguage);
        }
    }

    @ItemSelect(R.id.set_spinner_language)
    public void languageSpinner(boolean sel){
        if(!(spinner_language.getSelectedItemPosition()==0)){
            List<String> bklt = bookletDao.bookletList(spinner_language.getSelectedItem().toString());
            bklt.add(0,"Booklet");
            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                    (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, bklt);
            spinner_booklet.setAdapter(spinnerArrayAdapter);
        }
    }


    @Click(R.id.btn_setBooklet)
    public void setBooklet(){
        Toast.makeText(getActivity(), "Booklet Set Successfully.", Toast.LENGTH_SHORT).show();
        FastSave.getInstance().saveString(Kix_Constant.BOOKLET,spinner_booklet.getSelectedItem().toString());
        Objects.requireNonNull(getActivity()).onBackPressed();
    }
}
