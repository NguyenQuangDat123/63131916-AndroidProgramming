package com.example.a63131916_thigkontap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ActivityCau2 extends AppCompatActivity {
    EditText edtBaiHat;
    Button btnThem;
    ListView lvBaiHat;
    ArrayList<String> danhSachBaiHat;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);

        edtBaiHat = findViewById(R.id.edtBaiHat);
        btnThem = findViewById(R.id.btnThem);
        lvBaiHat = findViewById(R.id.lvBaiHat);

        // Khởi tạo danh sách bài hát
        danhSachBaiHat = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, danhSachBaiHat);
        lvBaiHat.setAdapter(adapter);

        // Xử lý sự kiện thêm bài hát
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baiHat = edtBaiHat.getText().toString().trim();
                if (!baiHat.isEmpty()) {
                    danhSachBaiHat.add(baiHat);
                    adapter.notifyDataSetChanged();
                    edtBaiHat.setText("");
                } else {
                    Toast.makeText(ActivityCau2.this, "Vui lòng nhập tên bài hát!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện xóa bài hát khi nhấn giữ
        lvBaiHat.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                danhSachBaiHat.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
