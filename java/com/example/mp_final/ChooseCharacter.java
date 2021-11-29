package com.example.mp_final;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseCharacter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosecharacter);

        ImageButton btn1 = (ImageButton) findViewById(R.id.man1);
        ImageButton btn2 = (ImageButton) findViewById(R.id.man2);
        ImageButton btn3 = (ImageButton) findViewById(R.id.man3);
        ImageButton btn4 = (ImageButton) findViewById(R.id.man4);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),
                        MainProject.class);

                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),
                        self_info.class);

                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),
                        project_desc.class);

                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),
                        MainProject.class);

                startActivity(intent);
            }
        });
    }
}
