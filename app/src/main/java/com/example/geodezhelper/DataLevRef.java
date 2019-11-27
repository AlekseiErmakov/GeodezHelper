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
        for (int i = 0;  i < 100; i++){
            NivPoint nivPoint = new NivPoint();
            nivPoint.setName("Rp№ "+ i);
            nivPoint.setHeight(i+30.000);
            levrefs.add(nivPoint);
        }

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
    public NivPoint getLevRef(UUID id){
        for (NivPoint nivPoint : levrefs){
            if (nivPoint.getId().equals(id)){
                return nivPoint;
            }
        }
        return null;
    }
}
