package com.salajim.musab.demo.models;

/**
 * Created by Musab on 11/22/2017.
 */
public class Demo {
    private String urlToImage;
    private  String title;

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
