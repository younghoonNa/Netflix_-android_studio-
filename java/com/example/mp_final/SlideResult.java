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

public class SlideResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slideresult);

        // 10개의 이미지버튼  ID 배열(2-위젯)
        Integer imgxml[] = {
                R.drawable.knowing_slide,
                R.drawable.rumor,
                R.drawable.kimbiseo_poster,
                R.drawable.loving,
                R.drawable.another,
                R.drawable.dp_poster,
                R.drawable.pocha_poster,
                R.drawable.sound_poster,
                R.drawable.myid_poster,
                R.drawable.kingdom_poster,

        };


        String slide_fileName[] = {
                "knowingslide", "rumor", "kimbiseo", "loving", "another", "dp", "pocha", "sound",
                "myid", "kingdom"};


        Intent intent = getIntent();
        int indexNum = intent.getIntExtra("slide_indexNum", 0);
        String fileName = intent.getStringExtra("slide_fileName");
        ImageView imgDes = (ImageView) findViewById(R.id.imgDes);
        ImageView imgDes2 = (ImageView) findViewById(R.id.imgDes2);
        String str_webtoon_des[] = new String[5];

        TextView title_tv = (TextView) findViewById(R.id.main_title);
        TextView sub_info_tv = (TextView) findViewById(R.id.sub_info);
        TextView people_tv = (TextView) findViewById(R.id.movie_people);
        TextView description_tv = (TextView) findViewById(R.id.movie_des);
        TextView movie_director = (TextView) findViewById(R.id.movie_director);

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

        str_webtoon_des = readMovie(fileName);


        for(int i=0; i<str_webtoon_des.length; i++) {
            switch (i){
                case 0:
                    title_tv.setText(str_webtoon_des[i]);
                    break;
                case 1:
                    sub_info_tv.setText(str_webtoon_des[i]);
                    break;
                case 2:
                    people_tv.setText(str_webtoon_des[i]);
                    break;
                case 3:
                    description_tv.setText(str_webtoon_des[i]);
                    break;
                case 4:
                    movie_director.setText(str_webtoon_des[i]);
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
        String str_des[] = new String[5];

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
