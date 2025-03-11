package com.example.listviewbaihat_caitien2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongAdapter extends ArrayAdapter<String> {
    public SongAdapter(Context context, List<String> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_song, parent, false);
        }

        // Lấy bài hát hiện tại
        String song = getItem(position);

        // Ánh xạ TextView và ImageView
        TextView tvSongName = convertView.findViewById(R.id.tvSongName);
        ImageView imgMusicNote = convertView.findViewById(R.id.imgMusicNote);

        // Gán dữ liệu
        tvSongName.setText(song);

        return convertView;
    }
}
