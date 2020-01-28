package com.example.geodezhelper.Count.count;

import com.example.geodezhelper.MyMath;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.WordHolder;

public class CountReport implements CountInElev, WordHolder {
    @Override
    public String getResult(Double pOneEl, Double pOneRep, Double pTwoEl) {
        Integer result = MyMath.nivRep(pOneEl,pOneRep,pTwoEl);
        if (result!=null){
            String pointReport = StringUtils.reportTxt(result);
            return pointReport;
        }
        return NOTENOUGHDATA;
    }
}
