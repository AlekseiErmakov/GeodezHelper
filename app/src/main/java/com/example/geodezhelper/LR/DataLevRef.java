package com.example.geodezhelper.LR;

import android.content.Context;


import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.interfaces.MyData;
import com.example.geodezhelper.interfaces.MyDataHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataLevRef implements MyDataHolder {
    private static DataLevRef dataLevRef;
    private List<MyData> myDatas;
    private UUID currentID;
    private DataLevRef(Context context){
        myDatas = new ArrayList<>();
    }
    public static DataLevRef getInstance(Context context){
        if(dataLevRef == null){
            dataLevRef = new DataLevRef(context);
        }
        return dataLevRef;
    }
    public List<MyData> getList(){
        return myDatas;
    }
    public void addItem(){
        myDatas.add(new NivPoint());
    }
    public void removeItem(){
        myDatas.remove(myDatas.size()-1);
    }
    public MyData getLastItem(){
        return myDatas.get(myDatas.size()-1);
    }
    public MyData getItem(UUID id){
        for (MyData myData : myDatas){
            if (myData.getId().equals(id)){
                return myData;
            }
        }
        return null;
    }
    public void setCurrentId(UUID currentID){
        this.currentID = currentID;
    }
    public MyData getCurItem(){
        for (MyData myData : myDatas){
            if (myData.getId().equals(currentID)){
                return myData;
            }
        }
        return null;
    }
}
