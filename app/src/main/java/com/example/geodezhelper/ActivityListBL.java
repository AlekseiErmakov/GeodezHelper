package com.example.geodezhelper;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityListBL extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new FragmentListBL();
    }

    @Override
    protected FloatingActionButton createFAB() {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_list_lev_ref);
        return fab;
    }
}