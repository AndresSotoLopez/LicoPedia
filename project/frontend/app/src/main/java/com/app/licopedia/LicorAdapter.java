package com.app.licopedia;

import android.app.ActionBar;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LicorAdapter extends RecyclerView.Adapter<LicorHolder> {
    private List <Licor> LicorToShown;
     private  Fragment fragment ;
  public LicorAdapter (List <Licor> licor, Fragment fragment){
        this.LicorToShown= licor;
        this.fragment=fragment;
    }
    @NonNull
    @Override
    public LicorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View cellView = inflater.inflate(R.layout.web_links, parent,false);
        LicorHolder cellHolder  = new LicorHolder(cellView);
        return cellHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LicorHolder holder, int position) {
        Licor dataForCell = LicorToShown.get(position);
        holder.showLicor(dataForCell);

    }

    @Override
    public int getItemCount() {
        return LicorToShown.size();
    }
}
