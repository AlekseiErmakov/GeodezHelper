package com.example.geodezhelper.interfaces.forFrag;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.example.geodezhelper.R;
import com.example.geodezhelper.interfaces.forbeans.MyData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class ItemFrag extends Fragment implements ChekAble, UpdateAble, View.OnClickListener{
    @Override
    public Double chekDouble(EditText text, Map<EditText, TextView> views) {
        String resultText = text.getText().toString();
        TextView view = views.get(text);
        Double result = null;
        if (resultText.equals("")) {
            view.setText(R.string.alert_data_empty);
            view.setVisibility(View.VISIBLE);
        } else {
            try {
                result = Double.parseDouble(resultText);
                view.setVisibility(View.INVISIBLE);
            } catch (Exception ex){
                view.setText(R.string.alert_format_text);
                view.setVisibility(View.VISIBLE);
            }
        }
        return result;
    }

    @Override
    public Integer chekText(EditText text, Map<EditText, TextView> views) {
        String resultText = text.getText().toString();
        TextView view = views.get(text);
        Integer result = null;
        if (resultText.equals("")) {
            view.setText(R.string.alert_data_empty);
            view.setVisibility(View.VISIBLE);
        } else {
            try {
                result = Integer.parseInt(resultText);
                view.setVisibility(View.INVISIBLE);
            } catch (Exception ex){
                view.setText(R.string.alert_format_text);
                view.setVisibility(View.VISIBLE);
            }
        }
        return result;
    }

    @Override
    public String chekName(EditText text, Map<EditText, TextView> views) {
        String resultText = text.getText().toString();
        TextView view = views.get(text);
        if (resultText.equals("")) {
            view.setText(R.string.alert_data_empty);
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.INVISIBLE);
        }
        return resultText;
    }
    public void makeMyToast(int message){
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }
}
