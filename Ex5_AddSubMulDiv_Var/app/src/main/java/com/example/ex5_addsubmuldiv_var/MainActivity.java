package com.example.ex5_addsubmuldiv_var;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextSo1, editTextSo2, editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();

        // Kiểm tra các button có null không trước khi gán sự kiện
        if (nutCong != null) nutCong.setOnClickListener(v -> XuLy_Cong());
        if (nutTru != null) nutTru.setOnClickListener(v -> XuLy_Tru());
        if (nutNhan != null) nutNhan.setOnClickListener(v -> XuLy_Nhan());
        if (nutChia != null) nutChia.setOnClickListener(v -> XuLy_Chia());
    }

    void TimDieuKhien() {
        editTextSo1 = findViewById(R.id.edtSo1);
        editTextSo2 = findViewById(R.id.edtSo2);
        editTextKQ = findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }

    private boolean kiemTraNhap() {
        if (editTextSo1 == null || editTextSo2 == null || editTextKQ == null) {
            Toast.makeText(this, "Lỗi khởi tạo giao diện!", Toast.LENGTH_SHORT).show();
            return false;
        }

        String so1 = editTextSo1.getText().toString().trim();
        String so2 = editTextSo2.getText().toString().trim();

        if (so1.isEmpty() || so2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập cả hai số!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void onClick(View view) {
        XuLy_Cong();
    }

    public void XuLyTru(View view) {
        XuLy_Tru();
    }

    public void XuLyNhan(View view) {
        XuLy_Nhan();
    }

    public void XuLyChia(View view) {
        XuLy_Chia();
    }

    void XuLy_Cong() {
        if (!kiemTraNhap()) return;
        try {
            float num1 = Float.parseFloat(editTextSo1.getText().toString());
            float num2 = Float.parseFloat(editTextSo2.getText().toString());
            float tong = num1 + num2;
            editTextKQ.setText(String.valueOf(tong));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }

    void XuLy_Tru() {
        if (!kiemTraNhap()) return;
        try {
            float num1 = Float.parseFloat(editTextSo1.getText().toString());
            float num2 = Float.parseFloat(editTextSo2.getText().toString());
            float tong = num1 - num2;
            editTextKQ.setText(String.valueOf(tong));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }

    void XuLy_Nhan() {
        if (!kiemTraNhap()) return;
        try {
            float num1 = Float.parseFloat(editTextSo1.getText().toString());
            float num2 = Float.parseFloat(editTextSo2.getText().toString());
            float tong = num1 * num2;
            editTextKQ.setText(String.valueOf(tong));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }

    void XuLy_Chia() {
        if (!kiemTraNhap()) return;
        try {
            float num1 = Float.parseFloat(editTextSo1.getText().toString());
            float num2 = Float.parseFloat(editTextSo2.getText().toString());
            if (num2 == 0) {
                Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                return;
            }
            float tong = num1 / num2;
            editTextKQ.setText(String.valueOf(tong));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
