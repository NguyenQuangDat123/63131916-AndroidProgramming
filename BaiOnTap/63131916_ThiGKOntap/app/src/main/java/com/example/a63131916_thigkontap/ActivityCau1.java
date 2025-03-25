package com.example.a63131916_thigkontap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityCau1 extends AppCompatActivity {
    EditText edtSoA, edtSoB, edtKetQua;
    Button btnTinhTong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);

        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        edtKetQua = findViewById(R.id.edtKetQua);
        btnTinhTong = findViewById(R.id.btnTinhTong);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Lấy số a và b
                    double soA = Double.parseDouble(edtSoA.getText().toString());
                    double soB = Double.parseDouble(edtSoB.getText().toString());

                    // Tính tổng
                    double tong = soA + soB;

                    // Hiển thị kết quả
                    edtKetQua.setText(String.valueOf(tong));
                } catch (NumberFormatException e) {
                    Toast.makeText(ActivityCau1.this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
