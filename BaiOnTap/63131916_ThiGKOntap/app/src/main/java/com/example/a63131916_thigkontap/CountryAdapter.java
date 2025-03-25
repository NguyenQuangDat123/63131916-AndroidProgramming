package com.example.a63131916_thigkontap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private Context context;
    private List<Country> countryList;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);

        // Kiểm tra nếu txtCountryName hoặc imgFlag bị null
        if (holder.txtCountryName == null || holder.imgFlag == null) {
            throw new RuntimeException("Lỗi: Không tìm thấy txtCountryName hoặc imgFlag trong item_country.xml");
        }

        holder.txtCountryName.setText(country.getName());
        holder.imgFlag.setImageResource(country.getFlag());

        // Xử lý sự kiện click để mở ItemActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CountryAdapter.class);
            intent.putExtra("countryName", country.getName());
            intent.putExtra("countryFlag", country.getFlag());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView txtCountryName;
        ImageView imgFlag;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            // Đảm bảo rằng ViewHolder lấy đúng ID từ item_country.xml
            txtCountryName = itemView.findViewById(R.id.txtCountryName);
            imgFlag = itemView.findViewById(R.id.imgFlag);

            // Kiểm tra nếu txtCountryName hoặc imgFlag bị null
            if (txtCountryName == null || imgFlag == null) {
                throw new RuntimeException("Lỗi: Không tìm thấy txtCountryName hoặc imgFlag trong item_country.xml");
            }
        }
    }
}
