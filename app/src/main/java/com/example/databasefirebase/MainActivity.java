package com.example.databasefirebase;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private StorageReference mStorageRef;

    private DatabaseReference mdatabaseref;
    private DatabaseReference mdatabaseref2;

    private ImageView imageView;
    private EditText txtImageName;
    private Uri imguri;
    private EditText txtImageinformetion;
    Button upload1,logout2;


    private EditText latitude,longitude;

    public static final String FB_STORAGE_PATH="image/";
    public static final String FB_DATABASE_PATH="image";
    public static final String FB_DATABASE2_PATH="imageSecond";
    public static final int REQUEST_CODE=1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent i=getIntent();
        int a1=i.getExtras().getInt("login");
        int a2=i.getExtras().getInt("login2");
        upload1=(Button)findViewById(R.id.upload);
        logout2=(Button)findViewById(R.id.logout);


        mStorageRef= FirebaseStorage.getInstance().getReference();
        mdatabaseref= FirebaseDatabase.getInstance().getReference(FB_DATABASE_PATH);
        mdatabaseref2= FirebaseDatabase.getInstance().getReference(FB_DATABASE2_PATH);

        imageView=(ImageView)findViewById(R.id.image_view);
        txtImageName=(EditText)findViewById(R.id.textImage_name);
        txtImageinformetion=(EditText)findViewById(R.id.textImage_informetion);
        latitude=(EditText)findViewById(R.id.latitude);
       longitude=(EditText)findViewById(R.id.longitude);




        if (a1 == 1) {
            upload1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (imguri != null) {
                        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
                        dialog.setTitle("Image Uploading");
                        dialog.show();


                        final StorageReference ref = mStorageRef.child(FB_STORAGE_PATH + System.currentTimeMillis() + "." + getImgageExt(imguri));


                        ref.putFile(imguri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();

                                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {

                                        ImageUploaded imageUploaded = new ImageUploaded(txtImageName.getText().toString(),uri.toString(), txtImageinformetion.getText().toString());

                                        String UploadId = mdatabaseref.push().getKey();
                                        mdatabaseref.child(UploadId).setValue(imageUploaded);


                                    }
                                });



                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                                double progress = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                                dialog.setMessage("Uploaded" + (int) progress + "");

                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "Please select Image", Toast.LENGTH_SHORT).show();
                    }

                }


            });

        }
        else if(a2==2){



upload1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if(imguri!=null){
            final ProgressDialog dialog=new ProgressDialog(MainActivity.this);
            dialog.setTitle("Image Uploading");
            dialog.show();


            final StorageReference ref=mStorageRef.child(FB_STORAGE_PATH+System.currentTimeMillis()+"."+getImgageExt(imguri));


            ref.putFile(imguri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Image Uploaded",Toast.LENGTH_SHORT).show();

                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            ImageUploaded imageUploaded=new ImageUploaded(txtImageName.getText().toString(),uri.toString(),txtImageinformetion.getText().toString());
                            String UploadId=mdatabaseref2.push().getKey();
                            mdatabaseref2.child(UploadId).setValue(imageUploaded);

                        }
                    });





                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                    double progress=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                    dialog.setMessage("Uploaded"+(int)progress+"");

                }
            });
        }else{
            Toast.makeText(getApplicationContext(),"Please select Image",Toast.LENGTH_SHORT).show();
        }

    }


});
        }


        if (a1==1) {
            logout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent i = new Intent(MainActivity.this, logInActivity.class);
                    startActivity(i);

                }
            });
        }else if (a2==2) {

            logout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ii = new Intent(MainActivity.this,login2.class);
                    startActivity(ii);

                }
            });


        }
    }

    public void btnbrowese_click(View view) {

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select Image"),REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK && data!=null&& data.getData()!=null){
            imguri=data.getData();

            try{
                Bitmap bm= MediaStore.Images.Media.getBitmap(getContentResolver(),imguri);
                imageView.setImageBitmap(bm);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getImgageExt(Uri uri){

        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));

    }

   // public void btnupload_click(View view) {



    //}

    //public void logout(View view) {

        //if ()


   // }
}

