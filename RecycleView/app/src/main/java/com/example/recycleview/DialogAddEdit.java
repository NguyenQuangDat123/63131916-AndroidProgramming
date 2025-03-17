package com.example.recycleview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class DialogAddEdit extends Dialog {
    ArrayList<ChienCo> list;
    ChienCoAdapter adapter;
    int position;
    EditText edtName;
    Button btnSave;

    public DialogAddEdit(Context context, ArrayList<ChienCo> list, ChienCoAdapter adapter, int position) {
        super(context);
        this.list = list;
        this.adapter = adapter;
        this.position = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_edit);

        edtName = findViewById(R.id.edtName);
        btnSave = findViewById(R.id.btnSave);

        if (position != -1) {
            edtName.setText(list.get(position).getName());
        }

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            if (position == -1) {
                list.add(new ChienCo(R.drawable.tiemkich, name));
            } else {
                list.get(position).setName(name);
            }
            adapter.notifyDataSetChanged();
            dismiss();
        });
    }
}
