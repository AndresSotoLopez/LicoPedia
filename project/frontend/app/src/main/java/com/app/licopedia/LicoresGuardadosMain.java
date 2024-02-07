package com.app.licopedia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

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
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.reciclerId);

        List<Coctel> coctel = new ArrayList<>();
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan0"));
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan1"));
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan2"));
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan3"));
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan4"));
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan5"));
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan6"));
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan7"));
        coctel.add(new Coctel(R.drawable.coctel, "Cosmopolitan8"));

        coctelAdapter = new CoctelAdapter(coctel, this);
        recyclerView.setAdapter(coctelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}