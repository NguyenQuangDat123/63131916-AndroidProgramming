package com.example.apptinhcv_dt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ChuViActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuvi);

        EditText edtCanhA = findViewById(R.id.edtCanhA);
        EditText edtCanhB = findViewById(R.id.edtCanhB);
        Button btnTinhChuVi = findViewById(R.id.btnTinhChuVi);
        TextView txtKetQuaChuVi = findViewById(R.id.txtKetQuaChuVi);

        btnTinhChuVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(edtCanhA.getText().toString());
                double b = Double.parseDouble(edtCanhB.getText().toString());
                double chuVi = 2 * (a + b);
                txtKetQuaChuVi.setText("Kết quả: " + chuVi);
            }
        });
    }
}
