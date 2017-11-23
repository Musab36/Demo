package com.salajim.musab.demo.models;

import org.parceler.Parcel;

/**
 * Created by Musab on 11/22/2017.
 */
@Parcel
public class Demo {
    String urlToImage;
    String title;

    public Demo() { }

    public Demo(String urlToImage, String title) {
        this.urlToImage = urlToImage;
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getTitle() {
        return title;
    }
}
