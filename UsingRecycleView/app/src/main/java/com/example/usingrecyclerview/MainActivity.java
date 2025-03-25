package com.example.usingrecyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    LandScapeAdapter adapter;
    ArrayList<LandScape> list;

    RecyclerView recyclerViewLandScape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<LandScape>();
        list.add(new LandScape("Cột cờ Hà Nội", "flag_tower_of_hanoi"));
        list.add(new LandScape("Tháp Eiffel", "effel"));
        list.add(new LandScape("Cung điện Buckingham", "buckingham"));
        list.add(new LandScape("Tượng nữ thần tự do", "statue_of_liberty"));

        recyclerViewLandScape = findViewById(R.id.rVLandScape);

        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutLinear);

        adapter = new LandScapeAdapter(this, list);

        recyclerViewLandScape.setAdapter(adapter);
    }
}