package com.example.geodezhelper.LR;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

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



    @Override
    protected ActionBar createToolbar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar !=null){
            VectorDrawableCompat indicator = VectorDrawableCompat.create(getResources(), R.drawable.ic_back_toolbar, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(),R.color.white,getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        return supportActionBar;
    }
}
