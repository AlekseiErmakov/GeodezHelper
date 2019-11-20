package com.example.geodezhelper;

import android.widget.Adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Sdr33File  implements WordHolder{
    private Date date;
    private String TotalStation,TsNum,Serie,time,hight,job;
    private ArrayList<Point> points;
    private ArrayList<String> result,Hat;

    public Sdr33File(Date date, String totalStation,String TsNum,String Serie,String hight, ArrayList<Point> points, String job) {
        this.date = date;
        this.TotalStation = totalStation;
        this.points = points;
        this.job = job;
        this.hight = hight;
        this.Serie=Serie;
        this.TsNum=TsNum;
        result=new ArrayList<>();
    }
    public void makeViewFile(){
        result.clear();
        Hat = makeHat();
        result.addAll(Hat);
        addViewPoints();
    }
    public void makeTSfile(){
        result.clear();
        Hat = makeHat();
        result.addAll(Hat);
        addTotalStPoints();
    }
    private ArrayList<String> makeHat(){
        ArrayList<String> Hat = new ArrayList<>();
        Hat.add(makeFirst());
        Hat.add(makeSecond());
        Hat.add(makeThird());
        Hat.add(makeFourth());
        Hat.add(makeFifth());
        return Hat;
    }
    private String makeFirst(){
        return String.format(Locale.ENGLISH,"%s%s\t%s%s",FILESTART,VERSION,makeTime(),CodeonFIRST);
    }
    private String makeSecond(){
        return String.format(Locale.ENGLISH,"%s%s%12s%s",SECONDSTART,job,SPASE,CODEonSECOND);
    }
    private String makeThird(){
        return String.format(Locale.ENGLISH,"%s",THIRDLANE);
    }
    private String makeFourth(){
        String Taxeo =TotalStation+SPASE+Serie;
        return String.format(Locale.ENGLISH,"%s%16s%s%16s%s%32s%-15s",FORTHSTART,Taxeo,TsNum,Taxeo,TsNum,SPASE,FOURTHZERO);
    }
    private String makeFifth(){
        return String.format(Locale.ENGLISH,"%s%s%11s",FIFTHSTART,hight,SPASE);
    }
    private String makeTime(){
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd-MMM-YY hh-mm", Locale.ENGLISH);
        return simpleDateFormat.format(date).toUpperCase();
    }

    private void addViewPoints(){
        for(Point p : points)
            result.add(p.getSdrPoint());
    }
    private void addTotalStPoints(){
        for(Point p : points)
            result.add(p.getTotalStPoint());
    }
    public ArrayList<String> getResult(){
        return result;
    }

}