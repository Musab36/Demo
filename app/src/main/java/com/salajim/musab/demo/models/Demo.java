package com.salajim.musab.demo.models;

import org.parceler.Parcel;

/**
 * Created by Musab on 11/22/2017.
 */
@Parcel
public class Demo {
    String urlToImage;
    String title;
    String description;

    public Demo() { }

    public Demo(String urlToImage, String title, String description) {
        this.urlToImage = urlToImage;
        this.title = title;
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
