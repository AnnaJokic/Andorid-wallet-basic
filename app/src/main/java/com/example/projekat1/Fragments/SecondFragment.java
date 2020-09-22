package com.example.projekat1.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projekat1.R;

import com.example.projekat1.activity.DetailActivity;
import com.example.projekat1.activity.MainActivity;
import com.example.projekat1.adapter.ProizvodAdapter;

import com.example.projekat1.model.Kategorija;
import com.example.projekat1.model.Proizvod;
import com.example.projekat1.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.app.Activity.RESULT_OK;

public class SecondFragment extends Fragment {

    public MainViewModel mainViewModel;
    private ProizvodAdapter proizvodAdapter;
    private List<Proizvod> proizvods;
    private Proizvod temp;
    private boolean flag=true;

    public static SecondFragment newInstance(){
        return new SecondFragment();

    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup conteiner, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment2,conteiner,false);
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        proizvodAdapter=new ProizvodAdapter();


        TextView textView= view.findViewById(R.id.frag2_search);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mainViewModel.setFilterName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        RecyclerView recyclerView=view.findViewById(R.id.frag2_rec_list);
        GridLayoutManager layoutManager=new GridLayoutManager(view.getContext(),1);
        recyclerView.setLayoutManager(layoutManager);

        Spinner spinner=view.findViewById(R.id.frag2_spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1,initList());
        spinner.setAdapter(adapter);

        Button button=view.findViewById(R.id.frag2_add_cat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=spinner.getSelectedItem().toString();
                mainViewModel.setFilterCategory(s);

            }
        });

        mainViewModel.getProizvodiLiveData().observe(this,new Observer<List<Proizvod>>() {
            @Override
            public void onChanged(List<Proizvod> contacts) {
                proizvods=new ArrayList<>(contacts);
                proizvodAdapter.setData(proizvods);
            }
        });

        mainViewModel.getFilterCategory().observe(this, new Observer<List<Proizvod>>() {
            @Override
            public void onChanged(List<Proizvod> proizvodi) {

                proizvodAdapter.setData(proizvodi);
            }
        });

        proizvodAdapter.setOnItemRemoveCallback(new ProizvodAdapter.OnItemRemoveCallback() {
            @Override
            public void onItemRemove(int position) {
                List<Proizvod> lista=mainViewModel.getProizvodi();
                Proizvod p=lista.get(position);
                String kat=p.getPkategorija();



                mainViewModel.removeItem(position);
            }
        } );


        Intent intent=new Intent(this.getActivity(),DetailActivity.class);
        proizvodAdapter.setmOnItemDetailCallback(new ProizvodAdapter.OnItemDetailCallback() {
            @Override
            public void onItemSelect(int position) {
                List<Proizvod> p=mainViewModel.getProizvodi();
                Proizvod novi=p.get(position);
                temp=novi;

                intent.putExtra("id",novi.getPid());
                intent.putExtra("name",novi.getpName());
                intent.putExtra("cena",novi.getpName());
                intent.putExtra("kategorija",novi.getPkategorija());
                intent.putExtra("pozicija",position);

                startActivityForResult(intent,1);


            }
        });



        recyclerView.setAdapter(proizvodAdapter);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.getProizvodiLiveData().observe(getViewLifecycleOwner(), new Observer<List<Proizvod>>() {
            @Override
            public void onChanged(List<Proizvod> kategorijas) {
                proizvodAdapter.setData(kategorijas);
            }
        });
    }

    private List<String> initList(){
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        List<String> nazivi=new ArrayList<>();

        for(Kategorija kat: mainViewModel.getKategorijeObicne()){
            nazivi.add(kat.getName());
        }


        return nazivi;

    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
           flag=true;
            mainViewModel.removeItem1(temp);
        }
    }


}
