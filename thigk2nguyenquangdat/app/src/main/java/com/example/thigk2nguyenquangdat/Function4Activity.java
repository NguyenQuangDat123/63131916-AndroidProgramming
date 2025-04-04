package com.example.thigk2nguyenquangdat;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Function4Activity extends AppCompatActivity {

    ListView listView;
    ActivityAdapter adapter;
    ArrayList<ActivityItem> activityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function4);

        listView = findViewById(R.id.listViewActivities);
        activityList = new ArrayList<>();

        // Thêm dữ liệu mẫu
        activityList.add(new ActivityItem(R.drawable.logontu, "Tiêu đề hoạt động 1", "Thời gian"));
        activityList.add(new ActivityItem(R.drawable.logontu, "Tiêu đề hoạt động 2", "Thời gian"));
        activityList.add(new ActivityItem(R.drawable.logontu, "Tiêu đề hoạt động 3", "Thời gian"));

        adapter = new ActivityAdapter(this, activityList);
        listView.setAdapter(adapter);
    }
}
