package com.example.databasefirebase;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.Snapshot;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class logInActivity extends AppCompatActivity {



    private ImageListAdapter adapter;

    private EditText ed1,ed2;
    private Button bn1;
    //TextView tt1,tt2;
    String lat,lon;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //map a;

 private int a=1;

 ImageUploaded mm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);




        ed1=(EditText)findViewById(R.id.edit1);
        ed2=(EditText)findViewById(R.id.edit2);
        //tt1=(TextView)findViewById(R.id.t1);
        //tt2=(TextView)findViewById(R.id.t2);

        bn1=(Button)findViewById(R.id.login);


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
            Toast.makeText(logInActivity.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();

        }else{
            ;mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {


                    if (!task.isSuccessful()){
                        Toast.makeText(logInActivity.this, "E-mail or Password is wrong!\nTry Again!", Toast.LENGTH_SHORT).show();
                    }else if (task.isSuccessful()){
                        Intent i=new Intent(logInActivity.this,MainActivity.class);
                        i.putExtra("login",a);
                        startActivity(i);
                    }

                }
            });
        }



    }




    public void btnshow_image_click(View view) {

        Intent i=new Intent(logInActivity.this,fourthpage.class);
        i.putExtra("login",1);
        startActivity(i);
    }
    public void btnshow_map_click(View view) {
        Intent i=new Intent(logInActivity.this,map.class);
        startActivity(i);
    }

    public void btnshow_mapview_click(View view) {

        //tt1.setText(lat);
        //tt2.setText(lon);
        ///tt1.setText(readfile1(fileName3));
       // tt2.setText(readfile1(fileName4));

        //double lat5=Double.parseDouble(tt1.getText().toString());
        //double lon5=Double.parseDouble(tt2.getText().toString());


        Intent i=new Intent(logInActivity.this,supportlogin.class);
        startActivity(i);
    }

    public void newupload(View view) {

        Intent i=new Intent(logInActivity.this,login2.class);
        startActivity(i);
    }
}
