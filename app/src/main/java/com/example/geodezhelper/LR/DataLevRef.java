package com.example.geodezhelper.LR;

import android.content.Context;


import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.interfaces.forData.DataConteiner;
import com.example.geodezhelper.interfaces.forbeans.MyData;


import java.util.ArrayList;
import java.util.List;


public class DataLevRef extends DataConteiner {
    private static DataLevRef dataLevRef;

    private static List<MyData> myDatas;

    private DataLevRef(Context context, List<MyData> myDatas){
        super(context,myDatas);
    }

    public static DataLevRef getInstance(Context context){
        if(dataLevRef == null){
            myDatas = new ArrayList<>();
            dataLevRef = new DataLevRef(context,myDatas);
        }
        return dataLevRef;
    }

    public void addItem(){
        myDatas.add(new NivPoint());
    }

}
