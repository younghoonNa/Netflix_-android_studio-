package com.example.mp_final;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
                "melo", "signel"};


        Intent intent = getIntent();
        int indexNum = intent.getIntExtra("indexNum", 0);
        String fileName = intent.getStringExtra("fileName");
        ImageView imgDes = (ImageView) findViewById(R.id.imgDes);
        ImageView imgDes2 = (ImageView) findViewById(R.id.imgDes2);
        String str_desc[] = new String[4];

        TextView title_tv = (TextView) findViewById(R.id.main_title);
        TextView sub_info_tv = (TextView) findViewById(R.id.sub_info);
        TextView people_tv = (TextView) findViewById(R.id.movie_people);
        TextView description_tv = (TextView) findViewById(R.id.movie_des);

        Button btnPlay = (Button) findViewById(R.id.playBtn);
        Button btnDownload = (Button) findViewById(R.id.downloadBtn);
        Button btnBack = (Button) findViewById(R.id.backBtn);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "영상이 없습니다. 재생할 수 없습니다." ,Toast.LENGTH_SHORT).show();
            }
        });

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "영상이 없습니다. 다운로드 할 수 없습니다." ,Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            }
        });

        imgDes.setImageResource(imgxml[indexNum]);
        imgDes2.setImageResource(imgxml2[indexNum]);

        str_desc = readMovie(fileName);
//        title_tv.setText(str_desc[0]);


        for(int i=0; i<str_desc.length; i++) {
            switch (i){
                case 0:
                    title_tv.setText(str_desc[i]);
                    break;
                case 1:
                    sub_info_tv.setText(str_desc[i]);
                    break;
                case 2:
                    people_tv.setText("출연 : " + str_desc[i]);
                    break;
                case 3:
                    description_tv.setText(str_desc[i]);
                    break;
            }

        }
    }

    String[] readMovie(String fName) {
        File file = new File(getFilesDir(), fName);
        FileReader fr = null;
        BufferedReader br = null;
        String diaryStr = null;
        String str;
        String str_des[] = new String[4];

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            int i=0;
            while ((str = br.readLine()) != null) {
                str_des[i] = str;
                i+=1;
            }
            fr.close();
            br.close();
        } catch (IOException e) {
        }
        return str_des;
    }
}
