package com.example.geodezhelper.LR;

import android.content.Intent;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.R;
import com.example.geodezhelper.SingleFragmentActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityListLevRef extends SingleFragmentActivity implements View.OnClickListener{


    @Override
    protected Fragment createFragment() {
        return new FragListLevRef();
    }

    @Override
    protected FloatingActionButton createFAB() {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_list_lev_ref);
         fab.setOnClickListener(this);
        return fab;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_list_lev_ref :
                DataLevRef levRefData = DataLevRef.getInstance(this);
                levRefData.addLevRef();
                NivPoint MynivPoint = levRefData.getLastAddLevRef();
                Intent intent = ActivityItemLevRef.newIntent(this, MynivPoint.getId());
                startActivity(intent);
                break;
        }

    }
}
