package com.example.geodezhelper.round;

import android.content.Context;

import com.example.geodezhelper.interfaces.forData.DataConteiner;
import com.example.geodezhelper.interfaces.forData.MyDataHolder;
import com.example.geodezhelper.interfaces.forbeans.MyData;

import java.util.ArrayList;

public class DataPointR extends DataConteiner {
    private static MyDataHolder dataHolder;
    private static ArrayList<MyData> points;
    private DataPointR(Context context, ArrayList<MyData> points){
        super(context,points);
    }
    public static MyDataHolder getInstance(Context context){
        if (dataHolder == null){
            points = new ArrayList<>();
            dataHolder = new DataPointR(context,points);
        }
        return dataHolder;
    }

    @Override
    public void addItem() {
        points.add(new RoundPoint());
    }
}
