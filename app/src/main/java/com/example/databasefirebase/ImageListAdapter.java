package com.example.databasefirebase;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Burhan Infinity on 11/29/2017.
 */

public class ImageListAdapter extends ArrayAdapter <ImageUploaded>{

    private Activity context;
    private int resource;
    private List<ImageUploaded> listImage;
    String a;


    public ImageListAdapter(@NonNull Activity context, int resource, @NonNull List<ImageUploaded> objects) {
        super(context, resource, objects);

        this.context=context;
        this.resource=resource;
        listImage=objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= context.getLayoutInflater();

        View v=inflater.inflate(resource,null);
        TextView tv1=(TextView)v.findViewById(R.id.tvImagename);
        TextView tv2=(TextView)v.findViewById(R.id.tvImageinformetion);

        ImageView img=(ImageView)v.findViewById(R.id.imgview);

         //String z = null;

        tv1.setText(listImage.get(position).getName());
        tv2.setText(listImage.get(position).getInformetion());

       // a=tv1.getText().toString();
        Glide.with(context).load(listImage.get(position).getUri()).into(img);

        return v;

    }
}
