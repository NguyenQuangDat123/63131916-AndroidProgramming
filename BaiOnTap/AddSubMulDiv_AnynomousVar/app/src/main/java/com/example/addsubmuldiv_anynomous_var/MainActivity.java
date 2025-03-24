package com.example.addsubmuldiv_anynomous_var;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtNumber1, edtNumber2;
    private TextView txtResult;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        //Dùng bộ lắng nghe là một biến đối tượng của lớp OnClickListener
        View.OnClickListener variableListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(v);
            }
        };
        btnAdd.setOnClickListener(variableListener);
        btnSubtract.setOnClickListener(variableListener);

        //  Dùng bộ lắng nghe ẩn danh
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(v);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(v);
            }
        });
    }

    private void calculate(View view) {
        try {
            double num1 = Double.parseDouble(edtNumber1.getText().toString());
            double num2 = Double.parseDouble(edtNumber2.getText().toString());
            double result = 0;

            if (view.getId() == R.id.btnAdd) {
                result = num1 + num2;
            } else if (view.getId() == R.id.btnSubtract) {
                result = num1 - num2;
            } else if (view.getId() == R.id.btnMultiply) {
                result = num1 * num2;
            } else if (view.getId() == R.id.btnDivide) {
                if (num2 == 0) {
                    Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
            }
            txtResult.setText("Kết quả: " + result);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
