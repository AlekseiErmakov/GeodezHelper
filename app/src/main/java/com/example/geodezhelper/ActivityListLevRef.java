package com.example.geodezhelper;

import android.view.Menu;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityListLevRef extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new FragListLevRef();
    }

    @Override
    protected FloatingActionButton createFAB() {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_list_lev_ref);
        return fab;
    }
}
