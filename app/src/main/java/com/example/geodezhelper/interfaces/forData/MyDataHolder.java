package com.example.geodezhelper.interfaces.forData;



import com.example.geodezhelper.interfaces.forbeans.MyData;

import java.util.List;
import java.util.UUID;

public interface MyDataHolder {
    List<MyData> getList();
    void addItem();
    void removeItem();
    MyData getItem(UUID id);
    MyData getLastItem();
    MyData getCurItem();
    void setCurId(UUID id);

}

