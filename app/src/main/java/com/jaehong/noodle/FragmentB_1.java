package com.jaehong.noodle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragmentB_1 extends Fragment {

    public FragmentB_1(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b_1,container,false);


        ImageView kko = (ImageView)view.findViewById(R.id.kko);

        kko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Test.class);
                i.putExtra("title","꼬꼬면");
                startActivity(i);
            }
        });
        return view;
    }


}
