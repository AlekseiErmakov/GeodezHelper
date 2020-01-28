package com.example.geodezhelper.Count;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.geodezhelper.Count.count.CountHeight;
import com.example.geodezhelper.Count.count.CountInElev;
import com.example.geodezhelper.Count.count.CountReport;
import com.example.geodezhelper.LR.ActivityListLevRef;
import com.example.geodezhelper.LR.CurrentLR;
import com.example.geodezhelper.LR.DataLevRef;
import com.example.geodezhelper.R;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.interfaces.forData.MyDataHolder;
import com.example.geodezhelper.interfaces.forbeans.MyNivData;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;


public class FragCountElev extends Fragment implements View.OnClickListener {
    private int chooseMethod=1;
    EditText RpHeight,RpRepot,PointReport;
    Button CountPointHeight;
    Button chooseLevRef;
    TextView Title,ResultText,Result,RphAlert,RprAlert,PrAlert;
    RadioButton FirstRB,SecondRB;
    TextInputLayout PointLayout;
    MyNivData myNivData;
    Map<EditText,TextView> views;
    CountInElev count;
    CountHeight countHeight;
    CountReport countReport;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_point_elevation,container,false);
        createEditText(view);
        createTextView(view);
        createRadio(view);
        createButton(view);
        views = getViews();
        updateData();
        countHeight = new CountHeight();
        countReport = new CountReport();
        count = countHeight;
        return view;
    }
    private void createEditText(View view){
        RpHeight= (EditText)view.findViewById(R.id.RpHeight1);
        RpRepot = (EditText)view.findViewById(R.id.RpReport1);
        PointReport = (EditText)view.findViewById(R.id.PointReport1);
    }
    private void createTextView(View view){
        RphAlert=(TextView)view.findViewById(R.id.view_HeightRpReport);
        RphAlert.setVisibility(View.INVISIBLE);
        RprAlert=(TextView)view.findViewById(R.id.view_RpReport1);
        RprAlert.setVisibility(View.INVISIBLE);
        PrAlert=(TextView)view.findViewById(R.id.view_Report_Point);
        PrAlert.setVisibility(View.INVISIBLE);

        Result =(TextView)view.findViewById(R.id.result_Point_height);
        Result.setVisibility(View.INVISIBLE);
    }
    private void createButton(View view){
        CountPointHeight =(Button)view.findViewById(R.id.count_point_height);
        CountPointHeight.setOnClickListener(this);

        chooseLevRef = (Button)view.findViewById(R.id.choose_lr);
        chooseLevRef.setOnClickListener(this);
    }
    private void createRadio(View view){
        FirstRB=(RadioButton)view.findViewById(R.id.first);
        FirstRB.setOnClickListener(this);

        SecondRB=(RadioButton)view.findViewById(R.id.second);
        SecondRB.setOnClickListener(this);
    }
    private Map<EditText,TextView> getViews(){
        Map<EditText, TextView> views = new HashMap<>();
        views.put(RpHeight,RphAlert);
        views.put(RpRepot,RprAlert);
        views.put(PointReport,PrAlert);

        return views;
    }

    private void updateData(){
        myNivData = CurrentLR.getInstance();
        String result = "";
        if (myNivData.getHeight() != null){
            result = StringUtils.coordTxt( myNivData.getHeight());
        }
        RpHeight.setText(result);
    }

    public String countHeiht(){
        String result="";
        Double rpH = chekCoord(RpHeight);
        Double rpR = chekCoord(RpRepot);
        Double pR =  chekCoord(PointReport);
        result = count.getResult(rpH,rpR,pR);
        return result;
    }

    public Double chekCoord(EditText editText){
        Double result = null;
        String string = getAvailStr(editText);
        try {
            result = Double.parseDouble(string);
            views.get(editText).setVisibility(View.INVISIBLE);
            return result;
        } catch (Exception ex) {
            views.get(editText).setVisibility(View.VISIBLE);
            return result;
        }
    }
    private String getAvailStr(EditText text){
        String result = text.getText().toString();
        result = result.replaceAll(",",".");
        return result;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.count_point_height:
                Result.setText(countHeiht());
                Result.setVisibility(View.VISIBLE);
                break;
            case (R.id.first):
                Title.setText(R.string.Title_text_Count_Point_Height);
                PointLayout.setHint("Отчет по рейке на точке,мм");
                ResultText.setText(R.string.Result_point_M);
                count = countHeight;
                break;
            case (R.id.second):
                Title.setText(R.string.Title_text_Count_Point_Report);
                PointLayout.setHint("Отметка точки,м");
                ResultText.setText(R.string.Result_point_MM);
                count = countReport;
                break;
            case (R.id.choose_lr):
                Intent intent2 = new Intent(getActivity(), ActivityListLevRef.class);
                startActivity(intent2);
                break;
        }


    }



}
