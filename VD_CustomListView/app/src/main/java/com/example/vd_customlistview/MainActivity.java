package com.example.vd_customlistview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private CountryAdapter adapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        countryList = new ArrayList<>();

        // Thêm dữ liệu vào danh sách
        countryList.add(new Country("Vietnam", "98000000", R.drawable.flag_vietnam));
        countryList.add(new Country("United States", "320000000", R.drawable.flag_usa));
        countryList.add(new Country("Russia", "142000000", R.drawable.flag_russia));

        adapter = new CountryAdapter(this, countryList);
        listView.setAdapter(adapter);
    }
}
