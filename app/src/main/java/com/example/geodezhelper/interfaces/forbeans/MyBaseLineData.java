package com.example.geodezhelper.interfaces.forbeans;

import com.example.geodezhelper.Bean.Point;

import java.util.ArrayList;

public interface MyBaseLineData extends MyData {
    Point getPone();
    Point getPtwo();
    void setPone(Point point);
    void setPtwo(Point point);

}
