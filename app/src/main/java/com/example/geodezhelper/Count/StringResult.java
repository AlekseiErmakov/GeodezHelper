package com.example.geodezhelper.Count;

import com.example.geodezhelper.BL.Baseline;
import com.example.geodezhelper.MyMath;
import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.Pojo.Point;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.WordHolder;

import java.util.Locale;

public class StringResult implements WordHolder {
    private Baseline baseline;
    private Point point;
    private NivPoint nivPointOne;
    private NivPoint nivPointTwo;
    private String radius;
    private String deviation;
    private String absolutLength;
    private String gorizontalLength;
    private String deltaH;
    private String pointElevation;
    private String pointReport;
    private Double pRep;

    public StringResult(){

    }
    public StringResult(Baseline baseline, Point point){
          this.baseline = baseline;
          this.point = point;
    }
    public StringResult(NivPoint nivPointOne, NivPoint nivPointTwo){
        this.nivPointOne = nivPointOne;
        this.nivPointTwo = nivPointTwo;
    }
    public StringResult(NivPoint nivPointOne, NivPoint nivPointTwo, Double pRep){
        this.nivPointOne = nivPointOne;
        this.nivPointTwo = nivPointTwo;
        this.pRep = pRep;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setBaseline(Baseline baseline) {
        this.baseline = baseline;
    }

    public String getRadius() {
        Double rad = MyMath.blRad(baseline,point);
        if (rad!=null){
            radius = StringUtils.coordTxt(rad);
            return radius;
        }
        return NOTENOUGHDATA;
    }

    public String getDeviation() {
        Double dev = MyMath.blDev(baseline,point);
        if (dev!=null){
            deviation = StringUtils.coordTxt(dev);
            return deviation;
        }
        return NOTENOUGHDATA;
    }

    public String getAbsolutLength() {
        Double AbsLength = MyMath.blAbsolutLength(baseline,point);
        if(AbsLength!=null){
            absolutLength = StringUtils.coordTxt(AbsLength);
            return absolutLength;
        }
        return NOTENOUGHDATA;
    }

    public String getGorizontalLength() {
        Double gorLength = MyMath.blGorizontalLength(baseline,point);
        if(gorLength!=null){
            gorizontalLength = StringUtils.coordTxt(gorLength);
            return gorizontalLength;
        }
        return NOTENOUGHDATA;
    }

    public String getDeltaH() {
        Double delH = MyMath.blDeltaH(baseline,point);
        if (delH!=null){
            deltaH = StringUtils.coordTxt(delH);
            return deltaH;
        }
        return NOTENOUGHDATA;
    }
    public String getPointEl(){

        Double poinrEl=null;
        if (pRep!=null){
           poinrEl = MyMath.nivElevation(nivPointOne,nivPointTwo,pRep);
            System.out.println(poinrEl);
        }

        if (poinrEl!=null){
            pointElevation = StringUtils.coordTxt(poinrEl);
            return pointElevation;
        }
        return NOTENOUGHDATA;
    }
    public String getPointEl(Double pOneRep, Double pOneEl, Double pTwoRep){
        Double result = MyMath.nivElevation(pOneRep,pOneEl,pTwoRep);
        if (result!=null){
            pointElevation = StringUtils.coordTxt(result);
            return pointElevation;
        }
        return NOTENOUGHDATA;
    }
    public String getPointReport(){
        Integer pointRp = MyMath.nivRep(nivPointOne,nivPointTwo);
        if (pointRp!=null){
            pointReport = StringUtils.reportTxt(pointRp);
            return pointReport;

        }
        return NOTENOUGHDATA;
    }
    public String getPointReport(Double pOneEl, Double pOneRep, Double pTwoEl){
        Integer result = MyMath.nivRep(pOneEl,pOneRep,pTwoEl);
        if (result!=null){
            pointReport = StringUtils.reportTxt(result);
            return pointReport;
        }
        return NOTENOUGHDATA;
    }


}