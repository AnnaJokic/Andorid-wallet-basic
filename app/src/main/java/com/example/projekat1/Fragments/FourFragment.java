package com.example.projekat1.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projekat1.R;
import com.example.projekat1.adapter.KategorijaAdapter;
import com.example.projekat1.model.Kategorija;
import com.example.projekat1.util.Util;
import com.example.projekat1.viewmodel.MainViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FourFragment extends Fragment {
    public MainViewModel mainViewModel;
    private KategorijaAdapter mKategorijaAdapter;

    public static FourFragment newInstance(){
        return new FourFragment();

    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup conteiner, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment4,conteiner,false);
        EditText editText=view.findViewById(R.id.et_frag4);
        Button button=view.findViewById(R.id.btn_frag4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();
                Kategorija  kategorija=new Kategorija(Util.generateId(),s);
                mainViewModel.addKategorija(kategorija);
            }
        });


        RecyclerView recyclerView=view.findViewById(R.id._rv_main_list_frag4);
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mKategorijaAdapter=new KategorijaAdapter();
        recyclerView.setAdapter(mKategorijaAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.getKategorijaLiveData().observe(getViewLifecycleOwner(), new Observer<List<Kategorija>>() {
            @Override
            public void onChanged(List<Kategorija> kategorijas) {
                mKategorijaAdapter.setData(kategorijas);
            }
        });
    }
}