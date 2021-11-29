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
        SlidefileWrite();
        clickicons();
    }

    //메인 프로젝트 2번째 한국 영화 -> 파일 입출력 사용하여 불러올 때 사용.
    private void fileWrite() {
        String strs = "\n";
        String[] movie_korean = { "빈센조", "슬기로운 의사생활", "도깨비",
                "갯마을 차차차", "호텔 델루나", "이태원 클라스", "이번생은 처음이라", "사랑의 불시착",
                "멜로가 체질", "시그널"};

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
                "공 유, 김고은, 이동욱, 유안나, 육성재, 이엘, 조우진, 정해인",
                "신민아, 김선호, 이상이, 공민정, 김영옥, 조한철, 안교진, 이붕련",
                "아이유, 여진구, 신정근, 서이숙, 배해선, 표지훈, 조현철, 강홍석",
                "박서준, 김다미, 유재명, 권나라, 김동희, 안보현, 김혜은, 류경수",
                "이민기, 정소민, 이솜, 김가은, 박병은, 김민석, 문희경, 김병옥",
                "현 빈, 손예진, 서지혜, 김정현, 오만석, 김영민, 김정난, 김선영",
                "천우희, 전여빈, 한지은, 안재홍, 공 명, 윤지은, 설우형, 이유진",
                "김혜수, 이제훈, 조진웅, 장현성, 정해균, 김원해, 정한비, 이유준"
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

    //메인 프로젝트 2번째 한국 영화 -> 파일 입출력 사용하여 불러올 때 사용.
    private void SlidefileWrite() {
        String strs = "\n";
        String[] webtoon = { "알고있지만", "경이로운 소문", "김비서가 왜그럴까", "좋아하면 울리는", "타인은 지옥이다",
                "D.P", "쌍값포차", "마음의 소리", "내 아이디는 강남미인", "킹덤 : 야신전"};

        String slide_fileName[] = {
                "knowingslide", "rumor", "kimbiseo", "loving", "another", "dp", "pocha", "sound",
                "myid", "kingdom" };

        String [] webtoon_descript = {
                "남자 친구와 이별한 후 술집에 우두커니 앉아 있던 유나비. 그곳에서 나비 문신을 한 낯선 남자와 우연히 마주친다." +
                        "그리구 두 사람의 인연은 이후로도 계속 이어지는데..",
                "피에 굶주린 악귀들, 우리가 처단한다. 세상을 지키기 위해 카운터들이 뭉쳤다. 나이도 성격도 제각각이지만" +
                        "팀워크만큼은 발군! 뜨거운 소문의 주인공들을 만날 시간이다.",
                "진심 아니지? 날 보필할 특권을 포기할 리 없잖아. 자기애로 똘똘 뭉친 부회장 영준. 9년간 완벽하게 일해 온" +
                        "김비서가 그만둔다는 말을 믿을 수 없다. 초특급 대우에 갖은 수를 다 쓰지만 안 통한다. 그렇다면 최후의 수단..",
                "잘생긴 전학생 선오는 반경 10m에 있는 모든 여학생의 마음을 사로잡는다. 오직 조조만 빼고, 하지만 선오와" +
                        "비밀스러운 키스를 나눈 후, 조조의 굳게 닫힌 마음이 열리기 시작한다.",
                "낡고 어둡고 불쾌한 이곳엔 스산한 기운이 감돈다. 진실을 숨긴 채 새 이웃을 맞이하는 사람들. " +
                        "순진한 자에겐 함정이요, 악인에겐 천국인 곳. 에덴 고시원에 잘 오셨습니다.",
                "탈영병을 잡는다. 이등병 준호에게 떨어진 새로운 임무. 그는 탈영병들을 추적하며 지독하게 고통스러운 현실을 마주한다." +
                        "그리고 아무리 도망쳐도 벗어날 수 없다는 것도 알게된다.",
                "햔 먆은 중생이여, 술 한잔 하시겠는가? 500년간 포차를 운영해 온 이모와 신비한 능력이 있는 청년이 알바생으로" +
                        "있다네. 이곳에 오면 어떤 고민이든 해결해 주고말고!",
                "인기 개그 웹툰 <<마음의 소리>> 가 드라마로 찾아왔다! 조석과 괴짜 가족들이 펼치는 상상 이하 + 요절복통 코미디 시리즈.",

                "내가 예뻐졌다. 나는, 예쁘다! 무려 이상형이란 얘기를 들을 만큼. 이제 바뀐 외모로 새 출발 하나 싶었는데" +
                        "복병이 숨어 있었네? 성형 전의 날 아는 사람이 나타날 줄이야!",
                "킹덤 : 야신전, 가족을 잃었다. 부락도 몰살당했다. 홀로 남은 그녀가 세상을 살아갈 이유는 단 하나." +
                        " 원수에게 당한 만큼, 아니 그 이상을 갚아주는 것. 피의 복수를 향해 달려가는 그녀에게 자비란 없다."
        };

        String [] slide_webtoon_year = {
                "2019 \t 19+ \t 시즌 1개",
                "2020 \t 15+ \t 시즌 1개",
                "2018 \t 15+ \t 시즌 1개 ",
                "2021 \t 15+ \t 시즌 2개",
                "2019 \t 19+ \t 시즌 1개",
                "2021 \t 15+ \t 시즌 1개",
                "2020 \t 15+ \t 시즌 1개",
                "2016 \t 12+ \t 시즌 1개",
                "2018 \t 15+ \t 시즌 1개",
                "2021 \t 18+ \t 1시간 33분"
        };

        String [] slide_webtoon_people = {
                "출연 : 송강, 한소희, 채종협, 이열음, 양혜지",
                "출연 : 조병규, 유준상, 김세정, 엄혜란, 안석환",
                "출연 : 박서준, 박민영, 이태환, 황찬성, 김혜옥, 김병옥",
                "출연 : 김소현, 정가람, 송강, 고민시, 기도훈",
                "출연 : 이동욱, 임시완, 이정은, 이현욱, 박종환, 이중옥, 안은진",
                "출연 : 정혜인, 구교환, 김성균, 손석구",
                "출연 : 황정음, 육성재, 최원영, 이준혁, 정다은, 나인우, 엄혜란",
                "출연 : 이광수, 김대명, 정소민, 김병옥, 김미경",
                "출연 : 임수향, 차은우, 조우리, 곽동연, 박주미, 우현, 도희, 이태선",
                "출연 : 전지현, 박병은, 김시아, 김뢰하, 구교환"
        };

        String [] slide_webtoon_director = {
                "감독 : 김가람, 정원",
                "감독 : 유선동, 여지나, 김새봄",
                "감독 : 박준화, 백선우, 최보림",
                "감독 : 김진우, 이나정, 공작소 류",
                "감독 : 이창희, 정이도,",
                "감독 : 한준희, 김보통,",
                "감독 : 박준서, 안제현, 신상윤",
                "감독 : 하병훈, 이병훈, 권혜주",
                "감독 : 최성범, 수영",
                "감독 : 김성훈, 김은희"
        };


        try {

            for (int i=0; i<slide_fileName.length; i++) {
                FileOutputStream outFs = openFileOutput(slide_fileName[i],
                        Context.MODE_PRIVATE);
                //영화 제목
                outFs.write(webtoon[i].getBytes());
                outFs.write(strs.getBytes());
                //영화 제작 연도, 연령가, 시즌
                outFs.write(slide_webtoon_year[i].getBytes());
                outFs.write(strs.getBytes());
                //등장인물
                outFs.write(slide_webtoon_people[i].getBytes());
                outFs.write(strs.getBytes());
                //파일 내용
                outFs.write(webtoon_descript[i].getBytes());
                outFs.write(strs.getBytes());
                //디렉터
                outFs.write(slide_webtoon_director[i].getBytes());
                outFs.write(strs.getBytes());

                //파일입출력 종료.
                outFs.close();
            }

        } catch (IOException e) {
        }
    }

    //노래 틀기. --------------------------------------------------------------------
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