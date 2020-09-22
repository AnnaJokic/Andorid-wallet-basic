package com.example.projekat1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projekat1.R;
import com.example.projekat1.model.Kategorija;
import com.example.projekat1.util.KategorijaDiffCallback;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class KategorijaAdapter extends RecyclerView.Adapter<KategorijaAdapter.KategorijaHolder> {

    private List<Kategorija> mDataSet;

    public KategorijaAdapter(){
        mDataSet=new ArrayList<>();

    }

    @NonNull
    @Override
    public KategorijaAdapter.KategorijaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item3,parent,false);
        return new KategorijaHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull KategorijaAdapter.KategorijaHolder holder, int position) {
        Kategorija kategorija=mDataSet.get(position);
        holder.text.setText(kategorija.getName());


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

    public class KategorijaHolder extends RecyclerView.ViewHolder {

        TextView text;


        public KategorijaHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.list_item3_text);
        }
    }
}
