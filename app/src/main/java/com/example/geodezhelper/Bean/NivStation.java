package com.example.geodezhelper.Bean;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.UUID;

public class NivStation {
    private String name;
    private ArrayList<NivDim> dims;
    private NivDim backNivDIm;
    private UUID nivStationUUID;
    public NivStation(){
        dims = new ArrayList<>();
        nivStationUUID = UUID.randomUUID();
    }
    public void setDims(ArrayList<NivDim> dims) {
        this.dims = dims;
    }

    public void setBackNivDIm(String backPointName, Double backPointReport) {
        if (backPointName!=null && backPointReport!=null){
            backNivDIm = new NivDim();
            backNivDIm.setPointName(backPointName);
            backNivDIm.setPointReport(backPointReport);
        }
    }
    public void addNewDim(){
        dims.add(new NivDim());
    }

    public UUID getNivStationUUID() {
        return nivStationUUID;
    }
    public NivDim getDim(UUID nivDimUUID){
        for (NivDim nivDim : dims){
            if (nivDim.getNivDimUUID().equals(nivDimUUID)){
                return nivDim;
            }
        }
        return null;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
