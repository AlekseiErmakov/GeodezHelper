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
import android.widget.Toast;

import com.example.geodezhelper.Pojo.Point;
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
    public void onCreate(Bundle savedInstanceState) {
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

        x1text=(EditText)v.findViewById(R.id.X1_text);


        textfields.add(x1text);

        y1text=(EditText)v.findViewById(R.id.Y1_text);

        textfields.add(y1text);

        h1text=(EditText)v.findViewById(R.id.H1_text);

        textfields.add(h1text);

        x2text=(EditText)v.findViewById(R.id.X2_text);

        textfields.add(x2text);

        y2text=(EditText)v.findViewById(R.id.Y2_text);

        textfields.add(y2text);

        h2text=(EditText)v.findViewById(R.id.H2_text);

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
        if (baseline.getpOne()!=null && baseline.getpTwo()!=null){
            nametext.setText(baseline.getName());
            x1text.setText(StringUtils.coordTxt(baseline.getpOne().getX()));
            y1text.setText(StringUtils.coordTxt(baseline.getpOne().getY()));
            h1text.setText(StringUtils.coordTxt(baseline.getpOne().getH()));
            x2text.setText(StringUtils.coordTxt(baseline.getpTwo().getX()));
            y2text.setText(StringUtils.coordTxt(baseline.getpTwo().getY()));
            h2text.setText(StringUtils.coordTxt(baseline.getpTwo().getH()));
        }

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

        Point pointOne = new Point();
        pointOne.setX(updateCoord(x1text));
        pointOne.setY(updateCoord(y1text));
        pointOne.setH(updateCoord(h1text));

        Point pointTwo = new Point();
        pointTwo.setX(updateCoord(x2text));
        pointTwo.setY(updateCoord(y2text));
        pointTwo.setH(updateCoord(h2text));

        baseline.setpOne(pointOne);
        baseline.setpTwo(pointTwo);

        Toast.makeText(getActivity(), R.string.toast_data_update, Toast.LENGTH_SHORT).show();

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
