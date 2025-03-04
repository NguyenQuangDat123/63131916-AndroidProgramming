package com.example.vd2_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText edtHoTen, edtNamSinh;
    Button btnMoNhapLieu;
    final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtNamSinh = findViewById(R.id.edtNamSinh);
        btnMoNhapLieu = findViewById(R.id.btnMoNhapLieu);

        btnMoNhapLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                String hoTen = data.getStringExtra("hoTen");
                String namSinh = data.getStringExtra("namSinh");

                if (hoTen != null && namSinh != null) {
                    edtHoTen.setText(hoTen);
                    edtNamSinh.setText(namSinh);
                } else {
                    Toast.makeText(this, "Lỗi nhận dữ liệu!", Toast.LENGTH_SHORT).show();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Bạn đã hủy nhập dữ liệu!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
