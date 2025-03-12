package com.example.vd_customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private Context context;
    private List<Country> countryList;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textViewCountry = convertView.findViewById(R.id.textViewCountry);
        TextView textViewPopulation = convertView.findViewById(R.id.textViewPopulation);

        Country country = countryList.get(position);
        imageView.setImageResource(country.getImageResId());
        textViewCountry.setText(country.getName());
        textViewPopulation.setText("Population: " + country.getPopulation());

        return convertView;
    }
}
