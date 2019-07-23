package com.example.databasefirebase;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

public class fourthpage extends AppCompatActivity {



    CardView showdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthpage);

        final Intent i = getIntent();
        int a1 = i.getExtras().getInt("login");
        int a2 = i.getExtras().getInt("login2");

        showdatabase=(CardView)findViewById(R.id.showdatabase);

        if (a1==1){

            showdatabase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent=new Intent(fourthpage.this,ImageListActivity.class);
                    intent.putExtra("login",1);
                    startActivity(intent);

                }
            });

        }else if (a2==2){

            showdatabase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(fourthpage.this,ImageListActivity.class);
                    intent.putExtra("login2",2);
                    startActivity(intent);

                }
            });



        }




    }
}
