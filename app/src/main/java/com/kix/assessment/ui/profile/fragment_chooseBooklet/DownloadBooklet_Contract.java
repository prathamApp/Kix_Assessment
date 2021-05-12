package com.kix.assessment.ui.profile.fragment_chooseBooklet;

import com.kix.assessment.modal_classes.Modal_Booklet;
import com.kix.assessment.modal_classes.Modal_Country;
import com.kix.assessment.modal_classes.Modal_Language;

import java.util.List;

public interface DownloadBooklet_Contract {

    interface DownloadBookletView{

        void showLoader();

        void fillCountrySpinner(List<Modal_Country> countryList);

        void fillLanguageSpinner(List<Modal_Language> languageList);

        void fillBookletSpinner(List<Modal_Booklet> bookletList);

        void dismissLoadingDialog();

        void dismissDownloadDialog();
    }

    interface DownloadBookletPresenter {

        void setView(DownloadBooklet_Contract.DownloadBookletView downloadBookletView);

        void downloadBooklet(String nodeID);

        void fetchCountries(String countryURL);

        void fetchLanguages(String languageURL, String countryName);

        void fetchBooklets(String bookletURL, String languageName);
    }

}
