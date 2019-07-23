package com.example.databasefirebase;

/**
 * Created by Burhan Infinity on 11/29/2017.
 */

public class ImageUploaded {

    public String name;
    public String uri;
    public String informetion;


    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
    public String getInformetion() {
        return informetion;
    }

    public ImageUploaded(String name, String uri,String informetion) {
        this.name = name;
        this.uri = uri;
        this.informetion=informetion;

    }

    public ImageUploaded(){}


    public String getName(String d) {

        return name;
    }
}
