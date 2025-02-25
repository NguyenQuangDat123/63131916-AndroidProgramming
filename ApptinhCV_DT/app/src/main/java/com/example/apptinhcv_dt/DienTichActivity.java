package com.example.apptinhcv_dt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DienTichActivity extends AppCompatActivity {
    private EditText inputLength, inputWidth;
    private Button btnTinhDienTich;
    private TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dientich);  // Đảm bảo file XML đúng tên

        // Ánh xạ các thành phần trong layout
        inputLength = findViewById(R.id.inputLength);
        inputWidth = findViewById(R.id.inputWidth);
        btnTinhDienTich = findViewById(R.id.btnTinhDienTich);
        txtKetQua = findViewById(R.id.txtKetQua);

        // Xử lý sự kiện khi nhấn nút "Tính Diện Tích"
        btnTinhDienTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhDienTich();
            }
        });
    }

    private void tinhDienTich() {
        // Kiểm tra nếu người dùng chưa nhập đủ dữ liệu
        if (inputLength.getText().toString().isEmpty() || inputWidth.getText().toString().isEmpty()) {
            txtKetQua.setText("Vui lòng nhập đầy đủ giá trị!");
            return;
        }

        // Lấy giá trị từ EditText và tính diện tích
        double length = Double.parseDouble(inputLength.getText().toString());
        double width = Double.parseDouble(inputWidth.getText().toString());
        double dientich = length * width;

        // Hiển thị kết quả
        txtKetQua.setText("Diện tích: " + dientich + " m²");
    }
}
