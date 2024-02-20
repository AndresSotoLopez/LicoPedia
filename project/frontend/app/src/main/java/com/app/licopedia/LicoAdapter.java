package com.app.licopedia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LicoAdapter extends RecyclerView.Adapter<LicoViewHolder> {
    private List<LicoData> licoDataList;
    private Activity activity;

    public LicoAdapter(List<LicoData> licoDataList, Activity activity, MainLicoPedia mainLicoPedia) {
        this.licoDataList = licoDataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public LicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla la vista del ViewHolder desde el diseño prota_view_holder.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.licopedia_view_holder, parent, false);
        // Retorna un nuevo objeto ProtagonistasViewHolder con la vista inflada
        return new LicoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LicoViewHolder holder, int position) {
        // Obtiene los datos del protagonista en la posición especificada
        LicoData dataInPositionToBeRendered = licoDataList.get(position);
        // Muestra los datos en el ViewHolder utilizando el método showData
        holder.bindDino(dataInPositionToBeRendered, activity);
    }

    @Override
    public int getItemCount() {return licoDataList.size();}
}
