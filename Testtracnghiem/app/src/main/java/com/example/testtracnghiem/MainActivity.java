package com.example.testtracnghiem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView num1, num2, questionNumber, scoreText;
    private Button btn1, btn2, btn3, btn4, nextButton;
    private int correctAnswer, currentQuestion = 1, correctCount = 0;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        questionNumber = findViewById(R.id.questionNumber);
        scoreText = findViewById(R.id.scoreText);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        nextButton = findViewById(R.id.nextButton);

        generateQuestion();

        View.OnClickListener answerListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button selectedButton = (Button) v;
                int selectedAnswer = Integer.parseInt(selectedButton.getText().toString());

                if (selectedAnswer == correctAnswer) {
                    correctCount++;
                }

                if (currentQuestion < 10) {
                    currentQuestion++;
                    generateQuestion();
                } else {
                    scoreText.setText("Bạn đã hoàn thành! Đúng: " + correctCount + "/10");
                    disableButtons();
                }
            }
        };

        btn1.setOnClickListener(answerListener);
        btn2.setOnClickListener(answerListener);
        btn3.setOnClickListener(answerListener);
        btn4.setOnClickListener(answerListener);

        nextButton.setOnClickListener(v -> {
            if (currentQuestion < 10) {
                generateQuestion();
            }
        });
    }

    private void generateQuestion() {
        int number1 = random.nextInt(20) + 1;
        int number2 = random.nextInt(20) + 1;
        correctAnswer = number1 + number2;

        num1.setText(String.valueOf(number1));
        num2.setText(String.valueOf(number2));
        questionNumber.setText("Câu: " + currentQuestion);
        scoreText.setText("Số câu đúng " + correctCount + "/10");

        int correctPosition = random.nextInt(4);
        int[] answers = new int[4];

        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                answers[i] = correctAnswer;
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(40) + 1;
                } while (wrongAnswer == correctAnswer);
                answers[i] = wrongAnswer;
            }
        }

        btn1.setText(String.valueOf(answers[0]));
        btn2.setText(String.valueOf(answers[1]));
        btn3.setText(String.valueOf(answers[2]));
        btn4.setText(String.valueOf(answers[3]));
    }

    private void disableButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        nextButton.setEnabled(false);
    }
}
