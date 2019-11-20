package com.example.geodezhelper;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class TabFile extends TotalStationFile{
    private ArrayList<String> result;
    private ArrayList<Point> points;
    private int type;

    public TabFile(ArrayList<Point>points,int type){
        this.points = points;
        this.type = type;
    }
    public void makeViewFile(){
        switch (type){
            case (1):
                for (Point p : points){
                    result.add(p.getTxtPoint(true));
                }
                break;
            case (2):
                for (Point p : points)
                    result.add(p.getTxtPoint(false));
        }
    }
    public ArrayList<String> getResult() {
        return result;
    }
}
