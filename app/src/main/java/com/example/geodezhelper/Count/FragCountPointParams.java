package com.example.geodezhelper.Count;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geodezhelper.BL.Baseline;
import com.example.geodezhelper.Pojo.BaseForCount;
import com.example.geodezhelper.R;

import java.util.HashMap;
import java.util.Map;


public class FragCountPointParams extends Fragment {
    private EditText xText;
    private EditText yText;
    private EditText hText;
    private TextView xView;
    private TextView yView;
    private TextView hView;
    private Map<EditText, View> views;
    Baseline baseForCount;

    {
        views = new HashMap<>();
        baseForCount = new Baseline();
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_count_point_params, null);
        addEditTexts();
        addViews();
        return view;
    }
    private void addEditTexts(){
        xText = (EditText)view.findViewById(R.id.X_text);


        yText = (EditText)view.findViewById(R.id.Y_text);
        hText = (EditText)view.findViewById(R.id.H_text);
    }
    private void addViews(){
        xView = (TextView)view.findViewById(R.id.view_x_report);
        xView.setVisibility(View.INVISIBLE);
        yView = (TextView)view.findViewById(R.id.view_y_report);
        yView.setVisibility(View.INVISIBLE);
        hView = (TextView)view.findViewById(R.id.view_h_report);
        hView.setVisibility(View.INVISIBLE);
    }



    private Double checkCoord(EditText editText){
        Double result = null;
        try {
            result = Double.parseDouble(editText.getText().toString());
            views.get(editText).setVisibility(View.INVISIBLE);
            return result;
        }catch (Exception ex){
            views.get(editText).setVisibility(View.VISIBLE);
            return result;
        }
    }
}
