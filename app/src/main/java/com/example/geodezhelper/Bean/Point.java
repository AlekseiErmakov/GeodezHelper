package com.example.geodezhelper.Bean;

import com.example.geodezhelper.WordHolder;
import com.example.geodezhelper.interfaces.forbeans.My3Dpoint;

import java.util.Locale;
import java.util.UUID;

import lombok.Data;

@Data
public class Point implements WordHolder, My3Dpoint {
    private String name,fromSdr,Code;
    private Double x,y,h;
    public Point(){
    }
    public Point(Double x, Double y, Double h) {
        this.x = x;
        this.y = y;
        this.h = h;
        name=DEFAULTNAME;
        Code = DEFAULTPOINTCODE;
    }

    @Override
    public UUID getId() {
        throw new UnsupportedOperationException();
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
