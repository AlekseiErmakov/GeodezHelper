package com.example.geodezhelper.LR;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geodezhelper.ActivityMain;
import com.example.geodezhelper.BL.ActivityListBL;
import com.example.geodezhelper.Pojo.NivPoint;
import com.example.geodezhelper.R;
import com.example.geodezhelper.StringUtils;
import com.example.geodezhelper.interfaces.ItemFrag;
import com.example.geodezhelper.interfaces.ListFrag;
import com.example.geodezhelper.interfaces.MyData;
import com.example.geodezhelper.interfaces.MyDataHolder;
import com.example.geodezhelper.interfaces.MyNivData;

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
    private class LevRefHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        private TextView NameView;
        private TextView ElevView;
        private MyNivData myNivData;
        public LevRefHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.view_item_lev_ref_list,parent,false));
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
            MyDataHolder myDataHolder = DataLevRef.getInstance(getActivity());
            myDataHolder.setCurrentId(myNivData.getId());

            Intent intent2 = new Intent(getActivity(), ActivityMain.class);
            startActivity(intent2);
            return true;
        }

    }
    private class LevRefAdapter extends RecyclerView.Adapter<LevRefHolder>{
        private List<MyData> myDatas;
        public LevRefAdapter(List<MyData> myDatas){
            this.myDatas=myDatas;
        }
        @NonNull
        @Override
        public LevRefHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
           return new LevRefHolder(layoutInflater,parent);

        }
        @Override
        public void onBindViewHolder(@NonNull LevRefHolder holder, int position) {
            MyData myData = myDatas.get(position);
            holder.bind(myData);
        }
        @Override
        public int getItemCount() {
            return myDatas.size();
        }
    }
}