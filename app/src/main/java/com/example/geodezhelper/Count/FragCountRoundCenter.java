package com.example.geodezhelper.Count;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geodezhelper.ActivityMain;
import com.example.geodezhelper.R;
import com.example.geodezhelper.interfaces.forData.MyDataHolder;
import com.example.geodezhelper.interfaces.forFrag.ListFrag;
import com.example.geodezhelper.interfaces.forbeans.MyData;
import com.example.geodezhelper.interfaces.forbeans.MySimplePoint;
import com.example.geodezhelper.round.ActivityItemPointR;
import com.example.geodezhelper.round.ActivityListPointR;
import com.example.geodezhelper.round.CountInRound;
import com.example.geodezhelper.round.DataPointR;
import com.example.geodezhelper.round.FragListPointR;
import com.example.geodezhelper.round.RoundPoint;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class FragCountRoundCenter extends Fragment implements View.OnClickListener{
    private Button add;
    private Button count;
    private RecyclerView resView;
    private RoundPointsAdapter adapter;
    private List<MyData> myDatas;
    private TextView ViewResult;
    CountInRound countCenter;
    MyDataHolder myDataHolder;
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_count_round_center,container,false);
        myDataHolder = DataPointR.getInstance(getActivity());
        resView = (RecyclerView)view.findViewById(R.id.res_view_inside_count_round);
        resView.setLayoutManager(new LinearLayoutManager(getActivity()));
        createButtons(view);
        ViewResult = (TextView)view.findViewById(R.id.round_view_result);
        updateUI();
        countCenter = new CountInRound();
        return view;
    }
    public void updateUI(){
        myDatas = myDataHolder.getList();
        if (adapter == null){
            adapter = new RoundPointsAdapter(myDatas);
            resView.setAdapter(adapter);
        } else{
            adapter.notifyDataSetChanged();
        }
    }
    private void createButtons(View v){
        add = (Button)v.findViewById(R.id.add_pint);
        add.setOnClickListener(this);
        count = (Button)v.findViewById(R.id.count_round_count_btn);
        count.setOnClickListener(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    protected void goToActivity() {
        myDataHolder.addItem();
        MyData myData = myDataHolder.getLastItem();
        Intent intent = ActivityItemPointR.newIntent(getActivity(),myData.getId());
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.add_pint) :
                goToActivity();
                break;
            case (R.id.count_round_count_btn) :
                ViewResult.setText(count());
                break;
        }
    }
    public String count(){
        String result = "";
        List<MySimplePoint> simp = new ArrayList<>();
        for(MyData myData : myDatas){
            simp.add((MySimplePoint) myData);
        }
        if(simp.size()>0){
            result = countCenter.getResult(simp);
        }
        return result;
    }
    private class RoundPointsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private MyData myData;
        private TextView NameView;

        public RoundPointsHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.view_item_lev_ref_list,parent,false));
            NameView = (TextView)itemView.findViewById(R.id.lev_ref_name);

            itemView.setOnClickListener(this);
        }
        public void bind(MyData myData){
            this.myData = myData;
            NameView.setText(myData.getName());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ActivityItemPointR.newIntent(getActivity(),myData.getId());
            startActivity(intent);
        }
    }
    private class RoundPointsAdapter extends RecyclerView.Adapter<RoundPointsHolder>{
        private List<MyData> myDatas;

        public RoundPointsAdapter(List<MyData> myDatas){
            this.myDatas = myDatas;
        }
        @NonNull
        @Override
        public RoundPointsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RoundPointsHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RoundPointsHolder holder, int position) {
            MyData myData = myDatas.get(position);
            holder.bind(myData);
        }

        @Override
        public int getItemCount() {
            return myDatas.size();
        }



    }

}
