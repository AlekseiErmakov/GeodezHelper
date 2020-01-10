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

import java.util.List;
import java.util.Locale;


public class FragListLevRef extends Fragment {
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

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){
        DataLevRef dataLevRef = DataLevRef.getInstance(getActivity());
        List<NivPoint> levrefs = dataLevRef.getDataLevRef();
        if (levRefAdapter==null){
            levRefAdapter = new LevRefAdapter(levrefs);
            resView.setAdapter(levRefAdapter);
        }else {
            levRefAdapter.notifyDataSetChanged();
        }

    }
    private class LevRefHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        private TextView NameView;
        private TextView ElevView;
        private NivPoint MynivPoint;
        public LevRefHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.view_item_lev_ref_list,parent,false));
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            NameView =(TextView)itemView.findViewById(R.id.lev_ref_name);
            ElevView =(TextView)itemView.findViewById(R.id.lev_ref_elev);
        }
        public void bind(NivPoint nivPoint){
            MynivPoint=nivPoint;
            NameView.setText(MynivPoint.getName());
            ElevView.setText(StringUtils.coordTxt(MynivPoint.getHeight()));
        }

        @Override
        public void onClick(View v) {
            Intent intent = ActivityItemLevRef.newIntent(getActivity(), MynivPoint.getId());
            startActivity(intent);
        }
        @Override
        public boolean onLongClick(View v) {
            DataLevRef dataLevRef = DataLevRef.getInstance(getActivity());
            dataLevRef.setCurrentID(MynivPoint.getId());

            Intent intent2 = new Intent(getActivity(), ActivityMain.class);
            startActivity(intent2);
            return true;
        }

    }
    private class LevRefAdapter extends RecyclerView.Adapter<LevRefHolder>{
        private List<NivPoint> levrefs;
        public LevRefAdapter(List<NivPoint> nivPoints){
            levrefs=nivPoints;
        }

        @NonNull
        @Override
        public LevRefHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
           return new LevRefHolder(layoutInflater,parent);

        }

        @Override
        public void onBindViewHolder(@NonNull LevRefHolder holder, int position) {
            NivPoint levref = levrefs.get(position);
            holder.bind(levref);
        }

        @Override
        public int getItemCount() {
            return levrefs.size();
        }
    }
}