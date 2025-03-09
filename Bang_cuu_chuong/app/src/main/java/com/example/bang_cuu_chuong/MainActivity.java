package com.example.bang_cuu_chuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy ID của tất cả các nút 1-9
        for (int i = 1; i <= 9; i++) {
            int resID = getResources().getIdentifier("btn" + i, "id", getPackageName());
            Button button = findViewById(resID);
            if (button != null) {
                button.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            String table = ((Button) v).getText().toString();
            Intent intent = new Intent(MainActivity.this, MultiplicationActivity.class);
            intent.putExtra("table", Integer.parseInt(table)); // Truyền bảng cửu chương sang Activity tiếp theo
            startActivity(intent);
        }
    }
}
