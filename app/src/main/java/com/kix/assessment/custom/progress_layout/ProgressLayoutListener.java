package com.kix.assessment.custom.progress_layout;

public interface ProgressLayoutListener {
    void onProgressCompleted();

    void onProgressChanged(int seconds);
}
