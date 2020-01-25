package com.example.geodezhelper.interfaces;

import android.hardware.camera2.CaptureResult;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class ItemFrag extends Fragment {
    private HashMap<EditText,TextView> views;

    private ArrayList<EditText> textfields;

    private MyData myData;

    protected abstract HashMap<EditText,TextView> makeViews();

    protected abstract String makeArguments();

    protected abstract void updateData();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String arg = makeArguments();
        UUID blid = (UUID) getArguments().getSerializable(arg);

        views = makeViews();

    }
    public void setViewInvisible(){
        for (EditText text : views.keySet()) {
            views.get(text).setVisibility(View.INVISIBLE);
        }
    }
    public Double updateCoord(EditText editText){
        Double result = null;
        if (editText != null && views != null){
            try {
                result = Double.parseDouble(editText.getText().toString());
                views.get(editText).setVisibility(View.INVISIBLE);
            }catch (Exception ex){
                views.get(editText).setVisibility(View.VISIBLE);
            }
        }
        return result;
    }
    public Integer updateReport(EditText editText){
        Integer result = null;
        if (editText != null && views != null){
            try {
                result = Integer.parseInt(editText.getText().toString());
                views.get(editText).setVisibility(View.INVISIBLE);
            }catch (Exception ex){
                views.get(editText).setVisibility(View.VISIBLE);
            }
        }
        return result;
    }
}
