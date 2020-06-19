package com.jaehong.noodle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FragmentB extends Fragment {

    ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);


        viewPager=(ViewPager)view.findViewById(R.id.viewpager);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {

                switch (i){
                    case 0 :
                        return new FragmentB_1();
                    case  1:
                        return new FragmentB_2();
                    case  2:
                        return new FragmentB_3();
                    default:
                        return null;
                }

            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        viewPager.setCurrentItem(0);


        return view;
    }



}
