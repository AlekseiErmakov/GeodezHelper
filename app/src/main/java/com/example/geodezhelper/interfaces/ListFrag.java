package com.example.geodezhelper.interfaces;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geodezhelper.R;

import java.util.List;

public abstract class ListFrag extends Fragment {

    protected abstract void updateUI();
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    private abstract class MyDataHol extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public MyDataHol(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.view_item_lev_ref_list,parent,false));
        }

        public abstract void bind(MyData myData);
    }
    private abstract class MyDataAdapter extends RecyclerView.Adapter<MyDataHol>{
        private List<MyData> myDatas;
        public  MyDataAdapter(List<MyData> myDatas){
            this.myDatas=myDatas;
        }


        @Override
        public void onBindViewHolder(@NonNull MyDataHol holder, int position) {
            MyData myData = myDatas.get(position);
            holder.bind(myData);
        }
        @Override
        public int getItemCount() {
            return myDatas.size();
        }
    }
}
