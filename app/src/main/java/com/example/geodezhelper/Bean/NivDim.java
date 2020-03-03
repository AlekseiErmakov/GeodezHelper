package com.example.geodezhelper.Bean;

import androidx.annotation.NonNull;

import java.util.UUID;

import lombok.Data;

@Data
public class NivDim {
    private String pointName;
    private Double pointReport;
    private UUID nivDimUUID;
    public NivDim (){
        nivDimUUID = UUID.randomUUID();
    }

}
