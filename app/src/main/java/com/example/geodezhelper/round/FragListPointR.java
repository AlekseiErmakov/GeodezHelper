package com.example.geodezhelper.round;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geodezhelper.ActivityMain;
import com.example.geodezhelper.BL.Baseline;
import com.example.geodezhelper.BL.FragmentListBL;
import com.example.geodezhelper.R;
import com.example.geodezhelper.interfaces.forActivity.SingleFragmentListActivity;
import com.example.geodezhelper.interfaces.forData.MyDataHolder;
import com.example.geodezhelper.interfaces.forFrag.ListFrag;
import com.example.geodezhelper.interfaces.forbeans.MyData;

import java.util.List;

public class FragListPointR extends ListFrag {
    private RecyclerView resView;
    private PointrAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle_view,container,false);
        resView = (RecyclerView)view.findViewById(R.id.recycle_view);
        resView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    protected void updateUI() {
        MyDataHolder myDataHolder = DataPointR.getInstance(getActivity());
        List<MyData> myData = myDataHolder.getList();
        if(adapter == null){
            adapter = new PointrAdapter(myData);
            resView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
    }
    private class PointrHolder extends ListFrag.MyDataHol{
        MyData myData;
        TextView nameView;
        public PointrHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater,parent);
            nameView = (TextView)itemView.findViewById(R.id.lev_ref_name);
            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
        }
        @Override
        public void bind(MyData myData) {
            this.myData = myData;
            nameView.setText(myData.getName());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ActivityItemPointR.newIntent(getActivity(),myData.getId());
            startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v){
            MyDataHolder myDataHolder = DataPointR.getInstance(getActivity());
            myDataHolder.setCurId(myData.getId());
            Intent intent = new Intent(getActivity(), ActivityMain.class);
            startActivity(intent);
            return true;
        }


    }
    private class PointrAdapter extends ListFrag.MyDataAdapter{
        public PointrAdapter(List<MyData> myDatas){
            super(myDatas);
        }
        @NonNull
        @Override
        public MyDataHol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new PointrHolder(layoutInflater,parent);
        }
    }
}
