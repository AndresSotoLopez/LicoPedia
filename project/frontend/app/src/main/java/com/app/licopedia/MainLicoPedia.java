package com.app.licopedia;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainLicoPedia extends AppCompatActivity {
    private Context main_context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_licopedia);

        BottomNavigationView bottomNavigationView =findViewById(R.id.navigation_view);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(main_context, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recyclerRecomendaciones = (RecyclerView) findViewById(R.id.recycler_recomendaciones);
        recyclerRecomendaciones.setLayoutManager(layoutManager);


    }


}