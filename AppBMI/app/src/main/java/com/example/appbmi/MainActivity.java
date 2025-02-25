package com.example.appbmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etHeight, etWeight;
    private Button btnCalculate;
    private TextView tvResult, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
        tvStatus = findViewById(R.id.tvStatus);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = etHeight.getText().toString();
        String weightStr = etWeight.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            tvResult.setText("0.0");
            tvStatus.setText("Vui lòng nhập đầy đủ thông tin");
            return;
        }

        double height = Double.parseDouble(heightStr) / 100; // Chuyển cm thành mét
        double weight = Double.parseDouble(weightStr);
        double bmi = weight / (height * height);
        tvResult.setText(String.format("%.1f", bmi));

        String message = getString(bmi);

        tvStatus.setText(message);
    }

    @NonNull
    private static String getString(double bmi) {
        String message;
        if (bmi < 18.5) {
            message = "Bạn đang khá gầy, cần bổ sung thêm chất dinh dưỡng để cải thiện sức khỏe!";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            message = "Sức khỏe của bạn rất tốt! Hãy tiếp tục phát huy chế độ ăn uống và tập luyện nhé!";
        } else if (bmi >= 25 && bmi < 29.9) {
            message = "Bạn đang hơi thừa cân, hãy tập thể dục thường xuyên để duy trì sức khỏe!";
        } else {
            message = "Bạn đang khá nặng, hãy giảm cân để bảo vệ sức khỏe của mình nhé!";
        }
        return message;
    }
}