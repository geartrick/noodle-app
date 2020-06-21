package com.jaehong.noodle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewRecipe extends AppCompatActivity {

    TextView nrtext1,nrtext2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nr);

        nrtext1 = (TextView)findViewById(R.id.nrtext1);
        nrtext2 = (TextView)findViewById(R.id.nrtext2);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db= helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select text1,text2 from tb_memo"+
                " order by _id desc limit 1",null);
        while (cursor.moveToNext()){
            nrtext1.setText(cursor.getString(0));
            nrtext2.setText(cursor.getString(1));
        }
        db.close();
    }
}
