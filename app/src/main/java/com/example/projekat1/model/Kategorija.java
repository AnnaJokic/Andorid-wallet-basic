package com.example.projekat1.model;

import com.example.projekat1.util.Util;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class Kategorija {

    private int kid;
    private String kName;
    private int zbir;
    private List<Proizvod> proizvodi=new ArrayList<>();

    public Kategorija(int id,String nameList,List<Proizvod> listaProizvoda){
        kid=id;
        kName=nameList;
        proizvodi=listaProizvoda;
        zbir=0;
    }
    public Kategorija(int id,String name){
        kid=id;
        kName=name;
        zbir=0;
    }


    public void addProizvod(Proizvod proizvod)
    {
        proizvodi.add(proizvod);
    }

    public void removeProizvod(Proizvod proizvod)
    {
        proizvodi.remove(proizvod);
    }




    public void removeProizvor(Proizvod proizvod){
        proizvodi.remove(proizvod);
    }


    public int getZbir() {
       return zbir;
    }

    public void setZbir(List<Proizvod> proizvodi)
    {   Integer i1=0;
        for(Proizvod p:proizvodi){
            i1=i1+p.getpCena();
        }

        this.zbir = i1;
    }

    public int ukupno(Kategorija kat){
        Integer i1=0;
        if(kat.getProizvodi()!=null){
        for(Proizvod p: kat.getProizvodi()){
            i1=i1+p.getpCena();
        }}

        return i1;
    }



    public int getid(){
        return kid;
    }

    public void setid(int id){
        this.kid=id;
    }

    public String getName() {
        return kName;
    }

    public void setName(String name) {

        this.kName = name;
    }


    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }
}
