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

import com.example.geodezhelper.R;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.interfaces.forFrag.ItemFrag;
import com.example.geodezhelper.interfaces.forbeans.MyNivData;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;


public class FragItemLevRef extends ItemFrag {
    private EditText nameText, levelText;
    private TextView levelview;
    private TextView nameview;
    private Button saveBTN;
    private MyNivData myNivData;
    Map<EditText, TextView> views;
    private static final String ARG_LEVREF_ID = "lev_ref_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID levrefId = (UUID) getArguments().getSerializable(ARG_LEVREF_ID);
        myNivData = (MyNivData) DataLevRef.getInstance(getActivity()).getItem(levrefId);

    }

    public static FragItemLevRef newInstance(UUID levrefId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_LEVREF_ID, levrefId);
        FragItemLevRef fragment = new FragItemLevRef();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_item_level_refence, container, false);

        createEditText(v);
        createTextView(v);
        createButton(v);
        views = getViews();
        upDateView();

        return v;
    }

    private void createEditText(View v) {
        nameText = (EditText) v.findViewById(R.id.LR_name);
        levelText = (EditText) v.findViewById(R.id.LR_level);
    }

    private void createTextView(View v) {
        levelview = (TextView) v.findViewById(R.id.view_level);
        levelview.setVisibility(View.INVISIBLE);
        nameview = (TextView) v.findViewById(R.id.lr_view_name);
        nameview.setVisibility(View.INVISIBLE);
    }

    private void createButton(View v) {
        saveBTN = (Button) v.findViewById(R.id.save_LR);
        saveBTN.setOnClickListener(this);
    }

    public Map<EditText, TextView> getViews() {
        Map<EditText, TextView> views = new HashMap<>();
        views.put(nameText, nameview);
        views.put(levelText, levelview);
        return views;
    }

    private void upDateView() {
        String name = String.valueOf(myNivData.getName());
        String height = String.valueOf(myNivData.getHeight());
        if (!name.equals("null")) {
            nameText.setText(name);
        }
        if (!height.equals("null")) {
            levelText.setText(StringUtils.coordTxt(myNivData.getHeight()));
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.save_LR):
                updateData();
        }
    }

    @Override
    public void updateData() {
        myNivData.setName(chekName(nameText, views));
        myNivData.setHeight(chekDouble(levelText, views));
        if (myNivData.getName() == null && myNivData.getHeight() == null) {
            makeMyToast(R.string.toast_data_all_invalide);
        } else {
            makeMyToast(R.string.toast_data_update);
        }
    }
}



