package com.app.licopedia;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

public class LicoViewHolder extends RecyclerView.ViewHolder {
    private LicoData licoData;
    private ImageView licoImage;
    public LicoViewHolder(@NonNull View itemView) {
        super(itemView);
        //licoImage = itemView.findViewById(R.id.)

    }

    public void bindDino(LicoData licoData) {

        // Cargar la imagen con Glide
        Glide.with(itemView)
                .load(licoData.getImageUrl())
                .into(licoImage);

        this.licoData = licoData;
    }
}
