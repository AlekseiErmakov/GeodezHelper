package com.example.geodezhelper.interfaces;

import com.example.geodezhelper.Pojo.Point;

import java.util.ArrayList;

public interface MyBaseLineData extends MyData{
    Point getPone();
    Point getPtwo();
    void setPone(Point point);
    void setPtwo(Point point);
    ArrayList<Double> getCoords();
}
