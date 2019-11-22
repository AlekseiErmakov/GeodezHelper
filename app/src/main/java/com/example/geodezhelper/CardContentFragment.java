package com.example.geodezhelper;

import android.graphics.Point;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;


public class CardContentFragment extends Fragment implements View.OnClickListener {
    private int chooseMethod=1;
    EditText RpHeight,RpRepot,PointReport;
    Button CountPointHeight;
    TextView Title,ResultText,Result,RphAlert,RprAlert,PrAlert;
    RadioButton FirstRB,SecondRB;
    TextInputLayout PointLayout;
    private static final double thousand =1000;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_content,container,false);
        Title = (TextView)view.findViewById(R.id.text_view_HeightCount);

        RpHeight= (EditText)view.findViewById(R.id.RpHeight1);
        RpRepot = (EditText)view.findViewById(R.id.RpReport1);
        PointReport = (EditText)view.findViewById(R.id.PointReport1);

        CountPointHeight =(Button)view.findViewById(R.id.count_point_height);

        ResultText =(TextView)view.findViewById(R.id.text_result);
        Result =(TextView)view.findViewById(R.id.result_Point_height);
        RphAlert=(TextView)view.findViewById(R.id.view_HeightRpReport);
        RprAlert=(TextView)view.findViewById(R.id.view_RpReport1);
        PrAlert=(TextView)view.findViewById(R.id.view_Report_Point);

        FirstRB=(RadioButton)view.findViewById(R.id.first);
        FirstRB.setOnClickListener(this);
        SecondRB=(RadioButton)view.findViewById(R.id.second);
        SecondRB.setOnClickListener(this);

        RphAlert.setVisibility(View.INVISIBLE);
        RprAlert.setVisibility(View.INVISIBLE);
        PrAlert.setVisibility(View.INVISIBLE);
        PointLayout= (TextInputLayout)view.findViewById(R.id.point);


        CountPointHeight.setOnClickListener(this);
        Result.setVisibility(View.INVISIBLE);
        return view;
    }


    public String countHeiht(int num){
        String result="";
            switch (num){
                case(1):
                    double rpH = myParseDouble(RpHeight,RphAlert);
                    double rpR = myParseDouble(RpRepot,RprAlert)/thousand;
                    double pR =  myParseDouble(PointReport,PrAlert)/thousand;
                    result=String.format(Locale.ENGLISH,"%.3f",rpH+rpR-pR);
                    break;
                case(2):
                    rpH = myParseDouble(RpHeight,RphAlert);
                    rpR = myParseDouble(RpRepot,RprAlert)/(double)thousand;
                    pR =  myParseDouble(PointReport,PrAlert);
                    result=String.format(Locale.ENGLISH,"%.0f",(rpH+rpR-pR)*1000);
                    break;
            }
           return result;
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
                System.out.println(result);
            }catch (NumberFormatException ex){
                view.setVisibility(View.VISIBLE);
            }
        }
        return result;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.count_point_height:
                Result.setText(String.format(Locale.ENGLISH,"%s",countHeiht(chooseMethod)));
                Result.setVisibility(View.VISIBLE);
                break;
            case (R.id.first):
                Title.setText(R.string.Title_text_Count_Point_Height);
                PointLayout.setHint("Отчет по рейке на точке,мм");
                ResultText.setText(R.string.Result_point_M);
                chooseMethod=1;
                break;
            case (R.id.second):
                Title.setText(R.string.Title_text_Count_Point_Report);
                PointLayout.setHint("Отметка точки,м");
                ResultText.setText(R.string.Result_point_MM);
                chooseMethod=2;
                break;
        }


    }



}
