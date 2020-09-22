package com.example.projekat1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projekat1.R;
import com.example.projekat1.model.Proizvod;
import com.example.projekat1.util.ProizvodDiffCallback;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ProizvodAdapter extends RecyclerView.Adapter<ProizvodAdapter.ProizvodHolder> {

    private OnItemDetailCallback mOnItemDetailCallback;
    private OnItemRemoveCallback mOnItemRemoveCallback;


    private List<Proizvod> mDataSet;

        public ProizvodAdapter(){
            mDataSet=new ArrayList<>();

        }

        @NonNull
        @Override
        public  ProizvodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            View view=inflater.inflate(R.layout.rec_list_item,parent,false);
            return new ProizvodHolder(view);

        }


        @Override
        public void onBindViewHolder(@NonNull ProizvodHolder holder, int position) {
            Proizvod proizvod=mDataSet.get(position);
            holder.text1.setText(proizvod.getpName());
            Integer i1=proizvod.getpCena();
            String s1=i1.toString();
            holder.text3.setText(s1);
            holder.text4.setText(proizvod.getPkategorija());


        }

        @Override
        public int getItemCount() {
            return mDataSet.size();
        }

        public void setData(List<Proizvod> proizvodi){
            ProizvodDiffCallback callback=new ProizvodDiffCallback(mDataSet,proizvodi);
            DiffUtil.DiffResult result=DiffUtil.calculateDiff(callback);
            mDataSet.clear();
            mDataSet.addAll(proizvodi);
            result.dispatchUpdatesTo(this);
        }

        public class ProizvodHolder extends RecyclerView.ViewHolder {

            TextView text1;
            TextView text2;
            TextView text3;
            TextView text4;
            Button remove;
            Button details;
            Button remove2;



            public ProizvodHolder(@NonNull View itemView) {
                super(itemView);
                text1=itemView.findViewById(R.id.frag2_1);
                text2=itemView.findViewById(R.id.frag2_2);
                text3=itemView.findViewById(R.id.frag2_3);
                text4=itemView.findViewById(R.id.frag2_4);

                remove = itemView.findViewById(R.id.frag2_but_remove);
                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            if (mOnItemRemoveCallback != null) {
                                mOnItemRemoveCallback.onItemRemove(position);
                            }
                        }
                    }
                });


                details = itemView.findViewById(R.id.frag2_but_details);
                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            if (mOnItemDetailCallback != null) {
                                mOnItemDetailCallback.onItemSelect(position);
                            }
                        }
                    }
                });


            }
        }



    public void setmOnItemDetailCallback(OnItemDetailCallback onItemDetailCallback){
        mOnItemDetailCallback = onItemDetailCallback;
    }

    public void setOnItemRemoveCallback (OnItemRemoveCallback onItemRemoveCallback) {
        mOnItemRemoveCallback = onItemRemoveCallback;
    }

    // Callback we use when user clicks on remove
    public interface OnItemRemoveCallback {
        void onItemRemove(int position);
    }

    //Callback we use when user click on avatar avatarImage
    public interface OnItemDetailCallback {
        void onItemSelect(int position);
    }
    }



