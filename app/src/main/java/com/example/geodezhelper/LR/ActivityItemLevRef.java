package com.example.geodezhelper.LR;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.geodezhelper.Bean.NivPoint;
import com.example.geodezhelper.interfaces.forActivity.SingleFragmentItemActivity;

import java.util.List;
import java.util.UUID;

public class ActivityItemLevRef extends SingleFragmentItemActivity {
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


}
