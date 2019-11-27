package com.example.geodezhelper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;


public class FragItemLevRef extends Fragment {
    EditText nameText,levelText;
    TextView levelview;
    Button saveBTN;
    private NivPoint nivPoint;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID nivpointId = (UUID)getActivity().getIntent()
                .getSerializableExtra(ActivityItemLevRef.EXTRA_LEV__REF_ID);
        nivPoint=DataLevRef.getInstance(getActivity()).getLevRef(nivpointId);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_level_refence,container,false);

        nameText = (EditText)v.findViewById(R.id.LR_name);
        levelText = (EditText)v.findViewById(R.id.LR_level);
        levelview = (TextView)v.findViewById(R.id.view_level);
        saveBTN = (Button)v.findViewById(R.id.save_LR);



        return v;
    }
}



