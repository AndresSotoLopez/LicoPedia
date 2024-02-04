package com.app.licopedia;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LicorHolder extends RecyclerView.ViewHolder {
     private TextView cellUrl;
     private  Licor licor;
    public LicorHolder(@NonNull View itemView) {
        super(itemView);
        cellUrl= itemView.findViewById(R.id.licorLink);
    }
    public void showLicor (Licor licor){
        this.cellUrl.setText(licor.getUrlLicor());
        this.licor=licor;
    }
}
