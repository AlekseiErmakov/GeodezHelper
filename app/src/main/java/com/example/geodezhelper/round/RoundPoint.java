package com.example.geodezhelper.round;

import com.example.geodezhelper.interfaces.forbeans.MySimplePoint;

import java.util.UUID;

public class RoundPoint implements MySimplePoint {
    Double x;
    Double y;
    String name;
    UUID id;
    public RoundPoint(){
        id = UUID.randomUUID();
    }
    @Override
    public Double getX() {
        return x;
    }

    @Override
    public Double getY() {
        return y;
    }

    @Override
    public void setX(Double x) {
        this.x = x;
    }

    @Override
    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public UUID getId() {
        return id;
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
