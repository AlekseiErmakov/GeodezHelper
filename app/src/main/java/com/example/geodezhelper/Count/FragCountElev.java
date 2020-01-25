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

import com.example.geodezhelper.BL.ActivityListBL;
import com.example.geodezhelper.LR.ActivityListLevRef;
import com.example.geodezhelper.LR.DataLevRef;
import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.R;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.interfaces.MyDataHolder;
import com.example.geodezhelper.interfaces.MyNivData;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;


public class FragCountElev extends Fragment implements View.OnClickListener {
    private int chooseMethod=1;
    EditText RpHeight,RpRepot,PointReport;
    Button CountPointHeight;
    Button chooseLevRef;
    TextView Title,ResultText,Result,RphAlert,RprAlert,PrAlert;
    RadioButton FirstRB,SecondRB;
    TextInputLayout PointLayout;
    MyDataHolder myDataHolder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_point_elevation,container,false);
        myDataHolder = DataLevRef.getInstance(getActivity());
        Title = (TextView)view.findViewById(R.id.text_view_HeightCount);

        RpHeight= (EditText)view.findViewById(R.id.RpHeight1);
        RpHeight.setText(useDefaultHeight());

        RpRepot = (EditText)view.findViewById(R.id.RpReport1);
        PointReport = (EditText)view.findViewById(R.id.PointReport1);

        CountPointHeight =(Button)view.findViewById(R.id.count_point_height);
        chooseLevRef = (Button)view.findViewById(R.id.choose_lr);

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
        chooseLevRef.setOnClickListener(this);
        Result.setVisibility(View.INVISIBLE);
        return view;
    }
    public String useDefaultHeight(){

        MyNivData myNivData = (MyNivData) myDataHolder.getCurItem();
        String result = "";
        if (myNivData != null){
            result = StringUtils.coordTxt( myNivData .getHeight());
        }
        return result;
    }

    public String countHeiht(int num){
        String result="";
        Double rpH = myParseDouble(RpHeight,RphAlert);
        Double rpR = myParseDouble(RpRepot,RprAlert);
        Double pR =  myParseDouble(PointReport,PrAlert);
        StringResult strResult = new StringResult();
            switch (num){
                case(1):
                    result = strResult.getPointEl(rpH,rpR,pR);
                    break;
                case(2):
                    result = strResult.getPointReport(rpH,rpR,pR);
                    break;
            }
           return result;
    }

    public Double myParseDouble(EditText editText,TextView view){
        view.setVisibility(View.INVISIBLE);
        String string = editText.getText().toString();
        string=string.replaceAll(",",".");
        Double result = null;
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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.count_point_height:
                Result.setText(countHeiht(chooseMethod));
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
            case (R.id.choose_lr):
                Intent intent2 = new Intent(getActivity(), ActivityListLevRef.class);
                startActivity(intent2);
                break;
        }


    }



}
