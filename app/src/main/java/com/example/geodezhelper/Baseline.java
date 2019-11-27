package com.example.geodezhelper;

import java.util.UUID;

public class Baseline {
    private UUID uuid;
    private String name;
    Point pOne;
    Point pTwo;
    public Baseline(){
        uuid = UUID.randomUUID();
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
        this.name = name;
    }

    public void setpOne(Point pOne) {
        this.pOne = pOne;
    }

    public void setpTwo(Point pTwo) {
        this.pTwo = pTwo;
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
