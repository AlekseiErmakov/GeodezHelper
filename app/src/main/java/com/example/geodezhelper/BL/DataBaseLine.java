package com.example.geodezhelper.BL;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataBaseLine {
    private static DataBaseLine dataBaseLine;
    private List<Baseline> baselines;
    private UUID currentID;
    private DataBaseLine(Context context){
        baselines = new ArrayList<>();

    }
    public static DataBaseLine getInstance(Context context){
        if (dataBaseLine == null){
            dataBaseLine = new DataBaseLine(context);
        }
        return dataBaseLine;
    }

    public List<Baseline> getBaselines() {
        return baselines;
    }
    public Baseline getBaseline(UUID uuid){
        for (Baseline baseline : baselines){
            if (baseline.getUuid().equals(uuid)){
                return baseline;
            }
        }
        return null;
    }
    public void setCurrentID(UUID currentID){
        this.currentID = currentID;
    }
    public UUID getCurrentID(){
        return currentID;
    }
}
