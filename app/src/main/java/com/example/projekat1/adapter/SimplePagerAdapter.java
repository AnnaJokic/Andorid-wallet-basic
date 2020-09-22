package com.example.projekat1.adapter;

import android.content.Context;

import com.example.projekat1.Fragments.FirstFragment;
import com.example.projekat1.Fragments.FourFragment;
import com.example.projekat1.Fragments.SecondFragment;
import com.example.projekat1.Fragments.ThirdFragment;
import com.example.projekat1.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimplePagerAdapter  extends FragmentPagerAdapter {

    private static final int FRAGMENT_COUNT=4;

    private List<String> mTitles;

    public SimplePagerAdapter(FragmentManager fm, Context context){
        super(fm);
        initTitles(context);
    }


    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return FirstFragment.newInstance();
            case 1:
                return SecondFragment.newInstance();
            case 2:
                return ThirdFragment.newInstance();
            case 3:
                return FourFragment.newInstance();
        }
        return null;
    }


    private void initTitles(Context context){
        mTitles=new ArrayList<>();
        mTitles.add(context.getString(R.string.title1));
        mTitles.add(context.getString(R.string.title2));
        mTitles.add(context.getString(R.string.title3));
        mTitles.add(context.getString(R.string.title4));


    }


   @Nullable
   @Override
   public CharSequence getPageTitle(int position){
       return mTitles.get(position);
   }



    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}
