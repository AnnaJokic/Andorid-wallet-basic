package com.example.projekat1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projekat1.R;
import com.example.projekat1.model.Kategorija;
import com.example.projekat1.util.KategorijaDiffCallback;
import com.example.projekat1.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PercentageAdapter extends RecyclerView.Adapter<PercentageAdapter.PercentageHolder> {

    private List<Kategorija> mDataSet;
    private MainViewModel mainViewModel;


    public PercentageAdapter(){
        mDataSet=new ArrayList<>();
    }

    @NonNull
    @Override
    public PercentageAdapter.PercentageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item2,parent,false);
        return new PercentageHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PercentageAdapter.PercentageHolder holder, int position) {

        Kategorija kategorija=mDataSet.get(position);
        holder.text.setText(kategorija.getName());
        Integer ukupno=kategorija.ukupno(kategorija);
        holder.text1.setText(ukupno.toString());

    }



    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public void setData(List<Kategorija> kategorije){
        KategorijaDiffCallback callback=new KategorijaDiffCallback(mDataSet,kategorije);
        DiffUtil.DiffResult result=DiffUtil.calculateDiff(callback);
        mDataSet.clear();
        mDataSet.addAll(kategorije);
        result.dispatchUpdatesTo(this);
    }




    public class PercentageHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView text1;

        public PercentageHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.list_item2_naziv);
            text1=itemView.findViewById(R.id.list_item2_cena);

        }
    }
}
