package com.example.geodezhelper.LR;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geodezhelper.ActivityMain;
import com.example.geodezhelper.R;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.interfaces.forFrag.ListFrag;
import com.example.geodezhelper.interfaces.forbeans.MyData;
import com.example.geodezhelper.interfaces.forData.MyDataHolder;
import com.example.geodezhelper.interfaces.forbeans.MyNivData;

import java.util.List;



public class FragListLevRef extends ListFrag {
    private RecyclerView resView;
    private LevRefAdapter levRefAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle_view,container,false);
        resView =(RecyclerView)view.findViewById(R.id.recycle_view);
        resView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    public void updateUI(){
        DataLevRef dataLevRef = DataLevRef.getInstance(getActivity());
        List<MyData> myDatas = dataLevRef.getList();
        if (levRefAdapter==null){
            levRefAdapter = new LevRefAdapter(myDatas);
            resView.setAdapter(levRefAdapter);
        }else {
            levRefAdapter.notifyDataSetChanged();
        }

    }
    private class LevRefHolder extends MyDataHol{
        private TextView NameView;
        private TextView ElevView;
        private MyNivData myNivData;
        public LevRefHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater,parent);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            NameView =(TextView)itemView.findViewById(R.id.lev_ref_name);
            ElevView =(TextView)itemView.findViewById(R.id.lev_ref_elev);
        }
        public void bind(MyData myData){
            myNivData=(MyNivData) myData;
            NameView.setText(myNivData.getName());
            ElevView.setText(StringUtils.coordTxt(myNivData.getHeight()));
        }
        @Override
        public void onClick(View v) {
            Intent intent = ActivityItemLevRef.newIntent(getActivity(), myNivData.getId());
            startActivity(intent);
        }
        @Override
        public boolean onLongClick(View v) {
            CurrentLR currentLR = CurrentLR.getInstance();
            currentLR.setHeight(myNivData.getHeight());
            currentLR.setName(myNivData.getName());
            Intent intent2 = new Intent(getActivity(), ActivityMain.class);
            startActivity(intent2);
            return true;
        }
    }
    private class LevRefAdapter extends ListFrag.MyDataAdapter{
        public LevRefAdapter(List<MyData> myDatas){
            super(myDatas);
        }
        @NonNull
        @Override
        public LevRefHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
           return new LevRefHolder(layoutInflater,parent);
        }
    }
}