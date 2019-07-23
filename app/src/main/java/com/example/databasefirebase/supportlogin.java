package com.example.databasefirebase;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class supportlogin extends AppCompatActivity {
    TextView tt1,tt2;
    String lat,lon;
    String fileName3="file3.txt";
    String fileName4="file4.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supportlogin);

        tt1=(TextView)findViewById(R.id.t1);
        tt2=(TextView)findViewById(R.id.t2);



        //savefile1(fileName3,lat);
       // savefile2(fileName4,lon);

        //tt1.setText(readfile1(fileName3));
       // tt2.setText(readfile1(fileName4));
    }


    public void btnshow_mapview_click(View view) {

        //tt1.setText(lat);
        //tt2.setText(lon);
        //tt1.setText(readfile1(fileName3));
        //tt2.setText(readfile1(fileName4));

        Intent intent=getIntent();
        lat=intent.getExtras().getString("b1");
        lon=intent.getExtras().getString("b2");

       // double lat5=Double.parseDouble(lat.getText().toString());
        //double lon5=Double.parseDouble(tt2.getText().toString());


        Intent i=new Intent(supportlogin.this,burhanvaiMaps.class);
        i.putExtra("view1",lat);
        i.putExtra("view2",lon);
        i.putExtra("ccc",22);
        i.putExtra("ddd",1);

        startActivity(i);
    }

    public void savefile1(String file,String text){

        try {

            FileOutputStream fos=openFileOutput(file, Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
            Toast.makeText(supportlogin.this,"file saved.",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(supportlogin.this,"file save eror!!!..",Toast.LENGTH_SHORT).show();
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
            Toast.makeText(supportlogin.this,"file reading error.....",Toast.LENGTH_SHORT).show();
        }

        return text;
    }
    public void savefile2(String file2,String text2){

        try {

            FileOutputStream fos=openFileOutput(file2, Context.MODE_PRIVATE);
            fos.write(text2.getBytes());
            fos.close();
            Toast.makeText(supportlogin.this,"file saved.",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(supportlogin.this,"file save eror!!!..",Toast.LENGTH_SHORT).show();
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
            Toast.makeText(supportlogin.this,"file reading error.....",Toast.LENGTH_SHORT).show();
        }

        return text2;
    }
}
