package com.example.mp_final;


import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

@SuppressWarnings("deprecation")
public class MainProject extends TabActivity {
    TabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainproject);

        tabHost = getTabHost();

        TabSpec tabSpecFirst = tabHost.newTabSpec("Home").setIndicator("홈");
        tabSpecFirst.setContent(R.id.first);
        tabHost.addTab(tabSpecFirst);

        TabSpec tabSpecSecond = tabHost.newTabSpec("Search").setIndicator("검색");
        tabSpecSecond.setContent(R.id.second);
        tabHost.addTab(tabSpecSecond);

        //오토 텍스트
        String[] items = { "Bumzui", "극한직업", "베테랑",
                "범죄와의 전쟁", "형", "악인전", "내부자들", "감시자들",
                "아저씨", "movie1987"};
        String [] temp_items = {
                "bumzui", "chiken", "vt", "wra", "bro", "devil", "inner", "lookfor",
                "man", "movie1987"
        };

        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9, R.id.iv10 };


        ImageButton btnSearch = (ImageButton) findViewById(R.id.btnSearch);
        TextView tv1 = (TextView) findViewById(R.id.tvexam);

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);


        // 3번째 버튼
        TabSpec tabSpecThird = tabHost.newTabSpec("Saved").setIndicator("저장된 컨텐츠 목록");
        tabSpecThird.setContent(R.id.third);
        tabHost.addTab(tabSpecThird);

        tabHost.setCurrentTab(0);

        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            TextView x = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            x.setTextSize(13);
            x.setTextColor(Color.WHITE);
        }

        final int voteCount[] = new int[10];    // 그림의 투표 결과 저장하는 배열, 투표 결과를 ResultActivity로 전달(1)

        for (int i = 0; i < 10; i++)             // 초기화
            voteCount[i] = 0;

        // 9개의 이미지 버튼 객체배열(1-위젯 변수)
        ImageView image[] = new ImageView[10];


        // 그림의 제목을 ResultActivity로 전달(2)
        final String imgName[] = { "범죄도시 ", "극한직업", "베테랑",
                "범죄와의 전쟁", "형", "악인전", "내부자들", "감시자들",
                "아저씨", "1987"};

        // 9개의 이미지버튼  ID 배열(2-위젯)
//        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
//                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9, R.id.iv10 };

//------------------------------(3- 위젯변수와 위젯) (이벤트 처리)--------------------------------------
        for (int i = 0; i < imageId.length; i++) {
            final int index; // 주의! 꼭 필요함..
            index = i;                                                  // for문을 이용하여
            image[index] = (ImageView) findViewById(imageId[index]);   // (1) 위제 변수에 위제을 9번 대입

            image[index].setOnClickListener(new View.OnClickListener() { //(2) 이벤트 발생시 클래스를 위젯에 9번 정의
                public void onClick(View v) {

                    // 투표수 증가.
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }
//---------------------------------------------------------------------------------------
        Button btnFinish = (Button) findViewById(R.id.btnResult);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainProject.this, VoteResult.class);
                intent.putExtra("VoteCount", voteCount);  // 투표 결과를 ResultActivity로 보냄
                intent.putExtra("ImageName", imgName);  // 그림 제목을 ResultActivity로 보냄
                startActivity(intent);
            }
        });
//------------------------------------------------------------------------------------------

        ImageView img[] = new ImageView[10];


        // 그림의 제목을 Signal로 전달
        final String fileName[] = {
                "binsenzo", "doctor", "doggabi", "getmaeul", "hotel", "leetaewon", "life", "love",
                "melo", "signel" };

        // 10개의 이미지버튼  ID 배열(2-위젯)
        Integer imgxml[] = { R.id.img2_1, R.id.img2_2, R.id.img2_3, R.id.img2_4, R.id.img2_5,
                R.id.img2_6, R.id.img2_7, R.id.img2_8, R.id.img2_9, R.id.img2_10 };

        for (int k =0; k<img.length; k++) {
            final int index; // 주의! 꼭 필요함..
            index = k;                                                  // for문을 이용하여
            img[index] = (ImageView) findViewById(imgxml[index]);
//            String str = "VoteResult.class";

            img[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentFile = new Intent(getApplicationContext(), MovieDes.class);
                    intentFile.putExtra("fileName", fileName[index]);  // 파일 제목을 ResultActivity로 보냄
                    intentFile.putExtra("indexNum", index);  // indexNum ResultActivity로 보냄
                    startActivity(intentFile);
                }
            });
        }


    }


//------------------------------------------------------------------------------------------
//
//        TextView x = (TextView) tabHost.getTabWidget().getChildAt(2).findViewById(android.R.id.title);
//        x.setTextSize(13);
//        x.setTextColor(Color.WHITE);

//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//
//            @Override
//            public void onTabChanged(String tabId) {
//
//
//
//                for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
//                    tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#232323")); // unselected
//                    TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
//                    tv.setTextColor(Color.parseColor("#FFFFFF"));
//
//                }
//
//                tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#232323")); // selected
//                TextView tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
//                tv.setTextColor(Color.parseColor("#FFFFFF"));
//
//            }
//        });



//    }
}
