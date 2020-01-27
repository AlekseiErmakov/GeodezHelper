package com.example.geodezhelper.BL;

import android.content.Context;


import com.example.geodezhelper.interfaces.forData.DataConteiner;
import com.example.geodezhelper.interfaces.forbeans.MyData;


import java.util.ArrayList;
import java.util.List;


public class DataBaseLine extends DataConteiner {
    private static DataBaseLine dataBaseLine;
    private static List<MyData> myDatas;

    private DataBaseLine(Context context, List<MyData> myDatas){
        super(context,myDatas);

    }
    public static DataBaseLine getInstance(Context context){
        if (dataBaseLine == null){
            myDatas = new ArrayList<>();
            dataBaseLine = new DataBaseLine(context,myDatas);
        }
        return dataBaseLine;
    }


    public void addItem(){
        myDatas.add(new Baseline());
    }

}
