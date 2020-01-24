package com.example.geodezhelper.interfaces;

import android.content.Context;

import com.example.geodezhelper.Pojo.NivPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataLevRefExt implements MyDataHolder {
    private static DataLevRefExt dataLevRef;
    private List<MyData> myDataList;
    private UUID currentID;
    private DataLevRefExt(Context context){
        myDataList = new ArrayList<>();
    }
    public static DataLevRefExt getInstance(Context context){
        if(dataLevRef == null){
            dataLevRef = new DataLevRefExt(context);
        }
        return dataLevRef;
    }
    @Override
    public void removeItem() {
        myDataList.remove(myDataList.size()-1);
    }

    @Override
    public MyData getItem(UUID id) {
        MyData myData = null;
        for (MyData myListData : myDataList){
            if (id.equals(myListData.getId())){
                myData = myListData;
            }
        }
        return myData;
    }

    @Override
    public MyData getLastItem() {
        MyData myData = null;
        int len = myDataList.size();
        if(len > 0){
            myData = myDataList.get(len-1);
        }
        return myData;
    }

    @Override
    public MyData getCurItem() {
        MyData myCurData = null;
        for (MyData myData : myDataList){
            if (currentID.equals(myData.getId())){
                myCurData = myData;
            }
        }
        return myCurData;
    }

    @Override
    public void setCurrentId(UUID currentID) {
        this.currentID = currentID;
    }

    @Override
    public List<MyData> getList() {
        return myDataList;
    }

    @Override
    public void addItem() {
        myDataList.add(new NivPoint());
    }
}
