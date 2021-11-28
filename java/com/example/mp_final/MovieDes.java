package com.example.mp_final;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.IOException;

public class MovieDes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_descript);

        // 10개의 이미지버튼  ID 배열(2-위젯)
        Integer imgxml[] = {
                R.drawable.binsenzo,
                R.drawable.doctor,
                R.drawable.doggabi,
                R.drawable.getmaeul,
                R.drawable.hotel,
                R.drawable.leetaewon,
                R.drawable.life,
                R.drawable.love,
                R.drawable.melo,
                R.drawable.signel
        };

        Integer imgxml2[] = {
                R.drawable.binsenzo2,
                R.drawable.docter2,
                R.drawable.doggabi2,
                R.drawable.getmaeul2,
                R.drawable.hotel2,
                R.drawable.leetaewon2,
                R.drawable.life2,
                R.drawable.love2,
                R.drawable.melo2,
                R.drawable.signel2
        };

        final String fileName2[] = {
                "binsenzo", "doctor", "doggabi", "getmaeul", "hotel", "leetaewon", "life", "love",
                "melo", "signel" };


        Intent intent = getIntent();
        int indexNum = intent.getIntExtra("indexNum", 0);
        String fileName = intent.getStringExtra("fileName");
        TextView tv = (TextView) findViewById(R.id.ttvv2);
        ImageView imgDes = (ImageView) findViewById(R.id.imgDes);
        ImageView imgDes2 = (ImageView) findViewById(R.id.imgDes2);

        imgDes.setImageResource(imgxml[indexNum]);
        imgDes2.setImageResource(imgxml2[indexNum]);

        tv.setText(fileName2[indexNum]);

        readMovie(fileName);
    }

    String readMovie(String fName) {
        TextView btnWrite = (TextView) findViewById(R.id.ttvv1);
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[][] txt = new byte[3][500];
            inFs.read(txt[0]);
            inFs.close();
            diaryStr = (new String(txt[0])).trim();
            btnWrite.setText(diaryStr);
        } catch (IOException e) {
//            edtDiary.setHint("일기 없음");
//            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }

//    protected class MyGraphicView extends View {
//        public MyGraphicView (Context context) {
//            super(context);
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//
//            Intent intent = getIntent();
//            byte[] image = intent.getByteArrayExtra("Image");
//            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
//        }
//    }
}
