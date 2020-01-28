package com.example.geodezhelper.LR;



import com.example.geodezhelper.interfaces.forbeans.MyNivData;

import java.util.UUID;

public class CurrentLR implements MyNivData {
    String name;
    Double height;
    private static CurrentLR currentLR;
    private CurrentLR(){

    }
    public static CurrentLR getInstance(){
        if (currentLR == null){
            currentLR = new CurrentLR();
        }
        return currentLR;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    @Override
    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
