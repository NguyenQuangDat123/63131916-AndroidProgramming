package com.example.listviewbaihat_caitien;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText edtSongName;
    Button btnAdd, btnEdit, btnDelete;
    ListView lvSongs;
    TextView tvCount;

    ArrayList<String> songList;
    ArrayAdapter<String> adapter;
    int selectedIndex = -1;

    SharedPreferences sharedPreferences;
    static final String PREFS_NAME = "SongPrefs";
    static final String KEY_SONGS = "Songs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        edtSongName = findViewById(R.id.edtSongName);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        lvSongs = findViewById(R.id.lvSongs);
        tvCount = findViewById(R.id.tvCount);

        // Đọc dữ liệu đã lưu
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        songList = new ArrayList<>(loadSongs());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
        lvSongs.setAdapter(adapter);
        updateCount();

        // Thêm bài hát
        btnAdd.setOnClickListener(view -> {
            String song = edtSongName.getText().toString().trim();
            if (!song.isEmpty()) {
                songList.add(song);
                adapter.notifyDataSetChanged();
                saveSongs();
                updateCount();
                edtSongName.setText("");
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng nhập tên bài hát!", Toast.LENGTH_SHORT).show();
            }
        });

        // Chọn bài hát từ danh sách
        lvSongs.setOnItemClickListener((adapterView, view, i, l) -> {
            selectedIndex = i;
            edtSongName.setText(songList.get(i));
        });

        // Sửa bài hát
        btnEdit.setOnClickListener(view -> {
            if (selectedIndex != -1) {
                String newSong = edtSongName.getText().toString().trim();
                if (!newSong.isEmpty()) {
                    songList.set(selectedIndex, newSong);
                    adapter.notifyDataSetChanged();
                    saveSongs();
                    edtSongName.setText("");
                    selectedIndex = -1;
                }
            } else {
                Toast.makeText(MainActivity.this, "Chọn bài hát cần sửa!", Toast.LENGTH_SHORT).show();
            }
        });

        // Xóa bài hát
        btnDelete.setOnClickListener(view -> {
            if (selectedIndex != -1) {
                songList.remove(selectedIndex);
                adapter.notifyDataSetChanged();
                saveSongs();
                edtSongName.setText("");
                selectedIndex = -1;
                updateCount();
            } else {
                Toast.makeText(MainActivity.this, "Chọn bài hát cần xóa!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Cập nhật số lượng bài hát
    private void updateCount() {
        tvCount.setText(songList.size() + " Bài hát");
    }

    // Lưu danh sách bài hát vào SharedPreferences
    private void saveSongs() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> songSet = new HashSet<>(songList);
        editor.putStringSet(KEY_SONGS, songSet);
        editor.apply();
    }

    // Tải danh sách bài hát từ SharedPreferences
    private Set<String> loadSongs() {
        return sharedPreferences.getStringSet(KEY_SONGS, new HashSet<>());
    }
}
