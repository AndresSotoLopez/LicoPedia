package com.app.licopedia;

import android.app.Activity;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoctelAdapter extends RecyclerView.Adapter<CoctelHolder> {
    private List<Coctel> allCoctel;
    private Activity activity;

    public CoctelAdapter(List<Coctel> allCoctel, Activity activity) {
        this.allCoctel = allCoctel;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CoctelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View coctelCell = inflater.inflate(R.layout.recycler_cell,parent, false);
        CoctelHolder cellHolder = new CoctelHolder(coctelCell);
        return cellHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoctelHolder holder, int position) {
    Coctel dataForThisCell = allCoctel.get(position);
    holder.showCoctel(dataForThisCell,activity);
    }

    @Override
    public int getItemCount() {
        return allCoctel.size();
    }
}
