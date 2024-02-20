package com.app.licopedia;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class LicoViewHolder extends RecyclerView.ViewHolder {
    private LicoData licoData;
    private TextView licoName;
    private ImageView licoImage;
    public LicoViewHolder(@NonNull View itemView) {
        super(itemView);
        licoImage = (ImageView) itemView.findViewById(R.id.image_view_holder);
        licoName = (TextView) itemView.findViewById(R.id.text_view_holder);
    }

    public void bindDino(LicoData licoData, Activity activity) {
        licoName.setText(licoData.getName());

        // Cargar la imagen con Glide
        Glide.with(itemView)
                .load(licoData.getImageUrl())
                .into(licoImage);
    }
}
