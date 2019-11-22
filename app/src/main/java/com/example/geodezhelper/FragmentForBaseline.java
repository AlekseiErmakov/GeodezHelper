package com.example.geodezhelper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentForBaseline extends Fragment {
    EditText x1text,y1text,h1text,x2text,y2text,h2text,nametext;
    Button saveBtn;
    TextView viewX1,viewY1,viewH1,viewX2,viewY2,viewH2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frgment_for_baseline, container, false);

        nametext=(EditText)v.findViewById(R.id.b_name_text);

        x1text=(EditText)v.findViewById(R.id.X1_text);
        y1text=(EditText)v.findViewById(R.id.Y1_text);
        h1text=(EditText)v.findViewById(R.id.H1_text);
        x2text=(EditText)v.findViewById(R.id.X2_text);
        y2text=(EditText)v.findViewById(R.id.Y2_text);
        h2text=(EditText)v.findViewById(R.id.H2_text);

        viewX1=(TextView)v.findViewById(R.id.view_X1);
        viewY1=(TextView)v.findViewById(R.id.view_Y1);
        viewH1=(TextView)v.findViewById(R.id.view_H1);
        viewX2=(TextView)v.findViewById(R.id.view_X2);
        viewY2=(TextView)v.findViewById(R.id.view_Y2);
        viewH2=(TextView)v.findViewById(R.id.view_H2);

        saveBtn=(Button)v.findViewById(R.id.save_bl);
        return v;
    }


}
