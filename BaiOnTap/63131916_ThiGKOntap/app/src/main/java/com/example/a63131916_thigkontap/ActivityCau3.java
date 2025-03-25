package com.example.a63131916_thigkontap;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ActivityCau3 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Country> countryList;
    CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);

        recyclerView = findViewById(R.id.recyclerView);

        // Kiểm tra nếu RecyclerView bị null
        if (recyclerView == null) {
            throw new RuntimeException("Lỗi: Không tìm thấy RecyclerView. Kiểm tra ID trong activity_cau3.xml");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo danh sách quốc gia
        countryList = new ArrayList<>();
        countryList.add(new Country("Việt Nam", R.drawable.vietnam));
        countryList.add(new Country("Mỹ", R.drawable.usa));
        countryList.add(new Country("Nhật Bản", R.drawable.japan));
        countryList.add(new Country("Hàn Quốc", R.drawable.korea));
        countryList.add(new Country("Pháp", R.drawable.france));

        // Gán adapter cho RecyclerView
        countryAdapter = new CountryAdapter(this, countryList);
        recyclerView.setAdapter(countryAdapter);
    }
}
