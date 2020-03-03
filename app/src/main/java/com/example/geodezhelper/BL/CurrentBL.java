package com.example.geodezhelper.BL;

import com.example.geodezhelper.Bean.Point;
import com.example.geodezhelper.interfaces.forbeans.MyBaseLineData;

import java.util.ArrayList;
import java.util.UUID;

public class CurrentBL implements MyBaseLineData {
    Point pOne;
    Point pTwo;
    String name;
    private static CurrentBL currentBL;

    private CurrentBL(){
        name = "Выберите Базовую Линию";
    }
    public static CurrentBL getInstance(){
        if (currentBL == null){
            currentBL = new CurrentBL();
        }
        return currentBL;
    }
    @Override
    public Point getPone() {
        return pOne;
    }

    @Override
    public Point getPtwo() {
        return pTwo;
    }

    @Override
    public void setPone(Point point) {
           this.pOne = point;
    }

    @Override
    public void setPtwo(Point point) {
        this.pTwo = point;
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
