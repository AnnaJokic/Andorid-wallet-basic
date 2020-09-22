package com.example.projekat1.util;

import com.example.projekat1.model.Kategorija;
import com.example.projekat1.model.Proizvod;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class ProizvodDiffCallback  extends DiffUtil.Callback {

        private List<Proizvod> kOldList;
        private List<Proizvod> kNewList;


        public ProizvodDiffCallback(List<Proizvod> oldList,List<Proizvod> newList){
            kOldList=oldList;
            kNewList=newList;
        }


        @Override
        public int getOldListSize() {
            return kOldList.size();
        }

        @Override
        public int getNewListSize() {
            return kNewList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            Proizvod oldproizvod=kOldList.get(oldItemPosition);
            Proizvod newproizvod=kNewList.get(newItemPosition);
            return oldproizvod.getPid()==newproizvod.getPid();



        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            Proizvod oldproizvod=kOldList.get(oldItemPosition);
            Proizvod newproizvod=kNewList.get(newItemPosition);
            return oldproizvod.getpName().equals(newproizvod.getpName());


        }

}
