package com.example.geodezhelper.interfaces.forData;

import android.content.Context;

import com.example.geodezhelper.interfaces.forbeans.MyData;

import java.util.List;
import java.util.UUID;

public abstract class DataConteiner implements MyDataHolder {

    private List<MyData> myDataList;
    private UUID currentID;
    public DataConteiner(Context context,List<MyData> myDataList){
        this.myDataList = myDataList;
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
    public void setCurId(UUID currentID) {
        this.currentID = currentID;
    }

    @Override
    public List<MyData> getList() {
        return myDataList;
    }

}
