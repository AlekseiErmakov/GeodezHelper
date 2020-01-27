package com.example.geodezhelper.Pojo;

import com.example.geodezhelper.interfaces.forbeans.MyNivData;

import java.util.UUID;

public class NivPoint implements MyNivData {
    private Double report;
    private Double height;
    private String name;

    private UUID id;


    public NivPoint(){
        id=UUID.randomUUID();
    }

    public void setName(String name){
        this.name=name;
    }
    public void setReport(Double report) {
        this.report = report;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public UUID getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public Double getReport() {
        return report;
    }

    public Double getHeight() {
        return height;
    }



}
