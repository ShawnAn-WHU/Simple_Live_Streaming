package com.example.livestreaming;

public class Gift {
    private final String name;
    private final int imageButtonSrc;
    public Gift(String name, int imageButtonSrc){
        this.name = name;
        this.imageButtonSrc = imageButtonSrc;
    }
    public String getName(){
        return name;
    }
    public int getSrc(){
        return imageButtonSrc;
    }
}
