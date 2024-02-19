package com.app.licopedia;

import android.content.Context;
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
        licoImage = itemView.findViewById(R.id.image_view_holder);
        licoName = itemView.findViewById(R.id.text_view_holder);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                // Aquí puedes agregar lógica para manejar el clic en el elemento del RecyclerView
            }
        });
    }

    public void bindDino(LicoData licoData) {
        this.licoName.setText(licoData.getName());

        // Cargar la imagen con Glide
        Glide.with(itemView)
                .load(licoData.getImageUrl())
                .into(licoImage);
    }
}
