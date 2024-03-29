package com.app.licopedia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;

public class LicoresGuardadosMain extends AppCompatActivity {

    private CoctelList coctel;
     RecyclerView recyclerView;
    private CoctelAdapter coctelAdapter;
    private RequestQueue queue;

    private Button homeButton;
    private Context context;

    public void setNewsList(CoctelList coctel) {
        this.coctel = coctel;
        recyclerView.setAdapter(coctelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public CoctelList getCoctel() {
        return coctel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.licores_guardados_main);
        recyclerView = findViewById(R.id.reciclerId);



         /**  * @param actionBar es para la flecha del retun**/
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);


        List<Coctel> coctel = new ArrayList<>();
        coctel.add(new Coctel(R.drawable.cosmopolitan, "Cosmopolitan"));
        coctel.add(new Coctel(R.drawable.agua_de_valencia, "Agua de Valencia"));
        coctel.add(new Coctel(R.drawable.bloody_mary, "Bloody Mary"));
        coctel.add(new Coctel(R.drawable.margarita, "Margarita"));
        coctel.add(new Coctel(R.drawable.mojito, "Mojito"));
        coctel.add(new Coctel(R.drawable.rebujito, "Rebujito"));
        coctel.add(new Coctel(R.drawable.sex_on_the_beach, "Sex on the beach"));


        coctelAdapter = new CoctelAdapter(coctel, this);
        recyclerView.setAdapter(coctelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}