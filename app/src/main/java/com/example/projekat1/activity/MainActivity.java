package com.example.projekat1.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projekat1.R;
import com.example.projekat1.adapter.SimplePagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }



    private void init(){
        ViewPager viewPager=findViewById(R.id.vp_main);
        SimplePagerAdapter simplePagerAdapter=new SimplePagerAdapter(getSupportFragmentManager(),this);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(simplePagerAdapter);
        TabLayout tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


}
