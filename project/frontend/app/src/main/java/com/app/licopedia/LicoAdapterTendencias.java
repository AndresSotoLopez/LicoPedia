package com.app.licopedia;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LicoAdapterTendencias  extends RecyclerView.Adapter<LicoViewHolderTendencias> {

    private List<LicoData> licoDataList;
    private Activity activity;

    public LicoAdapterTendencias(List<LicoData> licoDataList, Activity activity, MainLicoPedia mainLicoPedia) {
        this.licoDataList = licoDataList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public LicoViewHolderTendencias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.licopedia_view_holder, parent, false);
        return new LicoViewHolderTendencias(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LicoViewHolderTendencias holder, int position) {
        LicoData dataInPositionToBeRendered = licoDataList.get(position);
        holder.bindLico(dataInPositionToBeRendered, activity);
    }

    @Override
    public int getItemCount() {return licoDataList.size();}
}
