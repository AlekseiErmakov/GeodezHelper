package com.example.geodezhelper.BL;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.example.geodezhelper.R;
import com.example.geodezhelper.SingleFragmentActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.UUID;

public class ActivityItemBL extends SingleFragmentActivity {
    public static final String EXTRA_BL_ID =
            "com.example.geodezhelper.bl_id";


    public static Intent newIntent(Context packageContext, UUID levrefId) {
        Intent intent = new Intent(packageContext, ActivityItemBL.class);
        intent.putExtra(EXTRA_BL_ID,levrefId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID blID= (UUID)getIntent()
                .getSerializableExtra(EXTRA_BL_ID);
        return FragItemBL.newInstance(blID);
    }

    @Override
    protected FloatingActionButton createFAB() {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_list_lev_ref);
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
}
