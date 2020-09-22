package com.example.projekat1.model;

public class Proizvod {

    private int pid;
    private String pName;
    private int pCena;
    private String pkategorija;

    public Proizvod(int id,String name, int cena, String kategorija){
        pid=id;
        pName=name;
        pCena=cena;
        pkategorija=kategorija;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int id) {
        this.pid = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String Name) {
        this.pName = Name;
    }

    public int getpCena() {
        return pCena;
    }

    public void setpCena(int Cena) {
        this.pCena = Cena;
    }

    public String getPkategorija() {
        return pkategorija;
    }

    public void setPkategorija(String pkategorija) {
        this.pkategorija = pkategorija;
    }




}
