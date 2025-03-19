package com.example.so_ngau_nhien;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvA, tvB, tvKQ;
    private Button btnGenerate;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvA = findViewById(R.id.tvSoA);
        tvB = findViewById(R.id.tvSoB);
        tvKQ = findViewById(R.id.tvKQ);
        btnGenerate = findViewById(R.id.btnGenerate);

        // Xử lý sự kiện khi nhấn nút
        btnGenerate.setOnClickListener(v -> generateRandomNumbers());
    }

    private void generateRandomNumbers() {
        int a = random.nextInt(5); // Sinh số từ 0 đến 4
        int b = random.nextInt(5);
        int kqDung = a + b;

        // Hiển thị lên giao diện
        tvA.setText(String.valueOf(a));
        tvB.setText(String.valueOf(b));
        tvKQ.setText("Kết quả: " + kqDung);
    }
}
