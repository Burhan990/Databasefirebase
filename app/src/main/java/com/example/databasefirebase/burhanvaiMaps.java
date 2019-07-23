package com.example.databasefirebase;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class burhanvaiMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private double lat3, lon3,lat5,lon5;
    String lat1, lon1,latooo1,lonooo1;
    int c,d=0,t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burhanvai_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
       c = intent.getExtras().getInt("ccc");

       t = intent.getExtras().getInt("bur2");

       d=intent.getExtras().getInt("ddd");


        if (t==11) {

            latooo1 = intent.getExtras().getString("bur");
            lonooo1 = intent.getExtras().getString("bur1");
            double lateu = Double.parseDouble(latooo1);
            double loneu = Double.parseDouble(lonooo1);
            lat3=lateu;
            lon3=loneu;
        }else if (c==22){

            lat1 = intent.getExtras().getString("view1");
            lon1 = intent.getExtras().getString("view2");


            double late=Double.parseDouble(lat1);
            double lone=Double.parseDouble(lon1);

            lat5=late;
            lon5=lone;

        }

    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {


        if (d == 0) {

            mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(lat3, lon3);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        } else if (d == 1) {

            mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng syidney = new LatLng(lat5, lon5);
            mMap.addMarker(new MarkerOptions().position(syidney).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(syidney));

        }
    }
}
