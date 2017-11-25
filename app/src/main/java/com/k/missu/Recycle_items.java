package com.k.missu;

/**
 * Created by kjh on 2017. 11. 24..
 */

public class Recycle_items  {
    private int image;
    private String title;

    public int getImage(){
        return image;
    }
    public String getTitle(){
        return title;
    }
    public Recycle_items(int im, String str){
        this.image = im;
        this.title = str;
    }
}
