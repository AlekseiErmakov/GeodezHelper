package com.example.geodezhelper;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.UUID;

public class ActivityItemLevRef extends SingleFragmentActivity {
    public static final String EXTRA_LEV__REF_ID =
            "com.example.geodezhelper.nivpoint_id";
    public static Intent newIntent(Context packageContext, UUID levrefId) {
        Intent intent = new Intent(packageContext, ActivityItemLevRef.class);
        intent.putExtra(EXTRA_LEV__REF_ID,levrefId);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        return new FragItemLevRef();
    }

    @Override
    protected FloatingActionButton createFAB() {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_list_lev_ref);
        fab.hide();
        return fab;
    }

}
