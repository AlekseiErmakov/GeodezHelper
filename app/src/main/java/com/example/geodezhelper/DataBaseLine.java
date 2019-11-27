package com.example.geodezhelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataBaseLine {
    private static DataBaseLine dataBaseLine;
    private List<Baseline> baselines;
    private DataBaseLine(Context context){
        baselines = new ArrayList<>();
        Baseline first = new Baseline();
        first.setName("Третий тупиковый тоннель");
        baselines.add(first);
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
}
