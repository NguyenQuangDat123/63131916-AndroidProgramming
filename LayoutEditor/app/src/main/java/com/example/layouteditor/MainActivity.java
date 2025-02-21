package com.example.layouteditor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button discardBtn = findViewById(R.id.discard);
        Button uploadBtn = findViewById(R.id.upload);

        discardBtn.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Discard Clicked", Toast.LENGTH_SHORT).show()
        );

        uploadBtn.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Upload Clicked", Toast.LENGTH_SHORT).show()
        );
    }
}
