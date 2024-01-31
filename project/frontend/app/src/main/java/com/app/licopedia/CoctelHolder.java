package com.app.licopedia;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
public class CoctelHolder extends RecyclerView.ViewHolder {
    private  Coctel coctel;
    private ImageView image;
    private TextView name ;

    public CoctelHolder(@NonNull View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imageCoctel);
        name = (TextView) itemView.findViewById(R.id.nameCoctel);

    }

    public  void  showCoctel (Coctel coctel, Activity activity){
        this.name.setText(coctel.getName());
        Glide.with(itemView.getContext())
                .load(coctel.getImage())
                .into(image);
                this.coctel= coctel;
    }
}
