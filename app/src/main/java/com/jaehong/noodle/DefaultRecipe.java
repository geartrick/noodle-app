package com.jaehong.noodle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DefaultRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dr);

        TextView textView = (TextView)findViewById(R.id.drtext);

        Intent i =getIntent();
        String text =i.getExtras().getString("title");
        textView.setText(text);
    }
}
