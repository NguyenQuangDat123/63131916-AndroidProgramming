package com.example.simplesumapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB, edtKQ;
    private Button btnCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnCong = findViewById(R.id.btnCong);

        // Lắng nghe sự kiện nhấn nút
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhTong();
            }
        });
    }

    private void tinhTong() {
        try {
            // Lấy số từ EditText
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());

            // Tính tổng
            int tong = a + b;

            // Hiển thị kết quả
            edtKQ.setText(String.valueOf(tong));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
