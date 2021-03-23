package com.kix.assessment.ui.main_test;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kix.assessment.modal_classes.Modal_Content;

import java.util.ArrayList;
import java.util.List;

import static com.kix.assessment.ui.main_test.MainTestActivity.queCnt;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    //    Context context;
    private static int NUM_ITEMS = 0;
    private List<Fragment> fragmentList;
    Fragment currentFragment;
    List<Modal_Content> gameListList;

    public ViewpagerAdapter(FragmentManager fm, Context context, List<Modal_Content> gameListList) {
        super(fm);
//        this.context = context;
        NUM_ITEMS = gameListList.size();
        this.gameListList = gameListList;
        fragmentList = new ArrayList<>();
        for (int i = 0; i < gameListList.size(); i++) {
            fragmentList.add(WebViewFragment.newInstance(i, gameListList));
        }
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
        Log.d("GAME CODE", "POS : "+position+"     GAME CODE : "+gameListList.get(position).getContentCode() + " global Pos : "+queCnt);
        currentFragment = fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
