package com.example.geodezhelper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;


public class CardContentFragment extends Fragment implements View.OnClickListener {
    EditText RpHeight,RpRepot,PointReport;
    Button CountPointHeight;
    TextView Result,RphAlert,RprAlert,PrAlert;
    private static final int thousand =1000;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_content,container,false);

        RpHeight= (EditText)view.findViewById(R.id.RpHeight1);
        RpRepot = (EditText)view.findViewById(R.id.RpReport1);
        PointReport = (EditText)view.findViewById(R.id.PointReport1);
        CountPointHeight =(Button)view.findViewById(R.id.count_point_height);
        Result =(TextView)view.findViewById(R.id.result_Point_height);
        RphAlert=(TextView)view.findViewById(R.id.view_HeightRpReport);
        RprAlert=(TextView)view.findViewById(R.id.view_RpReport1);
        PrAlert=(TextView)view.findViewById(R.id.view_Report_Point);
        RphAlert.setVisibility(View.INVISIBLE);
        RprAlert.setVisibility(View.INVISIBLE);
        PrAlert.setVisibility(View.INVISIBLE);

        CountPointHeight.setOnClickListener(this);
        Result.setVisibility(View.INVISIBLE);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.count_point_height:
                Result.setText(String.format(Locale.ENGLISH,"%.3f",countHeiht()));
                Result.setVisibility(View.VISIBLE);
                break;
        }
    }
    public Double countHeiht(){

           double rpH = myParseDouble(RpHeight,RphAlert);
           double rpR = (double)myParseInteger(RpRepot,RprAlert)/(double)thousand;
           double pR = (double)myParseInteger(PointReport,PrAlert)/(double)thousand;
           return rpH+rpR-pR;
    }
    public double myParseDouble(EditText editText,TextView view){
        view.setVisibility(View.INVISIBLE);
        String string = editText.getText().toString();
        string=string.replaceAll(",",".");
        double result =0;
        if (string.equals("")){
            view.setVisibility(View.VISIBLE);
        }else {
            try {
                result=Double.parseDouble(string);
            }catch (NumberFormatException ex){
                view.setVisibility(View.VISIBLE);

            }
        }
        return result;
    }
    public int myParseInteger(EditText editText,TextView view){
        view.setVisibility(View.INVISIBLE);
        String string = editText.getText().toString();
        int result =0;
        if (string.equals("")){
            view.setVisibility(View.VISIBLE);
        }else {
            try {
            result=Integer.parseInt(string);

            }catch (NumberFormatException ex){
                view.setVisibility(View.VISIBLE);

            }
        }
        return result;
    }



}
