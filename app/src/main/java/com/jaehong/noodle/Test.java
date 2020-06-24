package com.jaehong.noodle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        final TextView textView = (TextView)findViewById(R.id.test);
        Button home = (Button)findViewById(R.id.home);
        final Button addrecipe= (Button)findViewById(R.id.add);
        Intent i = getIntent();
        final String text = i.getExtras().getString("title");
        textView.setText(text);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Test.this,NoodleSelect.class);
                startActivity(i);
            }
        });







       final LinearLayout l1 = (LinearLayout)findViewById(R.id.a1);
       final LinearLayout l2 = (LinearLayout)findViewById(R.id.b1);

       final LinearLayout AA1 = (LinearLayout)findViewById(R.id.aa1);
       final LinearLayout BB1 = (LinearLayout)findViewById(R.id.bb1);
       final LinearLayout AA3 = (LinearLayout)findViewById(R.id.aa3);
       final LinearLayout AA2 = (LinearLayout)findViewById(R.id.aa2);
       TextView textView1 = (TextView)findViewById(R.id.aaa1);

        if(text.equals("꼬꼬면")){
            l1.setVisibility(View.VISIBLE);
        }else if(text.equals("팔도비빔면")){
            l2.setVisibility(View.VISIBLE);
        }

        AA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Test.this,DefaultRecipe.class);
                i.putExtra("title",text);
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
        AA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Test.this,NewRecipe.class);
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
        addrecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Test.this,RecipeWrite.class);
                startActivity(i);
            }
        });


        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db= helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select name from tb_memo"+
                " order by _id desc limit 1",null);
        while (cursor.moveToNext()){
           textView1.setText(cursor.getString(0));

        }

        db.close();
    }



}



