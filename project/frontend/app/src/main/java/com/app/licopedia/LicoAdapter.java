package com.app.licopedia;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LicoAdapter extends RecyclerView.Adapter<LicoViewHolder> {
    private List<LicoData> licoDataList;
    private LayoutInflater inflater;
    private Context context;
    private Activity activity;

    public LicoAdapter(List<LicoData> licoDataList, Activity activity, Context context) {
        this.licoDataList = licoDataList;
        this.activity = activity;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = inflater.inflate(R.layout.licopedia_view_holder, parent, false);
        return new LicoViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull LicoViewHolder holder, int position) {
        LicoData licoForThisCell = this.licoDataList.get(position);
        holder.bindDino(licoForThisCell);
    }

    @Override
    public int getItemCount() {return licoDataList.size();}
}
