package com.example.geodezhelper.round;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.geodezhelper.R;
import com.example.geodezhelper.interfaces.forFrag.ItemFrag;
import com.example.geodezhelper.interfaces.forbeans.MySimplePoint;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FragItemPointR extends ItemFrag{
    private static final String ARG_POINTR_ID = "point_r_id";
    private MySimplePoint point;
    private Button saveBtn;
    private EditText Nametext;
    private TextView NameReport;
    private EditText Xtext;
    private TextView Xrepot;
    private EditText Ytext;
    private TextView Yreport;
    private Map<EditText, TextView> views;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID prId = (UUID) getArguments().getSerializable(ARG_POINTR_ID);
        point = (MySimplePoint) DataPointR.getInstance(getActivity()).getItem(prId);
    }

    public static FragItemPointR newInstance(UUID prId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_POINTR_ID, prId);
        FragItemPointR fragItemPointR = new FragItemPointR();
        fragItemPointR.setArguments(args);
        return fragItemPointR;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_round, container, false);
        createButtonView(v);
        createEdirText(v);
        createTextView(v);
        upDateView();
        views = getViews();
        return v;
    }
    public Map<EditText, TextView> getViews() {
        Map<EditText, TextView> views = new HashMap<>();
        views.put(Nametext, NameReport);
        views.put(Xtext, Xrepot);
        views.put(Ytext, Yreport);

        return views;
    }
    @Override
    public void updateData() {
        point.setName(chekName(Nametext,views));
        point.setX(chekDouble(Xtext,views));
        point.setY(chekDouble(Ytext,views));
        if (point.getName() == null && point.getX() == null && point.getY() == null){
            makeMyToast(R.string.toast_data_all_invalide);
        }else {
            makeMyToast(R.string.toast_data_update);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.save_pointr) :
                updateData();
                break;
        }
    }

    private void createEdirText(View v) {
        Nametext = (EditText) v.findViewById(R.id.point_r_name_text);
        Xtext = (EditText) v.findViewById(R.id.point_r_X_text);
        Ytext = (EditText) v.findViewById(R.id.point_r_Y_text);
    }

    private void createTextView(View v) {
        Xrepot = (TextView) v.findViewById(R.id.X_view);
        Xrepot.setVisibility(View.INVISIBLE);
        Yreport = (TextView) v.findViewById(R.id.Yr_view);
        Yreport.setVisibility(View.INVISIBLE);
        NameReport = (TextView) v.findViewById(R.id.view_round_p_name);
        NameReport.setVisibility(View.INVISIBLE);
    }

    private void createButtonView(View v) {
        saveBtn = (Button) v.findViewById(R.id.save_pointr);
        saveBtn.setOnClickListener(this);
    }

    private void upDateView() {
        String Name = String.valueOf(point.getName());
        String X = String.valueOf(point.getX());
        String Y = String.valueOf(point.getY());
        if (!Name.equals("null")) {
            Xtext.setText(X);
        }
        if (!X.equals("null") ) {
            Ytext.setText(Y);
        }
        if (!Y.equals("null")) {
            Nametext.setText(Name);
        }

    }



}
