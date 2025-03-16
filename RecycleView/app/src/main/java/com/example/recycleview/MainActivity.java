package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openChienCo(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        intent.putExtra("type", "chienco");
        startActivity(intent);
    }

    public void openSieuChienCo(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        intent.putExtra("type", "sieuchienco");
        startActivity(intent);
    }
}
