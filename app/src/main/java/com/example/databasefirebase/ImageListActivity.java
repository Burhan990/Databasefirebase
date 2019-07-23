package com.example.databasefirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ImageListActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseRef;
    //private DatabaseReference mDatabaseRef2;
   private List<ImageUploaded>imgList;
   private ImageListAdapter adapter;
   // private ImageListAdapter addd;
    //private int login=1,login2=2;

 // private TextView tt1;
    //private String x;

    private ListView lv;
    private ProgressDialog progressDialog;
  // private  String d = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);


        final Intent i = getIntent();
        int a1 = i.getExtras().getInt("login");
        int a2 = i.getExtras().getInt("login2");

        imgList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.Listviewimage);


        //tt1 = (TextView) findViewById(R.id.tt1);
        //tt2=(TextView)findViewById(R.id.tvImageinformetion);


        if (a1 == 1) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please wait for loading Images......");
            progressDialog.show();

            mDatabaseRef = FirebaseDatabase.getInstance().getReference(MainActivity.FB_DATABASE_PATH);

            mDatabaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {


                        ImageUploaded img = snapshot.getValue(ImageUploaded.class);
                         //ImageUploaded a=snapshot.getValue(ImageUploaded.class);

                        // x=a.getName(d);



                        imgList.add(img);

                    }
                    adapter = new ImageListAdapter(ImageListActivity.this, R.layout.image_item, imgList);
                    lv.setAdapter(adapter);

                    progressDialog.dismiss();

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    progressDialog.dismiss();

                }
            });

        }else if (a2==2){


            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please wait for loading Images......");
            progressDialog.show();

            mDatabaseRef = FirebaseDatabase.getInstance().getReference(MainActivity.FB_DATABASE2_PATH);

            mDatabaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {


                        ImageUploaded img = snapshot.getValue(ImageUploaded.class);
                        // ImageUploaded a=snapshot.getValue(ImageUploaded.class);

                        // x=a.getName(d);
                        //tt1.setText(x);


                        imgList.add(img);

                    }
                    adapter = new ImageListAdapter(ImageListActivity.this, R.layout.image_item, imgList);
                    lv.setAdapter(adapter);

                    progressDialog.dismiss();

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    progressDialog.dismiss();

                }
            });

        }
        }

    }



