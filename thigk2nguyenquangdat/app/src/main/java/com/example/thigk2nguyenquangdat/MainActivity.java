package com.example.thigk2nguyenquangdat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnFunction2, btnFunction3, btnFunction4, btnAboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFunction2 = findViewById(R.id.btnFunction2);
        btnFunction3 = findViewById(R.id.btnFunction3);
        btnFunction4 = findViewById(R.id.btnFunction4);
        btnAboutMe = findViewById(R.id.btnAboutMe);

        btnFunction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Function2Activity.class);
                startActivity(intent);
            }
        });

        btnFunction3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Function3Activity.class);
                startActivity(intent);
            }
        });

        btnFunction4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Function4Activity.class);
                startActivity(intent);
            }
        });

        btnAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });
    }
}