package com.kix.assessment.ui.profile.fragment_chooseBooklet;

public interface DownloadBooklet_Contract {

    interface DownloadBookletView{

        void showLoader();

        void dismissLoadingDialog();

        void dismissDownloadDialog();
    }

    interface DownloadBookletPresenter {

        void setView(DownloadBooklet_Contract.DownloadBookletView downloadBookletView);

        void downloadBooklet(String nodeID);
    }

}
