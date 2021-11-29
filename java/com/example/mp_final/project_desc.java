package com.example.mp_final;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SlidingDrawer;

import androidx.appcompat.app.AppCompatActivity;

public class project_desc extends AppCompatActivity {

    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark;
    ImageButton ibEmbossing, ibBlur;
    MyGraphicView graphicView;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;

    static float Embossing_state = 1;
    static float Blur_state = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_desc);

        Button btnhandle = (Button) findViewById(R.id.handle);
        Button btnExpand = (Button) findViewById(R.id.btnExpand);
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity1);
        LinearLayout BarGroup = (LinearLayout) findViewById(R.id.BarGroup);
        Button btnClose = (Button) findViewById(R.id.btnClose);


        btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BarGroup.setVisibility(View.GONE);

            }
        });

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), self_info.class);
                startActivity(intent);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlidingDrawer drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer1);
                drawer.animateClose();

                BarGroup.setVisibility(View.VISIBLE);
            }
        });

        String[] items = {
                "범죄도시", "극한직업", "베테랑", "범죄와의 전쟁", "형", "악인전", "내부자들", "감시자들", "아저씨","1987",
                "빈센조", "슬기로운 의사생활", "도깨비", "갯마을 차차차", "호텔 델루나", "이태원 클라쓰",
                "이번생은 처음이라", "사랑의 불시착", "멜로가 체질", "시그널",
                "어바웃 타임", "검사외전", "하트시그널3", "아는형님", "알고있지만", "로스쿨", "연애의 참견",
                "나우 유 씨미 마술사기단 2", "스위트 홈", "기묘한 이야기"
        };

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);
        multi.setAdapter(adapter);

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);  // pictureLayout에 이미지 출력

        clickIcons();  // 버튼 6개 관련 함수 호출
    }

    private void clickIcons() {   // 버튼 6개 관련 함수
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);

        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;  // 확대
                scaleY = scaleY + 0.2f;
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX - 0.2f; //축소
                scaleY = scaleY - 0.2f;
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);

        ibRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle = angle + 20;      // 회전
                graphicView.invalidate();  // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);

        ibBright.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color + 0.5f;    // 밝게
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);

        ibDark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                color = color - 0.5f;   // 어둡게
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibBlur = (ImageButton) findViewById(R.id.ibBlur);
        ibBlur.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Blur_state == 0)
                    Blur_state = 1;     // 기본 값 = 1, 1이상이면 채도가 높음
                else
                    Blur_state = 0;     // 회색 이미지로 변경하기 위한 값, 0이면 회색, 0~1이면 채도가 낮음
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

        ibEmbossing = (ImageButton) findViewById(R.id.ibEmbossing);
        ibEmbossing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Embossing_state == 0)
                    Embossing_state = 1;     // 기본 값 = 1, 1이상이면 채도가 높음
                else
                    Embossing_state = 0;     // 회색 이미지로 변경하기 위한 값, 0이면 회색, 0~1이면 채도가 낮음
                graphicView.invalidate(); // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
        });

    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);  // 확대, 축소 버튼의 변경 내용 반영
            canvas.rotate(angle, cenX, cenY);          // 회전 버튼의 변경내용 반영

            Paint paint = new Paint();
            float[] array = { color, 0, 0, 0, 0,  // color에 밝게하기 버튼과 어둡게하기 버튼의 변경내용  반영
                             0, color,  0, 0, 0,
                             0, 0, color, 0, 0,
                             0, 0, 0, 1, 0 };

            ColorMatrix cm = new ColorMatrix(array);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.squid_poster);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);

            BlurMaskFilter bMask;
            if (Blur_state == 0) {
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(bMask);
                canvas.drawBitmap(picture, picX, picY, paint);
                paint.setColorFilter(new ColorMatrixColorFilter(cm));
            }

            EmbossMaskFilter eMask;
            if(Embossing_state == 0) {
                eMask = new EmbossMaskFilter(new float[] { 3, 3, 100 }, 0.5f, 50, 10);
                paint.setMaskFilter(eMask);
                canvas.drawBitmap(picture, picX, picY, paint);
            }

            picture.recycle(); // 비트맵 리소스 해제
        }
    }

}
