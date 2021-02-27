//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.7.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.pratham.foundation.ui.admin_panel.andmin_login_new.pull_and_asign;

import android.annotation.SuppressLint;
import android.content.Context;
import org.androidannotations.api.BackgroundExecutor;

public final class PullAndAssign_Presenter_
    extends PullAndAssign_Presenter
{
    private Context context_;
    private Object rootFragment_;

    private PullAndAssign_Presenter_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    private PullAndAssign_Presenter_(Context context, Object rootFragment) {
        super(context);
        context_ = context;
        rootFragment_ = rootFragment;
        init_();
    }

    public static PullAndAssign_Presenter_ getInstance_(Context context) {
        return new PullAndAssign_Presenter_(context);
    }

    public static PullAndAssign_Presenter_ getInstance_(Context context, Object rootFragment) {
        return new PullAndAssign_Presenter_(context, rootFragment);
    }

    private void init_() {
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

    @Override
    public void loadProgramsSpinner() {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    PullAndAssign_Presenter_.super.loadProgramsSpinner();
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }

    @Override
    public void fetchVillageData() {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    PullAndAssign_Presenter_.super.fetchVillageData();
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }

    @Override
    public void getAllGroups(final int vilID) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    PullAndAssign_Presenter_.super.getAllGroups(vilID);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }

    @SuppressLint({
        "HardwareIds"
    })
    @Override
    public void updateDBData(final String group1, final String group2, final String group3, final String group4, final String group5, final int vilID) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {

            @Override
            public void execute() {
                try {
                    PullAndAssign_Presenter_.super.updateDBData(group1, group2, group3, group4, group5, vilID);
                } catch (final Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }
        }
        );
    }
}
