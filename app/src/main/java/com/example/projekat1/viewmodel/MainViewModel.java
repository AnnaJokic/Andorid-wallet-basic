package com.example.projekat1.viewmodel;

import com.example.projekat1.model.Kategorija;
import com.example.projekat1.model.Proizvod;
import com.example.projekat1.util.Util;

import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Kategorija>> kategorijaLiveData;
    List<Kategorija> kategorije;
    private MutableLiveData<List<Proizvod>> proizvodiLiveData;
    List<Proizvod> proizvodi;
    List<Proizvod> proizvodi1;
    List<Proizvod> proizvodi2;
    List<Proizvod> proizvodi3;



    private MutableLiveData<List<Proizvod>> filtredLiveData;


    public MainViewModel(){
        filtredLiveData=new MutableLiveData<>();

        kategorijaLiveData=new MutableLiveData<>();
        kategorije=new ArrayList<>();
        proizvodiLiveData=new MutableLiveData<>();
        proizvodi=new ArrayList<>();
        proizvodi1=new ArrayList<>();
        proizvodi2=new ArrayList<>();

        proizvodi3=new ArrayList<>();

       proizvodi2.add(new Proizvod(Util.generateId(),"proizvod2",200, "kategorije2"));



        proizvodi1.add(new Proizvod(Util.generateId(),"proizvod1",100, "kategorije1"));

        proizvodi3.add(new Proizvod(Util.generateId(),"proizvod3",300, "kategorije3"));



        proizvodi.addAll(proizvodi1);
        proizvodi.addAll(proizvodi2);

        Kategorija kategorije1=new Kategorija(Util.generateId(),"kategorije1",proizvodi1);
        Kategorija kategorije2=new Kategorija(Util.generateId(),"kategorije2",proizvodi2);
        Kategorija kategorije3=new Kategorija(Util.generateId(),"kategorije3",proizvodi3);

        kategorije.add(kategorije1);
        kategorije.add(kategorije2);
        kategorije.add(kategorije3);
        kategorijaLiveData.setValue(kategorije);



        proizvodiLiveData.setValue(proizvodi);

    }



    public void setFilterCategory(String filter){
        List<Proizvod> lista=new ArrayList<>();

        for(Proizvod p:proizvodi){
            if(p.getPkategorija().equals(filter)){
                lista.add(p);
            }
        }
        filtredLiveData.setValue(lista);

    }



    public void setFilterName(String filter){
        List<Proizvod> lista=new ArrayList<>();

        for(Proizvod p:proizvodi){
            if(p.getpName().startsWith(filter)){
                lista.add(p);
            }
        }
        filtredLiveData.setValue(lista);

    }




    public void removeItem(Integer position){
        Proizvod proizvod=proizvodi.get(position);
        proizvodi.remove(proizvod);
        proizvodiLiveData.setValue(proizvodi);

        kategorijaLiveData.setValue(kategorije);

    }

    public void removeItem1(Proizvod proizvod){
        proizvodi.remove(proizvod);
        proizvodiLiveData.setValue(proizvodi);

    }

    public int ukupno(Kategorija kat) {
        Integer i1=0;
        for(Proizvod p: kat.getProizvodi()){
            i1=i1+p.getpCena();

        }

        return i1;
    }



    public LiveData<List<Proizvod>> getFilterCategory(){
        return filtredLiveData;
    }


    public MutableLiveData<List<Proizvod>> getProizvodiLiveData() {
        return proizvodiLiveData;
    }

    public void setProizvodiLiveData(List<Proizvod> lista) {
        this.proizvodiLiveData.setValue(new ArrayList<>(lista));
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodiLiveData.setValue(new ArrayList<>(proizvodi));
    }

    public void addProizvod(Proizvod proizvod){
        proizvodi.add(proizvod);
        proizvodiLiveData.setValue(proizvodi);
    }

    public void addKategorija(Kategorija kategorija){
        kategorije.add(kategorija);
        kategorijaLiveData.setValue(kategorije);
    }

    public void setKategorije(List<Kategorija> kategorije){
        this.kategorijaLiveData.setValue(new ArrayList<>(kategorije));
    }

    public MutableLiveData<List<Kategorija>> getKategorijaLiveData(){
        return kategorijaLiveData;
    }

    public List<Kategorija> getKategorijeObicne(){
        return kategorije;
    }

}
