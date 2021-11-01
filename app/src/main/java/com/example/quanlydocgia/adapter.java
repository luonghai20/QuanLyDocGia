package com.example.quanlydocgia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends BaseAdapter {
    Context context;
    ArrayList<DocGia> docGia;

    public adapter(Context context, ArrayList<DocGia> docGia) {
        this.context = context;
        this.docGia = docGia;
    }

    @Override
    public int getCount() {
        return docGia.size();
    }

    @Override
    public Object getItem(int i) {
        return docGia.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.item_listview,viewGroup,false);

        ImageView image=view.findViewById(R.id.imgGioiTinh);
        TextView txtDocGia=view.findViewById(R.id.tvDocGia);
        CheckBox cbGender=view.findViewById(R.id.cbGioiTinh);
        
        image.setImageResource(docGia.get(i).getIdAnh());
        txtDocGia.setText(docGia.get(i).getMaTenDG());
        cbGender.setChecked(docGia.get(i).isChecked());

        cbGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                docGia.get(i).setChecked(cbGender.isChecked());
            }
        });
        return view;
    }


}
