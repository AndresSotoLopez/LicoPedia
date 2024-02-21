package com.app.licopedia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LicoresAdapter extends RecyclerView.Adapter<LicoresViewHolder>{
    private List<LicoresData> allLicores;
    private Activity activity;

    public LicoresAdapter(List<LicoresData> allLicores, Activity activity) {
        this.allLicores = allLicores;
        this.activity = activity;
    }

    @NonNull
    @Override
    public LicoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla la vista del ViewHolder desde el diseño prota_view_holder.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.licores_view_holder, parent, false);
        // Retorna un nuevo objeto ProtagonistasViewHolder con la vista inflada
        return new LicoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LicoresViewHolder holder, int position) {
        // Obtiene los datos del protagonista en la posición especificada
        LicoresData dataInPositionToBeRendered = allLicores.get(position);
        // Muestra los datos en el ViewHolder utilizando el método showData
        holder.bindLicoMethod(dataInPositionToBeRendered, activity);
    }

    @Override
    public int getItemCount() {return allLicores.size();}
}
