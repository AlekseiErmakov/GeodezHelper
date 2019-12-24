package com.example.geodezhelper.LR;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.R;
import com.example.geodezhelper.SingleFragmentActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.UUID;

public class ActivityItemLevRef extends SingleFragmentActivity {
    private List<NivPoint> levrefs;
    public static final String EXTRA_LEV__REF_ID =
            "com.example.geodezhelper.lev_ref_id";
    public static Intent newIntent(Context packageContext, UUID levrefId) {
        Intent intent = new Intent(packageContext, ActivityItemLevRef.class);
        intent.putExtra(EXTRA_LEV__REF_ID,levrefId);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        UUID levrefId= (UUID)getIntent()
                .getSerializableExtra(EXTRA_LEV__REF_ID);
        return FragItemLevRef.newInstance(levrefId);
    }

    @Override
    protected FloatingActionButton createFAB() {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_list_lev_ref);
        fab.hide();
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
