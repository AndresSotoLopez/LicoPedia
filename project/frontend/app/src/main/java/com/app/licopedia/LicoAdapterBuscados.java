package com.app.licopedia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LicoAdapterBuscados extends RecyclerView.Adapter<LicoViewHolderBuscados> {

    private List<LicoData> licoDataList;
    private Activity activity;

    public LicoAdapterBuscados(List<LicoData> licoDataList, Activity activity, MainLicoPedia mainLicoPedia) {
        this.licoDataList = licoDataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public LicoViewHolderBuscados onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.licopedia_view_holder, parent, false);
        return new LicoViewHolderBuscados(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LicoViewHolderBuscados holder, int position) {
        LicoData dataInPositionToBeRendered = licoDataList.get(position);
        holder.bindLicores(dataInPositionToBeRendered, activity);
    }

    @Override
    public int getItemCount() {
        return licoDataList.size();
    }
}