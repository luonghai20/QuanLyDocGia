package com.example.quanlydocgia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edMaDG,edTenDG;
    RadioButton nam,nu;
    Button del,add;
    ListView lvDocGia;
    ArrayList<DocGia> docGia0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMaDG=findViewById(R.id.edMaDG);
        edTenDG=findViewById(R.id.edTenDG);

        nam=findViewById(R.id.nam);
        nu=findViewById(R.id.nu);

        del=findViewById(R.id.btdelete);
        add=findViewById(R.id.btAdd);
        lvDocGia=findViewById(R.id.lvDocGia);

        docGia0 =new ArrayList<>();
        docGia0.add(new DocGia(R.drawable.icon_nam,"DG01 doc gia 1",false));
        docGia0.add(new DocGia(R.drawable.icon_nam,"DG02 doc gia 2",false));
        docGia0.add(new DocGia(R.drawable.icon_nu,"DG03 doc gia 3",false));
        docGia0.add(new DocGia(R.drawable.icon_nu,"DG04 doc gia 4",false));

        adapter adapter=new adapter(MainActivity.this,docGia0);
        lvDocGia.setAdapter(adapter);

        lvDocGia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                Bundle bundle=new Bundle();
                bundle.putInt("gioitinh",docGia0.get(i).getIdAnh());
                bundle.putString("thongtin",docGia0.get(i).getMaTenDG());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gt=0;
                if(nam.isChecked()) gt=R.drawable.icon_nam;
                else gt=R.drawable.icon_nu;

                if (edMaDG.getText().toString().isEmpty()){
                    edMaDG.setError("nhap ma doc gia");
                }
                if (edTenDG.getText().toString().isEmpty()){
                    edTenDG.setError("nhap ten doc gia");
                }
                if (edMaDG.getText().toString().isEmpty()==false && edTenDG.getText().toString().isEmpty()==false){
                    docGia0.add(new DocGia(gt,edMaDG.getText().toString()+" "+edTenDG.getText().toString(),false));
                }
                adapter.notifyDataSetChanged();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<docGia0.size();i++){
                    if (docGia0.get(i).isChecked()){
                        docGia0.remove(i);
                        i--;
                    }
                    adapter.notifyDataSetChanged();
                }

                Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_SHORT).show();
            }
        });


    }
}