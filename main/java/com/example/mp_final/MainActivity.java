package com.example.mp_final;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageButton imgbtn;
    SoundPool soundPool;
    SoundManager soundManager;
    boolean play;
    int playSoundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fileWrite();
        clickicons();
    }

    private void fileWrite() {
        String strs = "\n";
        String[] movie_korean = { "빈센조", "슬기로운 의사생활", "도깨비",
                "갯마을 차차차", "호텔 델루나", "이태원 클라스", "이번생은 처음이라", "사랑의 불시착",
                "멜로가 체질", "시그널"};
//        String [] file_name_first = {
//                "bumzui", "chiken", "vt", "wra", "bro", "devil", "inner", "lookfor",
//                "man", "year"
//        };
        String file_name[] = {
                "binsenzo", "doctor", "doggabi", "getmaeul", "hotel", "leetaewon", "life", "love",
                "melo", "signel" };

        String [] movie_descript = {
                "한국에서 태어났으나 이탈리아에서 자랐다. 그리고 마피아의 세계에서 컸다." +
                        "악당을 대하는 방법은 누구보다 잘 알지. 거대 재벌을 혼내주는 데는 마피아 방식이 딱이지!",
                "탄생과 죽음이 공존하는, 인생의 축소판이라고 불리는 병원에서 특별한 하루하루를 살아가는 사람들의 이야기를 그린 드라마",
                "천 년 가까이 이어온 생. 불멸의 고통이 극으로 치닫는 순간, 그 아이가 왔다. 그토록 기다린 죽음이 왔다. 그러나 이를 어이하나." +
                        "이젠 그 아이 때문에 살고 싶어진 것을...",
                "대도시 생활을 접은 치과의사가 바닷가 마을에서 병원을 개업한다. 끈끈하기 그지없는 이 동네, 그곳에서 만난 만능 백수 히어로," +
                        "모든 면에서 그녀와 정반대를 달리는데, 은근히 매력이 넘친다.",
                "저승에 가기 전에 꼭 들린다는 망자들의 핫스팟. 성격 괴팍한 사장이 천 년 넘게 영업을 이어가고 있는 호텔 델루나에 새 지배인이 온다." +
                        "근데 저기 산, 사람이시라고요??",
                "독한 술, 낮처럼 환한 밤. 첨예한 빈부갈등. 다양성을 자랑하는 이태원 한복판에 주점을 차린 청춘 앞에, 치열한 경쟁과 오랜 상처, 통쾌한 복수가 기다리고 있다.",
                "집만 있으면 좋은 여자 지호, 집밖에 없는 남자 세희, 마침 이해관계도 딱 맞겠다, 계약 결혼으로 돈도 아끼고 사람들의 시선도 피하기로 한다. 그런데," +
                        "이게뭐야 집만 공유하는 쿨한 관계를 원했는데, 따라오는 책인이 커도 너무 크다..",
                "뜻밖의 돌풍은 행운일까, 불운일까. 패러글라이딩 사고로 북한에 불시착한 재벌 딸. 그곳에서 깐깐한 북괴군 장교를 만난다. 이 와중에 피어오르는 낯선 감정은 뭐지?",
                "말 많고 탈 많던 20대를 지나 30대에 접어든 그녀들, 서른이 되고 어른이 되면 괜찮을 줄 알았는데, 더한 고민이 시작됐다. 뭐 하나 쉬운게 없지만," +
                        "이렇게 성장하는 거겠지..????",
                "어느 날, 과거가 내게 말을 걸어왔다. 시간을 뛰어넘어 무전을 주고받는 두 경찰. 둘만이 알고 있는 정보를 통해 미제 사건을 해결하고 역사까지 바꿀 수 있을지도 모른다."
        };

        String [] movie_year = {
                "2021 \t 15+ \t 시즌 1개",
                "2021 \t 15+ \t 시즌 2개",
                "2016 \t 15+ \t 시즌 1개",
                "2021 \t 15+ \t 시즌 1개",
                "2019 \t 15+ \t 시즌 1개",
                "2019 \t 15+ \t 시즌 1개",
                "2017 \t 15+ \t 시즌 1개",
                "2019 \t 15+ \t 시즌 1개",
                "2019 \t 15+ \t 시즌 1개",
                "2016 \t 15+ \t 시즌 1개"
        };

        String [] movie_people = {
                "송중기, 전여빈, 옥택연, 유재명, 김여진, 곽동연, 조한철",
                "조정석, 유연석, 정경호, 김대명, 전미도, 김해숙, 김갑수, 정문성",
                "공 유, 김고은, 이동욱, 유안나, 육성재, 이엘, 조우진, 정해인, 황석정",
                "신민아, 김선호, 이상이, 공민정, 김영옥, 조한철, 안교진, 이붕련, 차정화, 강형석",
                "아이유, 여진구, 신정근, 서이숙, 배해선, 표지훈, 조현철, 강홍석, 이도현, 이태선",
                "박서준, 김다미, 유재명, 권나라, 김동희, 안보현, 김혜은, 류경수, 이주영",
                "이민기, 정소민, 이솜, 김가은, 박병은, 김민석, 문희경, 김병옥, 김선영",
                "현 빈, 손예진, 서지혜, 김정현, 오만석, 김영민, 김정난, 김선영",
                "천우희, 전여빈, 한지은, 안재홍, 공 명, 윤지은, 설우형, 이유진, 한준우",
                "김혜수, 이제훈, 조진웅, 장현성, 정해균, 김원해, 정한비, 이유준, 손현주"
        };

        try {

            for (int i=0; i<file_name.length; i++) {
                FileOutputStream outFs = openFileOutput(file_name[i],
                        Context.MODE_PRIVATE);
                //영화 제목
                outFs.write(movie_korean[i].getBytes());
                outFs.write(strs.getBytes());
                //영화 제작 연도, 연령가, 시즌
                outFs.write(movie_year[i].getBytes());
                outFs.write(strs.getBytes());
                //등장인물
                outFs.write(movie_people[i].getBytes());
                outFs.write(strs.getBytes());
                //영화 설명
                outFs.write(movie_descript[i].getBytes());
                outFs.close();
            }

        } catch (IOException e) {
        }
    }

    private void clickicons() {
        imgbtn = (ImageButton) findViewById(R.id.netfilx_mainview);

        //롤리팝 이상 버전일 경우
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = new SoundPool.Builder().build();
        } else{
            //롤리팝 이하 버전일 경우
//             new SoundPool(1번,2번,3번) //1번 - 음악 파일 갯수 //2번 - 스트림 타입 //3번 - 음질
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        }

        soundManager = new SoundManager(this,soundPool);
        soundManager.addSound(0,R.raw.netflixaudio2);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!play){
                    playSoundId=soundManager.playSound(0);
                    play = true;
                }else{
                    soundManager.pauseSound(0);
                    play = false;
                }

                Intent intent = new Intent(getApplicationContext(),
                        ChooseCharacter.class);

                startActivity(intent);
            }
        });
    }


}