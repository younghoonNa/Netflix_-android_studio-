package com.example.mp_final;


import android.app.Activity;
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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.ByteArrayOutputStream;

@SuppressWarnings("deprecation")
public class MainProject extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainproject);

        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        Button btnLove = (Button) findViewById(R.id.btnLove);
        Button btnInfo = (Button) findViewById(R.id.btnInfo);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "동영상이 없습니다. 재생할 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "찜 기능이 아직 구현되지 않았습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "이 페이지에서는 정보를 볼 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Slide_wetoon_xml_Result();

        thirdButton();



//        TabSpec tabSpecFirst = tabHost.newTabSpec("Home").setIndicator("홈");
//        tabSpecFirst.setContent(R.id.first);
//        tabHost.addTab(tabSpecFirst);
//
//        TabSpec tabSpecSecond = tabHost.newTabSpec("Search").setIndicator("검색");
//        tabSpecSecond.setContent(R.id.second);
//        tabHost.addTab(tabSpecSecond);

        //오토 텍스트
        String[] items = {"Bumzui", "극한직업", "베테랑",
                "범죄와의 전쟁", "형", "악인전", "내부자들", "감시자들",
                "아저씨", "movie1987"};
        String[] temp_items = {
                "bumzui", "chiken", "vt", "wra", "bro", "devil", "inner", "lookfor",
                "man", "movie1987"
        };

        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9, R.id.iv10};


//        // 3번째 버튼
//        TabSpec tabSpecThird = tabHost.newTabSpec("Saved").setIndicator("저장된 컨텐츠 목록");
//        tabSpecThird.setContent(R.id.third);
//        tabHost.addTab(tabSpecThird);
//
//        tabHost.setCurrentTab(0);
//
//        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
//            TextView x = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
//            x.setTextSize(13);
//            x.setTextColor(Color.WHITE);
//        }

        final int voteCount[] = new int[10];    // 그림의 투표 결과 저장하는 배열, 투표 결과를 ResultActivity로 전달(1)

        for (int i = 0; i < 10; i++)             // 초기화
            voteCount[i] = 0;

        // 9개의 이미지 버튼 객체배열(1-위젯 변수)
        ImageView image[] = new ImageView[10];


        // 그림의 제목을 ResultActivity로 전달(2)
        final String imgName[] = {"범죄도시 ", "극한직업", "베테랑",
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


//------여기는 메인 Activity에서 저장한 내용을 파일로 출력하는 과정. 2번째 줄 -------------

        ImageView img[] = new ImageView[10];
        // 그림의 제목을 Signal로 전달
        final String fileName[] = {
                "binsenzo", "doctor", "doggabi", "getmaeul", "hotel", "leetaewon", "life", "love",
                "melo", "signel"};

        // 10개의 이미지버튼  ID 배열(2-위젯)
        Integer imgxml[] = {R.id.img2_1, R.id.img2_2, R.id.img2_3, R.id.img2_4, R.id.img2_5,
                R.id.img2_6, R.id.img2_7, R.id.img2_8, R.id.img2_9, R.id.img2_10};

        for (int k = 0; k < img.length; k++) {
            final int index; // 주의! 꼭 필요함..
            index = k;
            img[index] = (ImageView) findViewById(imgxml[index]);

            img[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentFile = new Intent(getApplicationContext(), MovieDes.class);
                    intentFile.putExtra("fileName", fileName[index]);  // 파일 제목을 Movie_Des로 보냄
                    intentFile.putExtra("indexNum", index);  // indexNum MovieDes로 보냄
                    startActivity(intentFile);
                }
            });
        }
    }


    //---------------------------------------------------------------------------------------
    public void Slide_wetoon_xml_Result () {

        String slide_fileName[] = {
                "knowingslide", "rumor", "kimbiseo", "loving", "another", "dp", "pocha", "sound",
                "myid", "kingdom"};

        ImageView slide_img[] = new ImageView[10];

        // 그림의 제목을 SlideResult,xml로 전달
        // 10개의 이미지버튼  ID 배열(2-위젯)
        Integer slideimgbtn[] = {R.id.slideimg1, R.id.slideimg2, R.id.slideimg3, R.id.slideimg4,
                R.id.slideimg5, R.id.slideimg6, R.id.slideimg7, R.id.slideimg8, R.id.slideimg9, R.id.slideimg10};

        for (int t = 0; t < slide_img.length; t++) {
            final int index; // 주의! 꼭 필요함..
            index = t;
            slide_img[index] = (ImageView) findViewById(slideimgbtn[index]);

            slide_img[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentFile = new Intent(getApplicationContext(), SlideResult.class);
                    intentFile.putExtra("slide_fileName", slide_fileName[index]);  // 파일 제목을 SlideResult로 보냄
                    intentFile.putExtra("slide_indexNum", index);  // indexNum SlideResult로 보냄
                    startActivity(intentFile);
                }
            });
        }
    }


    public void thirdButton() {
        // 여기는 버튼 3번째 줄. 파일 입출력 사용 X
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        LinearLayout linearframe = (LinearLayout) findViewById(R.id.LinearFrame);
        LinearLayout review = (LinearLayout) findViewById(R.id.review);
        ImageView mv1 = (ImageView) findViewById(R.id.mv1);
        Button framePlay = (Button) findViewById(R.id.framePlay);
        Button backBtn = (Button) findViewById(R.id.backBtn);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.GONE);
                linearframe.setVisibility(View.VISIBLE);
                review.setVisibility(View.VISIBLE);
            }
        });

        framePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "재생할 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        });


        ImageView imgFrameview[] = new ImageView[10];
        ImageView FrameImg = (ImageView) findViewById(R.id.frameImg);
        TextView Maintv = (TextView) findViewById(R.id.frameMain);
        TextView framePeopletv = (TextView) findViewById(R.id.framepeople);
        TextView frameInfo = (TextView) findViewById(R.id.frameinfo);



        // 그림의 제목을 Signal로 전달
        final String frameImgName[] = {
                "어바웃 타임", "검사외전", "하트시그널", "아는형님", "알고있지만", "로스쿨", "연애의 참견", "나우유씨미2", "스위트홈", "기묘한 이야기" };

        final String framepeople_str[] = {
                "2013, \t  15세+, \t 2시간 3분",
                "2016, \t 15세+, \t 2시간 6분",
                "2020, \t 15세+, \t 시즌 1개",
                "2021, \t 15세+, \t 시즌 6개",
                "2021, \t 19세+, \t 시즌 1개",
                "2021, \t 15세+, \t 시즌 1개",
                "2021, \t 15세+, \t 시즌 2개",
                "2016, \t 15세+, \t 2시간 9분",
                "2020, \t 18세+, \t 시즌 1개",
                "2019, \t 15세+, \t 시즌 3개"};

        final String frameinfo_str[] = {
                "평범한 청년이 알게 된 가문의 놀라운 비밀. 그건 바로 집안의남자들에게 시간을 되돌리는 능력이 있다는 것." +
                        "청년은 한눈에 반한 여인을 마음을 얻기 위해 그 특별한 능력을 사용하기로 한다. 그리고 ...",
                "살인죄를 뒤집어쓴 검사와 꽃미남 사기꾼이 손잡았다. 열혈 검사 재욱이 감옥에서 판을 짜면 감옥 밖 작전은 사기꾼 치원의 몫" +
                        "누명을 둘러싼 일진일퇴의 공방전, 그 끝은?",
                "한 지붕 아래 살게 된 여덟 남녀, 이들은 한 달 동안 설래는 인연을 찾을 수 있을까? 연예인과 전문가들이 남녀의 심리를 추리해" +
                        "사랑과 실연, 로맨스와 향방을 예측한다.",
                "아재 감성이 물씬 풍기는 출연진. 하지만 고등학생이라는 설정 하에 스타 전학생을 매주 맞이하며 순발력 넘치는 유머와 몸 개그로 대결을 펼친다.",
                "남자 친구와 이별한 후 술집에 우두커니 앉아 있던 유나비. 그곳에서 나비 문신을 한 낯선 남자와 우연히 마주친다. 그리고 두 사람의 인연은" +
                        "이후로도 계속 이어지는데...",
                "반전이 있는 범죄 드라마, <<꽃보다 남자>> 의 김범과 <<응답하라 1988>> 의 류혜영이 로스쿨 장학생으로 출현한다.",
                "쨰째한 행동, 돈 문제, 충격적인 비밀, 원인도 종류도 다양한 현실 커플들의 고민. 그러나 이 것 하나 만은 확실하다. 연애에선" +
                        "어느 것이나 이별 사유가 될 수 있다는 점.",
                "직접 보고도 믿기 힘든 엄처난 마술쇼를 선보였던 마술사들, 그 들이 새로운 멤버와 함께 마술을 돌아왔다." +
                        " 악덕 기업의 실체를 폭로하기 위해 시작한 새로운 쇼, 그런데 어쩌다 일이 꼬인걸까...",
                "갸족을 모두 잃은 운둔형 외토리. 낡은 아파트에 혼자 살게 된 10대 소년 현수가 이웃들을 위해 무기를 든다." +
                        "괴물들이 날 뛰기 전 까지 몰랐다. 이렇게 살고 싶었을 줄은...",
                "또 다시 기묘한 일들이 일어난다. 정부가 숨기고 있는 비밀, 정체를 드러내는 그림자, 두려움을 모르는 아이들. 작은 마을에" +
                        " 어둠이 다가온다. 뒤집힌 세상의 문이 열린다."};

        // 10개의 이미지버튼  ID 배열(2-위젯)
        Integer imgFrame[] = { R.id.mv1, R.id.mv2, R.id.mv3, R.id.mv4, R.id.mv5,
                R.id.mv6, R.id.mv7, R.id.mv8, R.id.mv9, R.id.mv10 };

        Integer setimgFrame[] = { R.drawable.abouttime, R.drawable.gum4, R.drawable.heartsignel,
                R.drawable.knowbro, R.drawable.knowing, R.drawable.lawschool, R.drawable.loveinterffer,
                R.drawable.nowyouseeme, R.drawable.sweethome, R.drawable.stroy};

        for (int k =0; k<imgFrame.length; k++) {
            final int index; // 주의! 꼭 필요함..
            index = k;                                                  // for문을 이용하여
            imgFrameview[index] = (ImageView) findViewById(imgFrame[index]);
//            String str = "VoteResult.class";

            imgFrameview[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FrameImg.setImageResource(setimgFrame[index]);
                    Maintv.setText(frameImgName[index]);
                    framePeopletv.setText(framepeople_str[index]);
                    frameInfo.setText(frameinfo_str[index]);

                    frameLayout.setVisibility(View.VISIBLE);
                    linearframe.setVisibility(View.GONE);
                    review.setVisibility(View.GONE);

                }
            });
        }

    }
}
