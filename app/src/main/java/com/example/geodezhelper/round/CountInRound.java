package com.example.geodezhelper.round;

import com.example.geodezhelper.MyMath;
import com.example.geodezhelper.Pojo.Point;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.interfaces.forbeans.MySimplePoint;

import java.util.ArrayList;
import java.util.List;

public class CountInRound {
    private MySimplePoint midRoundCenter;
    private Double midRadius;
    private List<MySimplePoint> points;
    double midLength;
    List<MySimplePoint> centeres;
    public CountInRound(){
        centeres = new ArrayList<>();
    }
    public String getResult(List<MySimplePoint> pointsF){
        points = pointsF;
        String result = "";
        if (points.size() < 2){
            return "";
        }
        midRoundCenter = getMidCenter();
        double length = getDim(midRoundCenter);

        return "Усредненный центр окружности." + "\n" +
                "Координата X: " + StringUtils.coordTxt(midRoundCenter.getX()) + "\n" +
                "Координата Y: " + StringUtils.coordTxt(midRoundCenter.getY()) + "\n" +
                "Cредний радиус: " + StringUtils.coordTxt(length);
    }
    private MySimplePoint getMidCenter(){
        int count = 0;
       for (int i = 0; i < points.size()-2; i++){
            for (int j = i+1; j < points.size()-1;j++){
                for (int k = j+1; k < points.size(); k++){
                    RoundCenter rc = (RoundCenter) MyMath.countCenter(points.get(0),points.get(j),points.get(k));
                    if (rc != null)
                    centeres.add(rc);
                }
            }

        }
        MySimplePoint centre = new RoundCenter();
        Double X = getMidX(centeres);
        Double Y = getMidY(centeres);
        centre.setX(X);
        centre.setY(Y);

        return centre;
    }
    private Double getMidX(List<MySimplePoint> centres){
        double countX = 0;
        int count = 0;
        for (MySimplePoint point : centres){
            if (point != null && point.getX() != null){
                countX += point.getX();
                count++;
            }
        }
        return count == 0 ? 0 : countX/count;
    }
    private double getMidY(List<MySimplePoint> centres){
        double countY = 0;
        int count = 0;
        for (MySimplePoint point : centres){
            if (point != null && point.getY() != null){
                countY += point.getY();
                count++;
            }
        }
        return count == 0 ? 0 : countY/count;
    }
    private double getDim( MySimplePoint center){
        List<Double> length = new ArrayList<>();
        double countDim = 0;
        int count = 0;
        for(MySimplePoint point : points){
            if (point != null && point.getX()!= null && point.getY()!=null){
                countDim += MyMath.countDim(point,center);
                count++;
            }
        }
        return count == 0 ? 0 : countDim/count;
    }
}
