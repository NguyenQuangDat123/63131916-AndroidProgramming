package com.example.doidonvido;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DistanceActivity extends AppCompatActivity {
    private EditText edtDistance;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        edtDistance = findViewById(R.id.edtDistance);
        tvResult = findViewById(R.id.tvResultDistance);
        Button btnKmToM = findViewById(R.id.btnKmToM);
        Button btnMToKm = findViewById(R.id.btnMToKm);

        btnKmToM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertKmToM();
            }
        });

        btnMToKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertMToKm();
            }
        });
    }

    private void convertKmToM() {
        try {
            double value = Double.parseDouble(edtDistance.getText().toString());
            tvResult.setText("Kết quả: " + (value * 1000) + " m");
        } catch (Exception e) {
            tvResult.setText("Lỗi! Hãy nhập số hợp lệ.");
        }
    }

    private void convertMToKm() {
        try {
            double value = Double.parseDouble(edtDistance.getText().toString());
            tvResult.setText("Kết quả: " + (value / 1000) + " km");
        } catch (Exception e) {
            tvResult.setText("Lỗi! Hãy nhập số hợp lệ.");
        }
    }
}
