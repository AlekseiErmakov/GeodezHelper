package com.example.geodezhelper;

import com.example.geodezhelper.Bean.NivPoint;
import com.example.geodezhelper.Bean.NivStation;

import java.util.ArrayList;

public class NivCompleks {
    private static NivCompleks nivCompleks;
    private NivPoint levRefStart;
    private NivPoint getLevRefEnd;
    private ArrayList<NivStation> nivStations;
    private NivCompleks(){
        nivStations = new ArrayList<>();
    }
     public static NivCompleks getInstance() {
        if(nivCompleks==null){
            nivCompleks = new NivCompleks();
        }
         return nivCompleks;
     }
     public void addNivStation(){
        nivStations.add(new NivStation());
     }
}
