package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ChienCoAdapter adapter;
    ArrayList<ChienCo> chienCoList;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        chienCoList = new ArrayList<>();
        String type = getIntent().getStringExtra("type");

        if ("chienco".equals(type)) {
            chienCoList.add(new ChienCo(R.drawable.tiemkich, "Tiêm Kích"));
            chienCoList.add(new ChienCo(R.drawable.tiachop, "Tia Chớp"));
            chienCoList.add(new ChienCo(R.drawable.unglua, "Ưng Lửa"));
            chienCoList.add(new ChienCo(R.drawable.bongma, "Bóng Ma"));
            chienCoList.add(new ChienCo(R.drawable.loithan, "Lôi Thần"));
            chienCoList.add(new ChienCo(R.drawable.binhminh, "Bình Minh"));
            chienCoList.add(new ChienCo(R.drawable.luoiriu, "Lưỡi Rìu"));
        } else {
            chienCoList.add(new ChienCo(R.drawable.scc_hiepsi, "Hiệp Sĩ"));
            chienCoList.add(new ChienCo(R.drawable.scc_hoatuong, "Hỏa Tướng"));
            chienCoList.add(new ChienCo(R.drawable.scc_tuthan, "Tử Thần"));
        }

        adapter = new ChienCoAdapter(chienCoList, this);
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            DialogAddEdit dialog = new DialogAddEdit(this, chienCoList, adapter, -1);
            dialog.show();
        });
    }
}
