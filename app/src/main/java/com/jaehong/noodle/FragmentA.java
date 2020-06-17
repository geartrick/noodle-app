package com.jaehong.noodle;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;


public class FragmentA extends Fragment {

    int x;
    int y;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_, container, false);
        View view = inflater.inflate(R.layout.fragment_,container,false);

        final ConstraintLayout first=(ConstraintLayout)view.findViewById(R.id.first);
        final ConstraintLayout second=(ConstraintLayout)view.findViewById(R.id.second);
        final LinearLayout res=(LinearLayout)view.findViewById(R.id.res);
        RadioGroup rg1 = (RadioGroup)view.findViewById(R.id.rg1);
        RadioGroup rg2 = (RadioGroup)view.findViewById(R.id.rg2);
        final Button next1 = (Button)view.findViewById(R.id.next1);
        final Button next2 = (Button)view.findViewById(R.id.next2);

        final ConstraintLayout res1=(ConstraintLayout)view.findViewById(R.id.res1);
        final ConstraintLayout res2=(ConstraintLayout)view.findViewById(R.id.res2);
        final ConstraintLayout res3=(ConstraintLayout)view.findViewById(R.id.res3);
        final ConstraintLayout res4=(ConstraintLayout)view.findViewById(R.id.res4);



        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first.setVisibility(View.INVISIBLE);
                second.setVisibility(View.VISIBLE);
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second.setVisibility(View.INVISIBLE);
                res.setVisibility(View.VISIBLE);

                if(x==0 && y==0){
                    res4.setVisibility(View.VISIBLE);
                    res1.setVisibility(View.GONE);
                    res2.setVisibility(View.GONE);
                    res3.setVisibility(View.GONE);
                }
                else if(x==0 && y==1){
                    res3.setVisibility(View.VISIBLE);
                    res2.setVisibility(View.GONE);
                    res1.setVisibility(View.GONE);
                    res4.setVisibility(View.GONE);
                }else if(x==1 && y==0){
                    res2.setVisibility(View.VISIBLE);
                    res3.setVisibility(View.GONE);
                    res4.setVisibility(View.GONE);
                    res1.setVisibility(View.GONE);
                }else if(x==1 && y==1){
                    res1.setVisibility(View.VISIBLE);
                    res2.setVisibility(View.GONE);
                    res3.setVisibility(View.GONE);
                    res4.setVisibility(View.GONE);
                }
            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.yes1)
                {
                     x=1;
                    next1.setVisibility(View.VISIBLE);
                }
                else if(checkedId==R.id.no1)
                {
                    x=0;
                    next1.setVisibility(View.VISIBLE);
                }
            }
        });{

        }
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.yes2)
                {
                    y=1;
                    next2.setVisibility(View.VISIBLE);
                }

                else if (checkedId == R.id.no2)
                {
                    y=0;
                    next2.setVisibility(View.VISIBLE);
                }
            }
        });
        return  view;
    }

}
