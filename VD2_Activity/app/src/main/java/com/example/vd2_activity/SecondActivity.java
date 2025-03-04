package com.example.vd2_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {
    EditText edtHoTen, edtNamSinh;
    Button btnOK, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtNamSinh = findViewById(R.id.edtNamSinh);
        btnOK = findViewById(R.id.btnOK);
        btnHuy = findViewById(R.id.btnHuy);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String hoTen = edtHoTen.getText().toString().trim();
                    String namSinh = edtNamSinh.getText().toString().trim();

                    if (hoTen.isEmpty() || namSinh.isEmpty()) {
                        Toast.makeText(SecondActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("hoTen", hoTen);
                    resultIntent.putExtra("namSinh", namSinh);
                    setResult(RESULT_OK, resultIntent);
                    finish(); // Trả về MainActivity
                } catch (Exception e) {
                    Toast.makeText(SecondActivity.this, "Lỗi khi nhập dữ liệu!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish(); // Quay lại MainActivity mà không gửi dữ liệu
            }
        });
    }
}
