package com.example.thigk2nguyenquangdat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Function3Activity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> songList;
    ArrayAdapter<String> adapter;
    Button btnAdd, btnEdit, btnDelete;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function3);

        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

        // Danh sách bài hát mặc định
        songList = new ArrayList<>();
        songList.add("Tiến về Sài Gòn");
        songList.add("Giải phóng Miền nam");
        songList.add("Đất nước trọn niềm vui");
        songList.add("Bài ca thống nhất");
        songList.add("Mùa xuân trên thành phố HCM");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, songList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Bắt sự kiện chọn item
        listView.setOnItemClickListener((adapterView, view, i, l) -> selectedIndex = i);

        btnAdd.setOnClickListener(v -> showInputDialog("Thêm bài hát", "", name -> {
            songList.add(name);
            adapter.notifyDataSetChanged();
        }));

        btnEdit.setOnClickListener(v -> {
            if (selectedIndex >= 0) {
                showInputDialog("Sửa bài hát", songList.get(selectedIndex), name -> {
                    songList.set(selectedIndex, name);
                    adapter.notifyDataSetChanged();
                });
            } else {
                Toast.makeText(this, "Chọn một bài hát để sửa", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(v -> {
            if (selectedIndex >= 0) {
                songList.remove(selectedIndex);
                selectedIndex = -1;
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Chọn một bài hát để xoá", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showInputDialog(String title, String currentText, final OnNameEnteredListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);

        final EditText input = new EditText(this);
        input.setText(currentText);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String name = input.getText().toString().trim();
            if (!name.isEmpty()) {
                listener.onEntered(name);
            }
        });

        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    interface OnNameEnteredListener {
        void onEntered(String name);
    }
}