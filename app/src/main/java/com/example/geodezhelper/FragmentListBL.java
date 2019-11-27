package com.example.geodezhelper;

import android.app.Activity;
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

import java.util.List;

public class FragmentListBL extends Fragment {
    private RecyclerView resView;
    private BaseLineAdapter baseLineAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_recycle_view,container,false);
       resView = (RecyclerView)view.findViewById(R.id.recycle_view);
       resView.setLayoutManager(new LinearLayoutManager(getActivity()));
       updateUI();
       return view;
    }
    private void updateUI(){
        DataBaseLine dataBaseLine = DataBaseLine.getInstance(getActivity());
        List<Baseline> baselines = dataBaseLine.getBaselines();
        baseLineAdapter = new BaseLineAdapter(baselines);
        resView.setAdapter(baseLineAdapter);
    }
    private class BaseLineHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView BLnameView;
        private Baseline baseline;
        public BaseLineHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.item_base_line,parent,false));
            itemView.setOnClickListener(this);
            BLnameView = (TextView)itemView.findViewById(R.id.base_line_name);

        }
        public void bind(Baseline bl){
            baseline = bl;
            BLnameView.setText(baseline.getName());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), ActivityItemBL.class);
            startActivity(intent);
        }
    }
    private class BaseLineAdapter extends RecyclerView.Adapter<BaseLineHolder>{
        private List<Baseline> baselines;
        public BaseLineAdapter(List<Baseline> bls){
            baselines = bls;
        }

        @NonNull
        @Override
        public BaseLineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new BaseLineHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BaseLineHolder holder, int position) {
            Baseline baseline = baselines.get(position);
            holder.bind(baseline);
        }
        public int getItemCount(){
            return baselines.size();
        }
    }
}
