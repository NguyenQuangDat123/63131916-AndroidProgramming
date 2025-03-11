package com.example.listviewbaihat_caitien2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private EditText edtSong;
    private Button btnAdd, btnEdit, btnDelete;
    private ListView lvSongs;
    private ArrayList<String> songList;
    private SongAdapter adapter;
    private int selectedIndex = -1;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "SongListPref";
    private static final String SONGS_KEY = "songs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        edtSong = findViewById(R.id.edtSongName);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        lvSongs = findViewById(R.id.lvSongs);

        // Khởi tạo danh sách
        songList = new ArrayList<>();
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        loadSongs(); // Tải danh sách đã lưu

        // Gán Adapter tùy chỉnh
        adapter = new SongAdapter(this, songList);
        lvSongs.setAdapter(adapter);

        // Xử lý sự kiện chọn item
        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
                edtSong.setText(songList.get(position)); // Hiển thị bài hát lên EditText
            }
        });

        // Thêm bài hát
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String song = edtSong.getText().toString().trim();
                if (!song.isEmpty()) {
                    songList.add(song);
                    adapter.notifyDataSetChanged();
                    edtSong.setText("");
                    saveSongs();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên bài hát!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Sửa bài hát
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex != -1) {
                    String newSong = edtSong.getText().toString().trim();
                    if (!newSong.isEmpty()) {
                        songList.set(selectedIndex, newSong);
                        adapter.notifyDataSetChanged();
                        edtSong.setText("");
                        selectedIndex = -1;
                        saveSongs();
                    } else {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập tên bài hát!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn bài hát cần sửa!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xóa bài hát
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedIndex != -1) {
                    songList.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    edtSong.setText("");
                    selectedIndex = -1;
                    saveSongs();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn bài hát cần xóa!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Lưu danh sách bài hát vào SharedPreferences
    private void saveSongs() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> songSet = new HashSet<>(songList);
        editor.putStringSet(SONGS_KEY, songSet);
        editor.apply();
    }

    // Tải danh sách bài hát từ SharedPreferences
    private void loadSongs() {
        Set<String> songSet = sharedPreferences.getStringSet(SONGS_KEY, new HashSet<String>());
        songList.clear();
        songList.addAll(songSet);
    }
}
