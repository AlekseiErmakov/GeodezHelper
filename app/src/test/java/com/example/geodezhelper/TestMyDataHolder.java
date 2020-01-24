package com.example.geodezhelper;

import android.content.Context;

import com.example.geodezhelper.LR.DataLevRef;
import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.interfaces.DataLevRefExt;
import com.example.geodezhelper.interfaces.MyData;
import com.example.geodezhelper.interfaces.MyDataHolder;

import org.junit.Rule;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestMyDataHolder {
    @Test
    public void addition_isCorrect() {


        MyDataHolder dataHolder = DataLevRefExt.getInstance();
        dataHolder.addItem();
        dataHolder.getLastItem().setName("моя точка");
        System.out.println(dataHolder.getLastItem().getName());





    }
}
