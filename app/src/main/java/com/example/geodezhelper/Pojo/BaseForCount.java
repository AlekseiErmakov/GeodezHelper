package com.example.geodezhelper.Pojo;

import com.example.geodezhelper.BL.Baseline;

public class BaseForCount extends Baseline{
    private static BaseForCount baseForCount;
    private BaseForCount(){

    }
    public static BaseForCount getBaseForCount(){
        if (baseForCount!=null){
            baseForCount = new BaseForCount();
        }
        return baseForCount;
    }
}
