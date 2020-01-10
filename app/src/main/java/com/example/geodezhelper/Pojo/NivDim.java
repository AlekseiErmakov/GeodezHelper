package com.example.geodezhelper.Pojo;

import androidx.annotation.NonNull;

import java.util.UUID;

public class NivDim {
    private String pointName;
    private Double pointReport;
    private UUID nivDimUUID;
    public NivDim (){
        nivDimUUID = UUID.randomUUID();
    }
    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public void setPointReport(Double pointReport) {
        this.pointReport = pointReport;
    }
    public Double getPointReport() {
        return pointReport;
    }
    public UUID getNivDimUUID(){
        return nivDimUUID;
    }

    @NonNull
    @Override
    public String toString() {
        return pointName;
    }
}
