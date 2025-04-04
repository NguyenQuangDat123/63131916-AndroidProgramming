package com.example.thigk2nguyenquangdat;

import android.app.Activity;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

public class ActivityAdapter extends BaseAdapter {

    Activity context;
    ArrayList<ActivityItem> list;

    public ActivityAdapter(Activity context, ArrayList<ActivityItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = context.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_item, null);

        ImageView img = view.findViewById(R.id.imgAvatar);
        TextView title = view.findViewById(R.id.txtTitle);
        TextView time = view.findViewById(R.id.txtTime);

        ActivityItem item = list.get(i);

        img.setImageResource(item.imageResId);
        title.setText(item.title);
        time.setText(item.time);

        return view;
    }
}
