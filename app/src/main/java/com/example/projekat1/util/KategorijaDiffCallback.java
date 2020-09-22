package com.example.projekat1.util;

import com.example.projekat1.model.Kategorija;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class KategorijaDiffCallback extends DiffUtil.Callback {

   private List<Kategorija> kOldList;
   private List<Kategorija> kNewList;


   public KategorijaDiffCallback(List<Kategorija> oldList,List<Kategorija> newList){
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
       Kategorija oldkategorija=kOldList.get(oldItemPosition);
       Kategorija newkategorija=kNewList.get(newItemPosition);
       return oldkategorija.getid()==newkategorija.getid();



    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Kategorija oldkategorija=kOldList.get(oldItemPosition);

        Kategorija newkategorija=kNewList.get(newItemPosition);

        return oldkategorija.getName().equals(newkategorija.getName()) && oldkategorija.getProizvodi().size()==newkategorija.getProizvodi().size();


   }
}
