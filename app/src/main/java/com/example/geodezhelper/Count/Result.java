package com.example.geodezhelper.Count;

import com.example.geodezhelper.BL.Baseline;
import com.example.geodezhelper.MyMath;
import com.example.geodezhelper.Pojo.Point;

import java.util.Locale;

public class Result {
    private Baseline baseline;
    private Point point;
    private String radius;
    private String deviation;
    private String absolutLength;
    private String gorizontalLength;
    private String deltaH;
    private final String notEnoughData = "Не достаточно данных";
    public Result(Baseline baseline, Point point){
          this.baseline = baseline;
          this.point = point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setBaseline(Baseline baseline) {
        this.baseline = baseline;
    }

    public String getRadius() {
        Double rad = MyMath.Rad(baseline,point);
        if (rad!=null){
            radius = String.format(Locale.ENGLISH,"%.3f",rad);
            return radius;
        }
        return notEnoughData;
    }

    public String getDeviation() {
        Double dev = MyMath.Dev(baseline,point);
        if (dev!=null){
            deviation = String.format(Locale.ENGLISH,"%.3f",dev);
        }
        return notEnoughData;
    }

    public String getAbsolutLength() {
        Double AbsLength = MyMath.absolutLength(baseline,point);
        if(AbsLength!=null){
            absolutLength = String.format(Locale.ENGLISH,"%.3f",AbsLength);
        }
        return notEnoughData;
    }

    public String getGorizontalLength() {
        Double gorLength = MyMath.gorizontalLength(baseline,point);
        if(gorLength!=null){
            gorizontalLength = String.format(Locale.ENGLISH,"%.3f",gorLength);
        }
        return notEnoughData;
    }

    public String getDeltaH() {
        Double delH = MyMath.DeltaH(baseline,point);
        if (delH!=null){
            deltaH = String.format(Locale.ENGLISH,"%.3f",delH);
        }
        return notEnoughData;
    }
}