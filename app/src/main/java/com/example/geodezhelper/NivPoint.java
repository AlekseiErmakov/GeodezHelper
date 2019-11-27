package com.example.geodezhelper;

import java.util.Locale;
import java.util.UUID;

public class NivPoint {
    private double report;
    private double height;
    private String name;
    private  NivPoint backPoint;
    private UUID id;
    public static final double Th =1000;
    public static final String DefaultPointName="Unnamed";
    public NivPoint(){
        id=UUID.randomUUID();
    }
    public NivPoint(double height){
        this.height=height;
        name = DefaultPointName;
    }
    public NivPoint(String name,double height){
        this.name = name;
        this.height = height;
        report = 0;
    }
    public NivPoint(double  height, double  report){
        this.report = report/Th;
        this.height = height;
        name = DefaultPointName;
    }
    public NivPoint(String name,double  height, double  report){
        this.report = report/Th;
        this.height = height;
        this.name = name;
    }
    public NivPoint(double report, NivPoint backPoint){
        this.report = report/Th;
        this.backPoint = backPoint;
        this.name = DefaultPointName;
        calculateHeigt();
    }
    public NivPoint(String name,double report, NivPoint backPoint){
        this.report = report/Th;
        this.backPoint = backPoint;
        this.name = name;
        calculateHeigt();
    }


    public void setName(String name){
        this.name=name;
    }
    public void setReport(double report) {
        this.report = report;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public UUID getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public double getReport() {
        return report;
    }

    public double getHeight() {
        return height;
    }
    private void calculateHeigt(){
        height = backPoint.getHeight()+backPoint.getReport()-report;
    }
    public String getRepString(NivPoint backPoint){
        report = (backPoint.getHeight()+backPoint.getReport()-height)*Th;
        return String.format(Locale.ENGLISH,"%.0f",report);
    }
    public String getHeightSrting(){
        return String.format(Locale.ENGLISH,"%.3f",height);
    }

}
