package com.example.geodezhelper.LR;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.R;

import java.util.Locale;
import java.util.UUID;


public class FragItemLevRef extends Fragment implements View.OnClickListener{
    EditText nameText,levelText;
    TextView levelview;
    Button saveBTN;
    private NivPoint nivPoint;
    private static final String ARG_LEVREF_ID = "lev_ref_id";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID levrefId = (UUID) getArguments().getSerializable(ARG_LEVREF_ID);
        nivPoint=DataLevRef.getInstance(getActivity()).getLevRef(levrefId);

    }
    public static FragItemLevRef newInstance(UUID levrefId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_LEVREF_ID,levrefId);
        FragItemLevRef fragment = new FragItemLevRef();
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_level_refence,container,false);

        nameText = (EditText)v.findViewById(R.id.LR_name);
        nameText.setText(nivPoint.getName());
        levelText = (EditText)v.findViewById(R.id.LR_level);
        levelText.setText(String.format(Locale.ENGLISH,"%.3f",nivPoint.getHeight()));
        levelview = (TextView)v.findViewById(R.id.view_level);
        levelview.setVisibility(View.INVISIBLE);
        saveBTN = (Button)v.findViewById(R.id.save_LR);
        saveBTN.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        int command = v.getId();
        switch (command){
            case(R.id.save_LR):
                updatedata();
        }
    }
    public void updatedata(){
        nivPoint.setName(String.valueOf(nameText.getText()));
        double elevation;
        try {
            elevation = Double.parseDouble(String.valueOf(levelText.getText()));
            nivPoint.setHeight(elevation);
            levelview.setVisibility(View.INVISIBLE);
            Toast.makeText(getActivity(), R.string.toast_data_update, Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            levelview.setVisibility(View.VISIBLE);
        }
    }
}



