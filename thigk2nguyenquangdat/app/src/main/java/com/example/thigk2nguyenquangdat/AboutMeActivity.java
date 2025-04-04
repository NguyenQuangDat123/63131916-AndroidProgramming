package com.example.thigk2nguyenquangdat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

public class AboutMeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        ImageView imgIntroduce = findViewById(R.id.imgIntroduce);
        imgIntroduce.setImageResource(R.drawable.introduce);
    }
}