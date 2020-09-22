package com.example.projekat1.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projekat1.R;
import com.example.projekat1.adapter.ProizvodAdapter;
import com.example.projekat1.model.Proizvod;
import com.example.projekat1.viewmodel.MainViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class DetailActivity extends AppCompatActivity {

    private static final String URL = "https://picsum.photos/1080/1920/?random";
    private ImageView slika;
    private TextView name;
    private TextView kategorija;
    private TextView cena;
    private TextView datum;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment5);
        init();
    }

    private void init() {
        randomImage();
        initTextComponents();
    }

    private void initTextComponents() {

        Intent intent=getIntent();
        Bundle extras = intent.getExtras();
        String name1 = extras.getString("name");
        Integer cena1 = extras.getInt("cena");
        Integer id1 = extras.getInt("id");
        String kategorija1 = extras.getString("kategorija");
        Integer pozicija1 = extras.getInt("pozicija");


        name = findViewById(R.id.ime_proizvoda_frag5);
        kategorija = findViewById(R.id.kategorija_proizvoda_frag5);
        cena = findViewById(R.id.iznos_frag5);
        datum = findViewById(R.id.datum_frag5);
        Button button=findViewById(R.id.btn_frag5);


        name.setText(name1);
        cena.setText("Placeno "+cena1+" dinara");
        kategorija.setText("Kategorija: "+kategorija1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent=new Intent();
                setResult(RESULT_OK,returnIntent);
                finish();

            }
        });


    }

    private void randomImage(){
        ImageView slika=findViewById(R.id.slika_frag5);

        Picasso.get()
                .load(URL)
                .into(slika);
    }

}

