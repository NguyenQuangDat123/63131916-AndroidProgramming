package com.example.listbaihatyeuthich;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> nguonDuLieu = new ArrayList<String>();
        nguonDuLieu.add("Love me");
        nguonDuLieu.add("Replay");
        nguonDuLieu.add("Solo");
        nguonDuLieu.add("Savage");

        ListView listViewBH = (ListView) findViewById(R.id.lvDSbaihat);

        ArrayAdapter<String> baiHat_Adapter = new ArrayAdapter<String>(this,
                                                    android.R.layout.simple_list_item_1, nguonDuLieu);

        listViewBH.setAdapter(baiHat_Adapter);

        listViewBH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String value = baiHat_Adapter.getItem(i);
                Toast.makeText( MainActivity.this, value, Toast.LENGTH_LONG).show();
            }
        });


    }
}