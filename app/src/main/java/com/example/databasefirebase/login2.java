package com.example.databasefirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login2 extends AppCompatActivity {

    private EditText ed1,ed2;
    private Button bn1;
    //TextView tt1,tt2;
    String lat,lon;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseRef;
    private ProgressDialog progressDialog;
    private  String d = null;
    private String x;
    TextView tt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        ed1=(EditText)findViewById(R.id.edit1);
        ed2=(EditText)findViewById(R.id.edit2);
        tt1=(TextView)findViewById(R.id.latb);
        //tt2=(TextView)findViewById(R.id.t2);

        bn1=(Button)findViewById(R.id.login);



        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait for loading Images......");
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(MainActivity.FB_DATABASE_PATH);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {


                    ImageUploaded img = snapshot.getValue(ImageUploaded.class);
                    ImageUploaded a=snapshot.getValue(ImageUploaded.class);

                    x=a.getName(d);

                    tt1.setText(x);




                }

                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });


        mAuth=FirebaseAuth.getInstance();

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();

            }
        });

    }

    public void startSignIn(){

        String email=ed1.getText().toString();
        String password=ed2.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(login2.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();

        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {


                    if (!task.isSuccessful()){
                        Toast.makeText(login2.this, "E-mail or Password is wrong!\nTry Again!", Toast.LENGTH_SHORT).show();
                    }else if (task.isSuccessful()){
                        Intent i=new Intent(login2.this,MainActivity.class);
                        i.putExtra("login2",2);
                        startActivity(i);
                    }

                }
            });
        }



    }

    public void btnshow_image_click(View view) {

       Intent i=new Intent(login2.this,fourthpage.class);
       i.putExtra("login2",2);
       startActivity(i);
    }

    public void btnshow_mapview_click(View view) {
    }



    public void btnshowmap_click(View view) {
    }
}
