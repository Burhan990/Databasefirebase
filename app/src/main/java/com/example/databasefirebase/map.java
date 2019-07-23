package com.example.databasefirebase;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class map extends AppCompatActivity {

    private EditText e1,e2;
    private TextView tt1,tt2;
    private Button b,k;
    String fileName1="file.txt";
    String fileName2="file2.txt";
    double latt,lonn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);



        e1=(EditText)findViewById(R.id.latitude);
        e2=(EditText)findViewById(R.id.longitude);
        tt1=(TextView)findViewById(R.id.t1);
        //tt1.setText(readfile1(fileName1));
        tt2=(TextView)findViewById(R.id.t2);
       // tt2.setText(readfile2(fileName2));

        b=(Button)findViewById(R.id.dd);
        k=(Button)findViewById(R.id.q);

        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //savefile1(fileName1,e1.getText().toString());
               // savefile2(fileName2,e2.getText().toString());

                String s=e1.getText().toString();
                String ss=e2.getText().toString();

                tt1.setText(s);
                tt2.setText(ss);
                //tt1.setText(readfile1(fileName1));
               // tt2.setText(readfile2(fileName2));

            }
        });


    }

    public void savefile1(String file,String text){

        try {

            FileOutputStream fos=openFileOutput(file, Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
            Toast.makeText(map.this,"file saved.",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(map.this,"file save eror!!!..",Toast.LENGTH_SHORT).show();
        }
    }

    public String readfile1(String file){
        String text="";

        try {
            FileInputStream fis=openFileInput(file);
            int size=fis.available();
            byte[] buffer=new  byte[size];
            fis.read(buffer);
            fis.close();
            text=new String(buffer);

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(map.this,"file reading error.....",Toast.LENGTH_SHORT).show();
        }

        return text;
    }
    public void savefile2(String file2,String text2){

        try {

            FileOutputStream fos=openFileOutput(file2, Context.MODE_PRIVATE);
            fos.write(text2.getBytes());
            fos.close();
            Toast.makeText(map.this,"file saved.",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(map.this,"file save eror!!!..",Toast.LENGTH_SHORT).show();
        }
    }

    public String readfile2(String file2){
        String text2="";

        try {
            FileInputStream fis=openFileInput(file2);
            int size=fis.available();
            byte[] buffer=new  byte[size];
            fis.read(buffer);
            fis.close();
            text2=new String(buffer);

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(map.this,"file reading error.....",Toast.LENGTH_SHORT).show();
        }

        return text2;
    }


    public void savemap(View view) {



        //double latt=Double.parseDouble(tt1.getText().toString());
       // double lonn=Double.parseDouble(tt2.getText().toString());

        String latt=tt1.getText().toString();
        String lonn=tt2.getText().toString();
        int c=11;

        Intent i=new Intent(map.this,burhanvaiMaps.class);
        i.putExtra("bur",latt);
        i.putExtra("bur1",lonn);
        i.putExtra("bur2",c);
        startActivity(i);
    }

    public void hhh(View view) {


        String ff=tt1.getText().toString();
        String dd=tt2.getText().toString();


        Intent i=new Intent(map.this,supportlogin.class);
        i.putExtra("b1",ff);
        i.putExtra("b2",dd);
        startActivity(i);
    }


}
