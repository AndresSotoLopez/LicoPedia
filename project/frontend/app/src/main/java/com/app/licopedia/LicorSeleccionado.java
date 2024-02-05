package com.app.licopedia;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LicorSeleccionado extends Fragment {
    private Context context;
    private TextView licorLink;
    private ImageView licorImage;
    private RecyclerView recyclerView;
    private  Fragment fragment;

   /** @onAttach Vincula a la actividad que lo contiene**/
    public void onAttach(Context newContext){
        super.onAttach(newContext);  //ejecuta el fragmento se adjunta en la actividad
        this.context = newContext;
    }
/**@LicorSeleccionado permite crear y obtener instacia de la clase**/
    public static LicorSeleccionado newInstance(){
        return  new LicorSeleccionado();
    }

    /**@**/
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_licor_seleccionado, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        List<Licor> data  = new ArrayList<>();
        data.add(new Licor("sfasdfaf"));
        LicorAdapter myAdapter = new LicorAdapter(data,fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(myAdapter);
        return  view;
    }
}
