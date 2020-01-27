package com.example.geodezhelper.BL;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.geodezhelper.interfaces.forActivity.SingleFragmentListActivity;
import com.example.geodezhelper.interfaces.forbeans.MyData;

public class ActivityListBL extends SingleFragmentListActivity {
    @Override
    protected Fragment createFragment() {
        return new FragmentListBL();
    }

    @Override
    protected void goToActivity() {
        DataBaseLine dataBaseLine = DataBaseLine.getInstance(this);
        dataBaseLine.addItem();
        MyData myData = dataBaseLine.getLastItem();
        Intent intent = ActivityItemBL.newIntent(this, myData.getId());
        startActivity(intent);
    }
}
