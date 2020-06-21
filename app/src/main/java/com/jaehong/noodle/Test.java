package com.jaehong.noodle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Test extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        final TextView textView = (TextView)findViewById(R.id.test);


        Intent i = getIntent();
        final String text = i.getExtras().getString("title");
        Boolean onoff = i.getExtras().getBoolean("onoff");
        textView.setText(text);




       final LinearLayout l1 = (LinearLayout)findViewById(R.id.a1);
       final LinearLayout l2 = (LinearLayout)findViewById(R.id.b1);

       final LinearLayout AA1 = (LinearLayout)findViewById(R.id.aa1);
       final LinearLayout BB1 = (LinearLayout)findViewById(R.id.bb1);
       final LinearLayout Empty= (LinearLayout)findViewById(R.id.empty);
       final LinearLayout AA2 = (LinearLayout)findViewById(R.id.aa2);

        if(text.equals("꼬꼬면")){
            l1.setVisibility(View.VISIBLE);
        }else if(text.equals("팔도비빔면")){
            l2.setVisibility(View.VISIBLE);
        }
        if(onoff==true){
            Empty.setVisibility(View.GONE);
            AA2.setVisibility(View.VISIBLE);
        }else{
            Empty.setVisibility(View.VISIBLE);
            AA2.setVisibility(View.GONE);
        }

        AA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Test.this,DefaultRecipe.class);
                i.putExtra("title",text);
                startActivity(i);
            }
        });
        BB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Test.this,DefaultRecipe.class);
                i.putExtra("title",text);
                startActivity(i);
            }
        });
        Empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Test.this,RecipeWrite.class);
                startActivity(i);
            }
        });
        AA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Test.this,NewRecipe.class);
                startActivity(i);
            }
        });

    }
}
