package com.example.geodezhelper.round;

import com.example.geodezhelper.MyMath;
import com.example.geodezhelper.Pojo.Point;
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
        double length = getDim(centeres,midRoundCenter);
        String center = "Усредненный центр окружности.";
        String dim = "Средний радиус";
        return center + "\n" +
                "Координата X: " + midRoundCenter.getX() + "\n" +
                "Координата Y: " + midRoundCenter.getY() + "\n" +
                "Cредний радиус: " + length;
    }
    private MySimplePoint getMidCenter(){

        List<MySimplePoint> temp = points;
        int count = 0;
        while(points.size()>2){
            for (int j = 1; j < temp.size();j++){
                for (int k = 2; k < temp.size(); k++){
                    RoundCenter rc = (RoundCenter) MyMath.countCenter(temp.get(0),temp.get(j),temp.get(k));
                    centeres.add(rc);
                }
            }
            temp.remove(0);
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
            if (point.getX() != null){
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
            if (point.getY() != null){
                countY += point.getY();
                count++;
            }
        }
        return count == 0 ? 0 : countY/count;
    }
    private double getDim(List<MySimplePoint> centres, MySimplePoint center){
        List<Double> length = new ArrayList<>();
        double countDim = 0;
        int count = 0;
        for(MySimplePoint point : centres){
            if (point.getX()!= null && point.getY()!=null){
                countDim += MyMath.countDim(point,center);
                count++;
            }
        }
        return count == 0 ? 0 : countDim/count;
    }
}
