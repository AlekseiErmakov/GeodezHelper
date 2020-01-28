package com.example.geodezhelper.Count.count;

import com.example.geodezhelper.MyMath;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.WordHolder;

public class CountHeight implements CountInElev, WordHolder {
    @Override
    public String getResult(Double pOneEl, Double pOneRep, Double pTwoRep) {
        Double result = MyMath.nivElevation(pOneRep,pOneEl,pTwoRep);
        if (result!=null){
           String pointElevation = StringUtils.coordTxt(result);
            return pointElevation;
        }
        return NOTENOUGHDATA;
    }


}
