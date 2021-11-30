# Netflix_-android_studio

안드로이드 스튜디오를 이용한 나만의 넷플릭스를 만들어보았습니다. <br>
2021년도 2학기 모바일 프로그래밍 프로젝트 / Manifest & java Dir & res Dir <br>
_> <b> 반드시 배운 내용을 활용하여 만들 것. 외부 프로젝트 가져오기 X </b><br>
_> <b> 수업시간에 사용한 메인 프로젝트 1개 이상, 과제는 5개 이상 섞기. </b><br>

1.mainActivity :  11/26완료. <br>
&nbsp; &nbsp; &nbsp; 기능 1 : 이미지 버튼 사용하여 NetFilx 이미지 클릭시 프로젝트 시작. <br>
&nbsp; &nbsp; &nbsp; 기능 2 : NetFilx 이미지버튼 클릭시 bgm(mp3) 나오게 함.  <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; + 앱 실행시 bgm 나오기는 배우지 않음 -> xml 하나를 더 만듬. <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; --> if 앱 실행시 bgm 나오게 하려면 --> https://blog.naver.com/ga5336/222486194811 참조 <br>
&nbsp; &nbsp; &nbsp; 기능 3 : 눈에 보이지는 않지만 버튼 클릭시 파일 생성하여 영화 포스터에 대한 정보 생성. <br><br>


2. ChooseCharacter : 넷플릭스 시작 전 계정 고르기 -> RelativeLayout 사용. <br>
&nbsp; &nbsp; &nbsp; 기능 1 : 1번째 이미지 버튼은 메인 프로젝트 (배운내용에 메인 프로젝트 응용) 실행 <br>
&nbsp; &nbsp; &nbsp; 기능 2 : 2번째 이미지 버튼은 자기소개 self_info 실행 <br>
&nbsp; &nbsp; &nbsp; 기능 3 : 3번째 이미지 버튼은 수업시간에 사용한 과제는 5개 이상을 섞어봄. project_desc <br>
&nbsp; &nbsp; &nbsp; 기능 4 : 4번째 이미지 버튼은 메인 GitHub의 작업 내용 페이지 연결. <br><br>

3. MainProject : 수업시간의 배운 내용 가지고 응용. <br>
&nbsp; &nbsp; &nbsp; 기능 1 : AutoCompleteTextView 사용하여 검색하기 -> 검색 후 이미지 불러오기 제한으로 두기만 함. (11/30) <br>
&nbsp; &nbsp; &nbsp; 기능 2 : 오징어 게임 메인 화면. (기능 별로 없음) (11/28) <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; --> 재생, 찜하기, 다운로드 버튼 누르면 Toast로 구현이 안됐습니다. 출력. <br><br>

&nbsp; &nbsp; &nbsp; 기능 3 : 1번째 줄 10개의 Image -> HorizontalScrollView 사용하여 가로로 넘겨보게 함. 13주차 명화 투표 앱 기능을 응용.  (11/23) <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; + 이미지 클릭시 토스트로 투표 증가 및 투표 수 보여줌.  <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ++ 투표완료 버튼 누르면 VoteResultButton으로 넘어가서 가장 많이 투표 된 Image의 Poster 출력 및 투표 현황 보여줌. (11/30) <br><br>

&nbsp; &nbsp; &nbsp; 기능 4 : 2번째 줄 1번째와 같이 HorizontalScrollView 사용. + 11주차 파일 입출력 응용. (11/28) <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; + mainActivity에서 저장한 파일을 꺼냄. ImaegView 누르면 해당 image에 해당하는 파일이름을 Movie_des로 넘겨서 Movie_des에서 show  <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ++ image 또한 같이 intent로 넘겨 화질이 좋지 않음. 밑의 3-6에서는 더 선명하게 처리. <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; +++ 10개의 이미지 사용하였으나 1개의 java file로 구현. (11/28) <br><br>

&nbsp; &nbsp; &nbsp; 기능 5 : 3번째 줄 1번째와 같이 HorizontalScrollView 사용. + frameLayout을 사용. (11/29) <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; + 파일입출력 사용 X, ImaegView 누르면 해당 image에 해당하는 정보를 frameLayout으로 show  <br><br>

&nbsp; &nbsp; &nbsp; 기능 6 : 4번째 줄 서랍을 열면 Image나옴, 내부는 HorizontalScrollView 사용. + 파일 입출력 사용. (11/30) <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; + ImaegView 누르면 2번줄과 같이 SlideResult에 mainActivity에서 저장한 파일이름를 보냄.  <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ++ ResultActivity에서는 파일 이름를 받아서 그 파일 open, 그리고 해당 xml에서 show  <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; +++ 기능 3-4와 마찬가지로 10개의 image, 1개의 xml 파일 사용.  <br><br>

4. self_info : 자기소개 파일 <br><br>

5. project_desc : 과제 모음,  수업시간에 사용한 과제를 5개 이상을 섞어봄.  <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 1. 9주차 4번 자동완성,멀티 텍스트뷰 <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 2. 9주차 5번 프로그레밍, 시크, 레이팅바 사용 <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 3. 12주차 4번 포토샵 기능 <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 4. 9주차 2번 서랍 확장 <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 5. 9주차 1번 서랍 닫기    <br><br>                



<h2>주요기능 및 완성</h2>

1. mp3 기능 넣기 -> -> ImageButton을 클릭하면 두둥 하는 bgm(mp3) 나오게 하기 // 11/26 완료 <br>
2. 명화 선호도 기능 넣기 // 11/25 완료 <br>
3. 일기장과 같이 파일 입출력 기능 사용하여 영화 설명 Page 구성 // 11/27 완료 <br>
4. GridLayout을 통한 포스터 보기 -> HorizontalScrollView로 인해 제약 -> FrameLayoutd으로 수정. // 11월 29일 <br>
5. 추가적으로 더 보고싶으면 서랍 열어서 영화보기. -> 퍄일 입출력 및 서랍 사용 // 11월 29일 완료. <br>
6. 자기 소개 화면 -> RelativeLayout 사용. // 11/28일 완료<br>
7. AutoCompleteTextView 자동 검색 기능 -> 11/30일 탑재. but 구현 가능한 기능이 너무 제한되어있음. -> 탑재만 함, 기능구현X <br>

<h2> 시행착오 </h2>
2021.11.28 일 : 자기소개 XML / Java 파일 완성 <br>
&nbsp; &nbsp; &nbsp; 실패내역1 : 서랍을 통해 포스터 종류 및 공간 늘리기 -> Tabhost 사용으로 인한 공간 늘리기 불가. <br>
&nbsp; &nbsp; &nbsp; 실패내역2 : AutoCompleteTextView -> 이미지 출력하라면 ArrayList 사용, <br>
&nbsp; &nbsp; &nbsp; 실패내역3 : GridView -> HorizontalScrollView 사용으로 인한 사용 불가. <br>

<br>

2021.11.29 월 : 과제 모음 5개 XML / Java 파일 완성 <br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; : 제약이 너무 많아서 Tabhost 사용 X, 하단바 없애고 검색 페이지와 합치기  <br>
<img width="20%" src="https://user-images.githubusercontent.com/38518648/143816131-94c90ca2-3ea4-4925-96a5-4f43c4a6f721.png"/>
<img width="20%" src="https://user-images.githubusercontent.com/38518648/143816247-62c7d234-702a-434f-8485-303f510ba816.png"/>
다음과 같이 하나로 합쳐짐  --->>
<img width="20%" src="https://user-images.githubusercontent.com/38518648/144051971-84405fac-b033-4bcb-ad62-8ece361075c0.png"/>

