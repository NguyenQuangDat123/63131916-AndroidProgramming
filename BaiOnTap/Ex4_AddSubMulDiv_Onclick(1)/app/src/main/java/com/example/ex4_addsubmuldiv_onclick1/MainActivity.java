package com.example.ex4_addsubmuldiv_onclick1;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        txtResult = findViewById(R.id.txtResult);
    }

    public void calculate(View view) {
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
            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
