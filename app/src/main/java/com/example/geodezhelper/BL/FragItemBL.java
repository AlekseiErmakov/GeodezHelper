package com.example.geodezhelper.BL;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geodezhelper.Bean.Point;
import com.example.geodezhelper.R;
import com.example.geodezhelper.interfaces.forFrag.ItemFrag;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class FragItemBL extends ItemFrag {
    private EditText x1text,y1text,h1text,x2text,y2text,h2text,nametext;
    private Button saveBtn;
    private TextView viewX1,viewY1,viewH1,viewX2,viewY2,viewH2,viewBLname;
    private Baseline baseline;
    private Map<EditText,TextView> views;
    private static final String ARG_BL_ID = "bl_id";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID blid = (UUID) getArguments().getSerializable(ARG_BL_ID);
        baseline=(Baseline) DataBaseLine.getInstance(getActivity()).getItem(blid);
    }
    public static FragItemBL newInstance(UUID blid) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_BL_ID,blid);
        FragItemBL fragmentItemBL = new FragItemBL();
        fragmentItemBL.setArguments(args);
        return fragmentItemBL;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_bl, container, false);
        createEditText(v);
        createTextView(v);
        createButton(v);
        views = getViews();
        upDateView();
        return v;
    }
    private void createEditText(View v){
        nametext=(EditText)v.findViewById(R.id.b_name_text);
        x1text=(EditText)v.findViewById(R.id.X_text);
        y1text=(EditText)v.findViewById(R.id.Y_text);
        h1text=(EditText)v.findViewById(R.id.H1_text);
        x2text=(EditText)v.findViewById(R.id.X2_text);
        y2text=(EditText)v.findViewById(R.id.Y2_text);
        h2text=(EditText)v.findViewById(R.id.H2_text);
    }
    private void createTextView(View v){
        viewBLname = (TextView)v.findViewById(R.id.bl_view_name);
        viewBLname.setVisibility(View.INVISIBLE);
        viewX1=(TextView)v.findViewById(R.id.view_X1);
        viewX1.setVisibility(View.INVISIBLE);
        viewY1=(TextView)v.findViewById(R.id.view_Y1);
        viewY1.setVisibility(View.INVISIBLE);
        viewH1=(TextView)v.findViewById(R.id.view_H1);
        viewH1.setVisibility(View.INVISIBLE);
        viewX2=(TextView)v.findViewById(R.id.view_X2);
        viewX2.setVisibility(View.INVISIBLE);
        viewY2=(TextView)v.findViewById(R.id.view_Y2);
        viewY2.setVisibility(View.INVISIBLE);
        viewH2=(TextView)v.findViewById(R.id.view_H2);
        viewH2.setVisibility(View.INVISIBLE);

    }
    private void createButton(View v){
        saveBtn=(Button)v.findViewById(R.id.save_baseline);
        saveBtn.setOnClickListener(this);

    }
    private void upDateView(){
        Point point1 = baseline.getPone();
        Point point2 = baseline.getPtwo();
        String name = baseline.getName();
        if (name != null){
            nametext.setText(name);
        }
        if (point1 != null){
            x1text.setText(String.valueOf(point1.getX()));
            y1text.setText(String.valueOf(point1.getY()));
            h1text.setText(String.valueOf(point1.getH()));
        }
        if (point2 != null){
            x2text.setText(String.valueOf(point2.getX()));
            y2text.setText(String.valueOf(point2.getY()));
            h2text.setText(String.valueOf(point2.getH()));
        }
    }

    public void updateData(){
        baseline.setName(chekName(nametext,views));
        updateOne();
        updateTwo();
        makeMyToast(R.string.toast_data_update);

    }
    public void updateOne(){
        Point pointOne = new Point();
        pointOne.setX(chekDouble(x1text,views));
        pointOne.setY(chekDouble(y1text,views));
        pointOne.setH(chekDouble(h1text,views));
        baseline.setPone(pointOne);
    }
    public void updateTwo(){
        Point pointTwo = new Point();
        pointTwo.setX(chekDouble(x2text,views));
        pointTwo.setY(chekDouble(y2text,views));
        pointTwo.setH(chekDouble(h2text,views));
        baseline.setPtwo(pointTwo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.save_baseline):
                updateData();
                break;
        }
    }

    @Override
    public Map<EditText, TextView> getViews() {
        Map<EditText, TextView> views = new HashMap<>();
        views.put(nametext,viewBLname);
        views.put(x1text,viewX1);
        views.put(y1text,viewY1);
        views.put(h1text,viewH1);
        views.put(x2text,viewX2);
        views.put(y2text,viewY2);
        views.put(h2text,viewH2);

        return views;
    }
}
