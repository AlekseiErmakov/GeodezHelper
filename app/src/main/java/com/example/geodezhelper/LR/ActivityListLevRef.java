package com.example.geodezhelper.LR;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.geodezhelper.interfaces.forActivity.SingleFragmentListActivity;
import com.example.geodezhelper.interfaces.forbeans.MyData;

public class ActivityListLevRef extends SingleFragmentListActivity{
    @Override
    protected Fragment createFragment() {
        return new FragListLevRef();
    }

    @Override
    protected void goToActivity() {
        DataLevRef levRefData = DataLevRef.getInstance(this);
        levRefData.addItem();
        MyData myData = levRefData.getLastItem();
        Intent intent = ActivityItemLevRef.newIntent(this, myData.getId());
        startActivity(intent);
    }

}
