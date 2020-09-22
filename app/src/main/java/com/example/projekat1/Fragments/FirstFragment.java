package com.example.projekat1.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projekat1.R;
import com.example.projekat1.adapter.KategorijaAdapter;
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

public class FirstFragment extends Fragment {
    public MainViewModel mainViewModel;



    public static FirstFragment newInstance(){
        return new FirstFragment();

    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup conteiner, @Nullable Bundle savedInstanceState){
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        View view=inflater.inflate(R.layout.fragment1,conteiner,false);

        EditText et1= view.findViewById(R.id.frag1_tx1);
        EditText et2=view.findViewById(R.id.frag1_tx2);
        Button button= view.findViewById(R.id.add_button);
        Spinner spinner=view.findViewById(R.id.frag1_spinner);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1,initList());
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=et1.getText().toString();
                String s2=et2.getText().toString();
                Integer int1=Integer.parseInt(s2);
                String kategorija=spinner.getSelectedItem().toString();
                List<Kategorija> list1=mainViewModel.getKategorijeObicne();

                for(Kategorija kat: list1){
                    if(kat.getName().equals(kategorija)){
                        kat.addProizvod(new Proizvod(Util.generateId(),s1,int1,kategorija));
                    }
                }

                mainViewModel.addProizvod(new Proizvod(Util.generateId(),s1,int1,kategorija));
                Toast.makeText(getContext(), "Expense ADDED " + s2, Toast.LENGTH_SHORT).show();


            }
        });





        return view;

    }

    private List<String> initList(){
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        List<String> nazivi=new ArrayList<>();

        for(Kategorija kat: mainViewModel.getKategorijeObicne()){
          nazivi.add(kat.getName());
        }


    return nazivi;

    }
}
