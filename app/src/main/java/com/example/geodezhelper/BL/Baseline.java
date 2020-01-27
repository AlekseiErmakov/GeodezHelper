package com.example.geodezhelper.BL;

import com.example.geodezhelper.Pojo.Point;
import com.example.geodezhelper.interfaces.forbeans.MyBaseLineData;

import java.util.ArrayList;
import java.util.UUID;

public class Baseline implements MyBaseLineData {
    private UUID uuid;
    private String name;
    private Point pOne;
    private Point pTwo;
    private ArrayList<Double> coords;
    public Baseline(){
        uuid = UUID.randomUUID();
        pOne = new Point();
        pTwo = new Point();
        coords = new ArrayList<>();
    }
    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        if (name!=null && !name.equals("")) {
            this.name = name;
        }
    }

    public void setPone(Point pOne) {
        if (pOne!=null) {
            this.pOne = pOne;
        }
    }
    public void setPtwo(Point pTwo) {
        if (pTwo!=null){
            this.pTwo = pTwo;
        }
    }
    @Override
    public ArrayList<Double> getCoords() {
        return coords;
    }

    public UUID getId() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Point getPone() {
        return pOne;
    }

    public Point getPtwo() {
        return pTwo;
    }
}
