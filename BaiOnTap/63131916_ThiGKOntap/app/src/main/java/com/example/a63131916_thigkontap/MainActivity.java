package com.example.a63131916_thigkontap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnCau1, btnCau2, btnCau3, btnCau4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCau1 = findViewById(R.id.btnCau1);
        btnCau2 = findViewById(R.id.btnCau2);
        btnCau3 = findViewById(R.id.btnCau3);
        btnCau4 = findViewById(R.id.btnCau4);

        btnCau1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityCau1.class);
            startActivity(intent);
        });

        btnCau2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityCau2.class);
            startActivity(intent);
        });

        btnCau3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityCau3.class);
            startActivity(intent);
        });

        btnCau4.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityCau4.class);
            startActivity(intent);
        });
    }
}
