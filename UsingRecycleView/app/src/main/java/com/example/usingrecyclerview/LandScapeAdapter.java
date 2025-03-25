package com.example.usingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.LandScapeViewHolder> {

    Context context;

    ArrayList<LandScape> datas;

    public LandScapeAdapter(Context _context, ArrayList<LandScape> _datas) {
        this.context = _context;
        this.datas = _datas;
    }

    @NonNull
    @Override
    public LandScapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewItem = layoutInflater.inflate(R.layout.item_land, parent, false);
        LandScapeViewHolder viewHolder = new LandScapeViewHolder(viewItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LandScapeViewHolder holder, int position) {

        LandScape landScape = datas.get(position);



        holder.landscapeCaption.setText(landScape.getLandscapeName());

        String packageName = holder.itemView.getContext().getPackageName();

        String nameFile = landScape.getLandscapeImage();
        int imageID = holder.itemView.getResources().getIdentifier(nameFile, "mipmap", packageName);
        holder.landscapeImage.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    final class LandScapeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView landscapeCaption;
        ImageView landscapeImage;

        public LandScapeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            landscapeImage = itemView.findViewById(R.id.ivLandScape);
            landscapeCaption = itemView.findViewById(R.id.tvCaption);
        }

        @Override
        public void onClick(View v) {
            //Code ở đây
            int clickedPosition = getAdapterPosition();

            LandScape landScape = datas.get(clickedPosition);

            Toast.makeText(v.getContext(), "Bạn đã lựa chọn: " + landScape.getLandscapeName(), Toast.LENGTH_SHORT).show();
        }
    }
}
