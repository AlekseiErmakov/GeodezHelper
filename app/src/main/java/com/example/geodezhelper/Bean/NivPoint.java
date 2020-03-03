package com.example.geodezhelper.Bean;

import com.example.geodezhelper.interfaces.forbeans.MyNivData;

import java.util.UUID;

import lombok.Data;

@Data
public class NivPoint implements MyNivData {
    private Double report;
    private Double height;
    private String name;
    private UUID id;

    public NivPoint(){
        id=UUID.randomUUID();
    }









}
