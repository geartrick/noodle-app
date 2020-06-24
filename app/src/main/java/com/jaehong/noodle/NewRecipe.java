package com.jaehong.noodle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class NewRecipe extends AppCompatActivity {
    TextView nrtext1,nrtext2,name;
    String ustr;
    ImageView imageView;
    static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nr);

        nrtext1 = (TextView)findViewById(R.id.nrtext1);
        nrtext2 = (TextView)findViewById(R.id.nrtext2);
        name=(TextView)findViewById(R.id.nr);
        imageView=(ImageView)findViewById(R.id.imageView);


        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db= helper.getWritableDatabase();

            Cursor cursor = db.rawQuery("select text1,text2,name from tb_memo"+
                    " order by _id desc limit 1",null);
            while (cursor.moveToNext()){
                nrtext1.setText(cursor.getString(0));
                nrtext2.setText(cursor.getString(1));
                name.setText(cursor.getString(2));
            }

        db.close();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        }
    }
}
