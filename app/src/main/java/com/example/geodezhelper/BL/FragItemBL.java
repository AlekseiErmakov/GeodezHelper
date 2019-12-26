package com.example.geodezhelper.BL;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geodezhelper.R;
import com.example.geodezhelper.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class FragItemBL extends Fragment {
    private EditText x1text,y1text,h1text,x2text,y2text,h2text,nametext;
    private Button saveBtn;
    private TextView viewX1,viewY1,viewH1,viewX2,viewY2,viewH2;
    private Baseline baseline;
    private Map<EditText,TextView> views;
    private ArrayList<EditText> textfields;
    private static final String ARG_BL_ID = "bl_id";

    {
        views = new HashMap<>();
        textfields = new ArrayList<>();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID blid = (UUID) getArguments().getSerializable(ARG_BL_ID);
        baseline=DataBaseLine.getInstance(getActivity()).getBaseline(blid);
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

        nametext=(EditText)v.findViewById(R.id.b_name_text);
        nametext.setText(baseline.getName());

        x1text=(EditText)v.findViewById(R.id.X1_text);
        x1text.setText(StringUtils.coordTxt(baseline.pOne.getX()));
        textfields.add(x1text);

        y1text=(EditText)v.findViewById(R.id.Y1_text);
        y1text.setText(StringUtils.coordTxt(baseline.pOne.getY()));
        textfields.add(y1text);

        h1text=(EditText)v.findViewById(R.id.H1_text);
        h1text.setText(StringUtils.coordTxt(baseline.pOne.getH()));
        textfields.add(h1text);

        x2text=(EditText)v.findViewById(R.id.X2_text);
        x2text.setText(StringUtils.coordTxt(baseline.pTwo.getX()));
        textfields.add(x2text);

        y2text=(EditText)v.findViewById(R.id.Y2_text);
        y2text.setText(StringUtils.coordTxt(baseline.pTwo.getY()));
        textfields.add(y2text);

        h2text=(EditText)v.findViewById(R.id.H2_text);
        h2text.setText(StringUtils.coordTxt(baseline.pTwo.getH()));
        textfields.add(h2text);

        viewX1=(TextView)v.findViewById(R.id.view_X1);
        viewX1.setVisibility(View.INVISIBLE);
        views.put(x1text,viewX1);

        viewY1=(TextView)v.findViewById(R.id.view_Y1);
        viewY1.setVisibility(View.INVISIBLE);
        views.put(y1text,viewY1);

        viewH1=(TextView)v.findViewById(R.id.view_H1);
        viewH1.setVisibility(View.INVISIBLE);
        views.put(h1text,viewH1);

        viewX2=(TextView)v.findViewById(R.id.view_X2);
        viewX2.setVisibility(View.INVISIBLE);
        views.put(x2text,viewX2);

        viewY2=(TextView)v.findViewById(R.id.view_Y2);
        viewY2.setVisibility(View.INVISIBLE);
        views.put(y2text,viewY2);

        viewH2=(TextView)v.findViewById(R.id.view_H2);
        viewH2.setVisibility(View.INVISIBLE);
        views.put(h2text,viewH2);

        saveBtn=(Button)v.findViewById(R.id.save_bl);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
        return v;
    }
    private void updateData(){

        baseline.setName(nametext.getText().toString());

        baseline.pOne.setX(updateCoord(x1text));
        baseline.pOne.setY(updateCoord(y1text));
        baseline.pOne.setH(updateCoord(h1text));

        baseline.pTwo.setX(updateCoord(x2text));
        baseline.pTwo.setY(updateCoord(y2text));
        baseline.pTwo.setH(updateCoord(h2text));


    }
    private Double updateCoord(EditText editText){
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
