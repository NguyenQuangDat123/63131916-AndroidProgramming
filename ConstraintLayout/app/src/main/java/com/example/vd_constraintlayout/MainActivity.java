package com.example.vd_constraintlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thành phần giao diện
    private Button buttonCenter;
    private TextView textAbove;
    private EditText editBelow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        buttonCenter = findViewById(R.id.button_center);
        textAbove = findViewById(R.id.text_above);
        editBelow = findViewById(R.id.edit_below);

        // Thiết lập sự kiện OnClickListener cho buttonCenter
        buttonCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy nội dung từ editBelow
                String inputText = editBelow.getText().toString();
                // Hiển thị nội dung lên textAbove
                textAbove.setText(inputText);
            }
        });

        // Thiết lập padding cho view chính để xử lý insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
