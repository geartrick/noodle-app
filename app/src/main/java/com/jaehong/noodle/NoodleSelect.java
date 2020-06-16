package com.jaehong.noodle;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class NoodleSelect extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noodle_selcet);


        LinearLayout button1 = (LinearLayout)findViewById(R.id.btn1);
        LinearLayout button2 = (LinearLayout)findViewById(R.id.btn2);
        LinearLayout button3 = (LinearLayout)findViewById(R.id.btn3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new FragmentA()).commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new FragmentB()).commit();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new FragmentC()).commit();
            }
        });
    }
}
