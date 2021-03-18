package com.kix.assessment.ui.main_test;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kix.assessment.modal_classes.GameList;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    //    Context context;
    private static int NUM_ITEMS = 0;
    private List<Fragment> fragmentList;
    List<GameList> gameListList;
    Fragment currentFragment;

    public ViewpagerAdapter(FragmentManager fm, Context context, List<GameList> gameListList) {
        super(fm);
//        this.context = context;
        this.gameListList = gameListList;
        NUM_ITEMS = gameListList.size();
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
        currentFragment = WebViewFragment.newInstance(position, gameListList);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
