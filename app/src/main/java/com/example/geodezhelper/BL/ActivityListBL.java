package com.example.geodezhelper.BL;

import android.content.Intent;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.example.geodezhelper.R;
import com.example.geodezhelper.SingleFragmentActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityListBL extends SingleFragmentActivity implements View.OnClickListener {
    @Override
    protected Fragment createFragment() {
        return new FragmentListBL();
    }

    @Override
    protected FloatingActionButton createFAB() {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_list_lev_ref);
        fab.setOnClickListener(this);
        return fab;
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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_list_lev_ref :
                DataBaseLine dataBaseLine = DataBaseLine.getInstance(this);
                dataBaseLine.addBL();
                Baseline baseline = dataBaseLine.getLastBL();
                Intent intent = ActivityItemBL.newIntent(this, baseline.getUuid());
                startActivity(intent);
                break;
        }

    }
}
