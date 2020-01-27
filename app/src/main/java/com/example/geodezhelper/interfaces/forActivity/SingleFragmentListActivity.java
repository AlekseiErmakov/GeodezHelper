package com.example.geodezhelper.interfaces.forActivity;

import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.core.content.res.ResourcesCompat;

import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.example.geodezhelper.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class SingleFragmentListActivity extends SingleFragmentActivity implements View.OnClickListener {
    @Override
    protected ActionBar createToolbar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator = VectorDrawableCompat.create(getResources(), R.drawable.ic_back_toolbar, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        return supportActionBar;
    }

    @Override
    protected FloatingActionButton createFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_list);
        fab.setOnClickListener(this);

        return fab;
    }
    protected abstract void goToActivity();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_list:
                goToActivity();
                break;
        }

    }
}
