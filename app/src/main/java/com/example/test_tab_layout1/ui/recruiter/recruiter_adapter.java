package com.example.test_tab_layout1.ui.recruiter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.ui.jobseeker.PageViewCongViec;
import com.example.test_tab_layout1.ui.jobseeker.PageViewCreateCV;
import com.example.test_tab_layout1.ui.jobseeker.PageViewHoSo;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 07, December,2019
 **/
public class recruiter_adapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_baidang,R.string.tab_newjob, R.string.tab_congty,R.string.tab_inform};
    private final Context mContext;

    public recruiter_adapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        if (position == 0){
            PageViewBaiDang baidang = new PageViewBaiDang();
            return baidang;
        }
        else if (position == 1){
            return new PageViewNewJob();
        }
        else if(position == 2)
            return new PageViewCongTy();
        else {
            return new PageViewInform();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
//        return null;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}
