package com.example.geodezhelper.BL;

import com.example.geodezhelper.Pojo.Point;

import java.util.UUID;

public class Baseline {
    private UUID uuid;
    private String name;
    private Point pOne;
    private Point pTwo;
    public Baseline(){
        uuid = UUID.randomUUID();
        pOne = new Point();
        pTwo = new Point();
    }
    public Baseline(String name, Point pOne, Point pTwo){
        uuid = UUID.randomUUID();
        this.pOne = pOne;
        this.pTwo = pTwo;
        this.name = name;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        if (name!=null && !name.equals("")) {
            this.name = name;
        }
    }

    public void setpOne(Point pOne) {
        if (pOne!=null) {
            this.pOne = pOne;
        }
    }

    public void setpTwo(Point pTwo) {
        if (pTwo!=null){
            this.pTwo = pTwo;
        }

    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Point getpOne() {
        return pOne;
    }

    public Point getpTwo() {
        return pTwo;
    }
}
