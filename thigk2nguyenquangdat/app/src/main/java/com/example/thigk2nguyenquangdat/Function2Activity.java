package com.example.thigk2nguyenquangdat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Function2Activity extends AppCompatActivity {

    EditText edtThang, edtNam;
    Button btnCheck;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function2);

        edtThang = findViewById(R.id.edtThang);
        edtNam = findViewById(R.id.edtNam);
        btnCheck = findViewById(R.id.btnCheck);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thangStr = edtThang.getText().toString();
                String namStr = edtNam.getText().toString();

                int thang = 0, nam = 0;
                try {
                    thang = Integer.parseInt(thangStr);
                    nam = Integer.parseInt(namStr);
                } catch (NumberFormatException e) {
                    txtKetQua.setText("Vui lòng nhập số hợp lệ!");
                    return;
                }

                if (thang == 4 && nam == 1975) {
                    txtKetQua.setText("Đúng");
                } else {
                    txtKetQua.setText("Sai");
                }
            }
        });
    }
}
