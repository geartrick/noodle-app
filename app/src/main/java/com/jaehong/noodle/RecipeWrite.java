package com.jaehong.noodle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RecipeWrite extends AppCompatActivity {
    static final int REQUEST_CODE = 1;
    ImageView imageView;
    Uri uri;
    EditText ed1, ed2, name;
    TextView test;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);


        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rw);

        ed1 = (EditText) findViewById(R.id.rw1_1);
        ed2 = (EditText) findViewById(R.id.rw2_1);
        name = (EditText) findViewById(R.id.name);
        imageView = (ImageView) findViewById(R.id.image);


    }

    public void onClick(View v) {
        String text1 = ed1.getText().toString();
        String text2 = ed2.getText().toString();
        String text3 = name.getText().toString();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("insert into tb_memo(text1,text2,name)values(?,?,?)",
                new String[]{text1, text2, text3});

        db.close();
        Intent i = new Intent(RecipeWrite.this, Test.class);
        i.putExtra("title", "꼬꼬면");
        startActivity(i);
    }

    public void onClickBTN(View view) {
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(i, REQUEST_CODE);
    }

}

