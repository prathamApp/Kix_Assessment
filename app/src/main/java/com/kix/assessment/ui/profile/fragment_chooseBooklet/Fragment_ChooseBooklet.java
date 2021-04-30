package com.kix.assessment.ui.profile.fragment_chooseBooklet;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.kix.assessment.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

import androidx.fragment.app.Fragment;

@EFragment(R.layout.fragment_choose_booklet)
public class Fragment_ChooseBooklet extends Fragment {

    @ViewById(R.id.spinner_country)
    Spinner spinner_country;

    @ViewById(R.id.spinner_language)
    Spinner spinner_language;

    @ViewById(R.id.spinner_booklet)
    Spinner spinner_booklet;

    public Fragment_ChooseBooklet() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        ArrayAdapter adapterCountry = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.spinner_country, R.layout.support_simple_spinner_dropdown_item);
        spinner_country.setAdapter(adapterCountry);
        ArrayAdapter adapterLanguage = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.spinner_language, R.layout.support_simple_spinner_dropdown_item);
        spinner_language.setAdapter(adapterLanguage);
        ArrayAdapter adapterBooklet = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.spinner_booklet, R.layout.support_simple_spinner_dropdown_item);
        spinner_booklet.setAdapter(adapterBooklet);
    }
}
