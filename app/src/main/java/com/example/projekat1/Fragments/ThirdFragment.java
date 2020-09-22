package com.example.projekat1.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projekat1.R;
import com.example.projekat1.adapter.KategorijaAdapter;
import com.example.projekat1.adapter.PercentageAdapter;
import com.example.projekat1.adapter.ProizvodAdapter;
import com.example.projekat1.model.Kategorija;
import com.example.projekat1.model.Proizvod;
import com.example.projekat1.util.Util;
import com.example.projekat1.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ThirdFragment extends Fragment {
    public MainViewModel mainViewModel;
    private PercentageAdapter percentageAdapter;
    private List<Proizvod> proizvods;
    private List<Kategorija> kategorijas;
    List<Proizvod> lista2=new ArrayList<>();
    private ProizvodAdapter proizvodAdapter;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();

    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup conteiner, @Nullable Bundle savedInstanceState) {

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        View view = inflater.inflate(R.layout.fragment3, conteiner, false);
        TextView tx=view.findViewById(R.id.text_ispod_kruga);
        RecyclerView recyclerView = view.findViewById(R.id.frag3_rec_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        percentageAdapter = new PercentageAdapter();
        proizvodAdapter=new ProizvodAdapter();




        recyclerView.setAdapter(percentageAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        mainViewModel.getKategorijaLiveData().observe(getViewLifecycleOwner(), new Observer<List<Kategorija>>() {
            @Override
            public void onChanged(List<Kategorija> kategorijas) {

               percentageAdapter.setData(kategorijas);
            }


        });

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.getProizvodiLiveData().observe(getViewLifecycleOwner(), new Observer<List<Proizvod>>() {
            @Override
            public void onChanged(List<Proizvod> kategorijas) {
                proizvodAdapter.setData(kategorijas);
            }
        });
    }



}