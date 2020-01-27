package com.example.geodezhelper.BL;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geodezhelper.ActivityMain;
import com.example.geodezhelper.R;
import com.example.geodezhelper.interfaces.forFrag.ListFrag;
import com.example.geodezhelper.interfaces.forbeans.MyData;
import com.example.geodezhelper.interfaces.forData.MyDataHolder;

import java.util.List;

public class FragmentListBL extends ListFrag {
    private RecyclerView resView;
    private BaseLineAdapter baseLineAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_recycle_view,container,false);
       resView = (RecyclerView)view.findViewById(R.id.recycle_view);
       resView.setLayoutManager(new LinearLayoutManager(getActivity()));
       updateUI();
       return view;
    }
    public void updateUI(){
        DataBaseLine dataBaseLine = DataBaseLine.getInstance(getActivity());
        List<MyData> myData = dataBaseLine.getList();

        if (baseLineAdapter==null){
            baseLineAdapter = new BaseLineAdapter(myData);
            resView.setAdapter(baseLineAdapter);
        }else {
            baseLineAdapter.notifyDataSetChanged();
        }
    }

    private class BaseLineHolder extends ListFrag.MyDataHol {
        private TextView NameView;
        private MyData myData;

        public BaseLineHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater,parent);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            NameView = (TextView)itemView.findViewById(R.id.lev_ref_name);

        }
        public void bind(MyData bl){
            myData = bl;
            NameView.setText(myData.getName());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ActivityItemBL.newIntent(getActivity(),myData.getId());
            startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v) {
            MyDataHolder myDataHolder = DataBaseLine.getInstance(getActivity());
            myDataHolder.setCurId(myData.getId());
            Intent intent2 = new Intent(getActivity(), ActivityMain.class);
            startActivity(intent2);
            return true;
        }
    }

    private class BaseLineAdapter extends ListFrag.MyDataAdapter {

        public BaseLineAdapter(List<MyData> myDatas) {
            super(myDatas);
        }
        @NonNull
        @Override
        public BaseLineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new BaseLineHolder(layoutInflater, parent);
        }

    }
}
