package com.example.geodezhelper.Pojo;

import androidx.annotation.NonNull;

import com.example.geodezhelper.WordHolder;

import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class Point implements WordHolder {
    private String name,fromSdr,Code;
    private Double x,y,h;

    public Point(String fromSdr){
        this.fromSdr=fromSdr;
        sdrParser();
    }

    public Point(Double x, Double y, Double h) {
        this.x = x;
        this.y = y;
        this.h = h;
        name=DEFAULTNAME;
        Code = DEFAULTPOINTCODE;
    }

    public Point(String name, Double x, Double y, Double h) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.h = h;
        Code = DEFAULTPOINTCODE;
    }
    private void sdrParser(){
        char[]coords = fromSdr.toCharArray();
        name="";
        String fixName="";
        String coord ="";
        for (int i = 1;i<coords.length;i++){
            if (i<20)
                fixName+=coords[i];
            else
                coord+=coords[i];
        }
        String[] temp = fixName.split("\\s+");
        for (int i=1;i<temp.length;i++){
            name+=temp[i];
            if (i<temp.length-1)
                name+=" ";
        }
        String[]XYHCode=coord.split("\\s+");
        if (XYHCode.length==3){
            setCoord(XYHCode);
            Code = DEFAULTPOINTCODE;
        }else if (XYHCode.length==4){
            setCoord(XYHCode);
            Code=XYHCode[3];
        }
    }

    private void setCoord(String[] list){
        x=Double.parseDouble(list[0]);
        y=Double.parseDouble(list[1]);
        h=Double.parseDouble(list[2]);
    }

    public String getName() {
        return name;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getH() {
        return h;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setH(Double h) {
        this.h = h;
    }
    public String getTotalStPoint(){
        return String.format(Locale.ENGLISH,"%s%16s%-16.3f%-16.3f%-16.3f%-16s",POINTSTRING,name,x,y,h,Code).replaceAll(",",".");
    }
    public String getSdrPoint(){
        return String.format(Locale.ENGLISH,"%s%16s%-16.3f%-16.3f%-16.3f%-16s",POINTSTRING,name,x,y,h,Code).replaceAll(",",".");
    }
    public String getTxtPoint(Boolean b){
        return b ? String.format(Locale.ENGLISH,"%s+\t+%.3f+\t+%.3f+\t+%.3f",name,x,y,h) :
                String.format(Locale.ENGLISH,"%s+\t+%.3f+\t+%.3f+\t+%.3f",name,x,y,h).replaceAll(",",".");
    }

}
