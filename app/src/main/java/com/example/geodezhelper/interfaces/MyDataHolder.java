package com.example.geodezhelper.interfaces;

import android.content.Context;

import java.util.List;
import java.util.UUID;

public interface MyDataHolder {
    List<MyData> getList();
    void addItem();
    void removeItem();
    MyData getItem(UUID id);
    MyData getLastItem();
    MyData getCurItem();
    void setCurrentId(UUID id);

}

