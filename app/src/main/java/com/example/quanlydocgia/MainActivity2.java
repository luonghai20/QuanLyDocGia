package com.example.quanlydocgia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView img2;
    TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img2=findViewById(R.id.img2);
        txt2=findViewById(R.id.txtDocGia2);

        Bundle bundle=getIntent().getExtras();
        img2.setImageResource(bundle.getInt("gioitinh",0));
        txt2.setText(bundle.getString("thongtin","loikey"));

    }
}