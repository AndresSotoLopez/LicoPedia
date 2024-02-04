package com.app.licopedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LicorAdapter extends RecyclerView.Adapter<LicorHolder> {
    private  LicorList LicorToShown;
    private LicorAdapter (LicorList licor){
        this.LicorToShown= licor;

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
        Licor dataForCell = this.LicorToShown.getLicor().get(position);
        holder.showLicor(dataForCell);

    }

    @Override
    public int getItemCount() {
        return this.LicorToShown.getLicor().size();
    }
}
