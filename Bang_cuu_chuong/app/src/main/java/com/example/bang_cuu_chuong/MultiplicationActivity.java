package com.example.bang_cuu_chuong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MultiplicationActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private EditText etAnswer;
    private Button btnCheck;
    private int currentTable;
    private int num1, num2;
    private int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);

        // Ánh xạ ID
        tvQuestion = findViewById(R.id.tvQuestion);
        etAnswer = findViewById(R.id.etAnswer);
        btnCheck = findViewById(R.id.btnCheck);
        GridLayout gridNumbers = findViewById(R.id.gridNumbers);

        // Nhận bảng cửu chương từ Intent
        currentTable = getIntent().getIntExtra("table", 2);

        // Tạo câu hỏi đầu tiên
        generateQuestion();

        // Sự kiện nút Check
        btnCheck.setOnClickListener(view -> checkAnswer());

        // Sự kiện cho các nút 1-12
        for (int i = 1; i <= 12; i++) {
            int resID = getResources().getIdentifier("btn" + i, "id", getPackageName());
            Button numberButton = findViewById(resID);
            if (numberButton != null) {
                numberButton.setOnClickListener(view -> etAnswer.setText(numberButton.getText().toString()));
            }
        }
    }

    // Sinh câu hỏi ngẫu nhiên trong bảng cửu chương đã chọn
    private void generateQuestion() {
        Random random = new Random();
        num1 = currentTable;
        num2 = random.nextInt(12) + 1;
        correctAnswer = num1 * num2;
        tvQuestion.setText(num1 + " x " + num2 + " = ?");
        etAnswer.setText(""); // Reset ô nhập
    }

    // Kiểm tra đáp án
    private void checkAnswer() {
        String answerText = etAnswer.getText().toString();
        if (!answerText.isEmpty()) {
            int userAnswer = Integer.parseInt(answerText);
            if (userAnswer == correctAnswer) {
                Toast.makeText(this, "Chính xác!", Toast.LENGTH_SHORT).show();
                generateQuestion(); // Sinh câu hỏi mới
            } else {
                Toast.makeText(this, "Sai rồi! Đáp án đúng là " + correctAnswer, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Vui lòng nhập câu trả lời!", Toast.LENGTH_SHORT).show();
        }
    }
}
