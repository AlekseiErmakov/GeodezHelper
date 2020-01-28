package com.example.geodezhelper.round;

import android.content.Intent;

import androidx.fragment.app.Fragment;


import com.example.geodezhelper.interfaces.forActivity.SingleFragmentListActivity;
import com.example.geodezhelper.interfaces.forData.MyDataHolder;
import com.example.geodezhelper.interfaces.forbeans.MyData;

public class ActivityListPointR extends SingleFragmentListActivity {
    @Override
    protected void goToActivity() {
        MyDataHolder myDataHolder = DataPointR.getInstance(this);
        myDataHolder.addItem();
        MyData myData = myDataHolder.getLastItem();
        Intent intent = ActivityItemPointR.newIntent(this,myData.getId());
        startActivity(intent);
    }

    @Override
    protected Fragment createFragment() {
        return new FragListPointR();
    }
}
