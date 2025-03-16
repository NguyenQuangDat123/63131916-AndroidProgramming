package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChienCoAdapter extends RecyclerView.Adapter<ChienCoAdapter.ViewHolder> {
    ArrayList<ChienCo> list;
    Context context;

    public ChienCoAdapter(ArrayList<ChienCo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chien_co, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChienCo chienCo = list.get(position);
        holder.imageView.setImageResource(chienCo.getImage());
        holder.textView.setText(chienCo.getName());

        holder.itemView.setOnLongClickListener(v -> {
            list.remove(position);
            notifyItemRemoved(position);
            return true;
        });

        holder.itemView.setOnClickListener(v -> {
            DialogAddEdit dialog = new DialogAddEdit(context, list, this, position);
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
