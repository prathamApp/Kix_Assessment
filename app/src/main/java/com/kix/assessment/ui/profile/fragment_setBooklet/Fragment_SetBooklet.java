package com.kix.assessment.ui.profile.fragment_setBooklet;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.kix.assessment.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.fragment.app.Fragment;

import static com.kix.assessment.KIXApplication.contentDao;

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
        ArrayAdapter adapterCountry = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.spinner_country, R.layout.support_simple_spinner_dropdown_item);
        spinner_country.setAdapter(adapterCountry);
        ArrayAdapter adapterLanguage = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.spinner_language, R.layout.support_simple_spinner_dropdown_item);
        spinner_language.setAdapter(adapterLanguage);

        List<String> bklt = contentDao.getBooklets();
        for (int i=0;i<bklt.size();i++){
            booklet.add(bklt.get(i));
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_dropdown_item, booklet);
        spinner_booklet.setAdapter(spinnerArrayAdapter);
    }
}
