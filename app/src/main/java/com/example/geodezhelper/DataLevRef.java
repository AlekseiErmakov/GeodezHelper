package com.example.geodezhelper;

import android.content.Context;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataLevRef {
    private static DataLevRef dataLevRef;
    private List<NivPoint> levrefs;
    private DataLevRef(Context context){
        levrefs = new ArrayList<>();
    }
    public static DataLevRef getInstance(Context context){
        if(dataLevRef == null){
            dataLevRef = new DataLevRef(context);
        }
        return dataLevRef;
    }
    public List<NivPoint> getDataLevRef(){
        return levrefs;
    }
    public void addLevRef(){
        levrefs.add(new NivPoint());
    }
    public void removeLevRef(){
        levrefs.remove(levrefs.size()-1);
    }
    public NivPoint getLastAddLevRef(){
        return levrefs.get(levrefs.size()-1);
    }
    public NivPoint getLevRef(UUID id){
        for (NivPoint nivPoint : levrefs){
            if (nivPoint.getId().equals(id)){
                return nivPoint;
            }
        }
        return null;
    }
}
