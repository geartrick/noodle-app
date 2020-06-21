package com.jaehong.noodle;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecipeWrite extends AppCompatActivity {



    EditText ed1,ed2 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rw);
        ed1 = (EditText)findViewById(R.id.rw1_1);
        ed2 = (EditText)findViewById(R.id.rw2_1);
//       Button button = (Button)findViewById(R.id.send);
    }
    public void onClick(View v){
        String text1 = ed1.getText().toString();
        String text2 = ed2.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tb_memo(text1,text2)values(?,?)",
                new String[]{text1,text2});
        db.close();
        Intent i = new Intent(RecipeWrite.this,Test.class);
        i.putExtra("onoff",true);
        i.putExtra("title","꼬꼬면");
        startActivity(i);
    }
}
