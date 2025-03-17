package com.example.myfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentTwo extends Fragment {
    private TextView tvStatus;

    public FragmentTwo() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Button btnGetText = view.findViewById(R.id.btnGetText);
        tvStatus = view.findViewById(R.id.tvStatus);

        btnGetText.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentOne fragmentOne = (FragmentOne) fragmentManager.findFragmentById(R.id.fragmentContainer1);

            if (fragmentOne != null) {
                TextView tvFragmentOne = fragmentOne.getView().findViewById(R.id.tvFragmentOne);
                String text = tvFragmentOne.getText().toString();
                tvStatus.setText("Fragment #1 says: " + text);
            }
        });

        return view;
    }
}
