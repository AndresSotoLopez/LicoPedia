package com.app.licopedia;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class cocktail_view_holder  extends RecyclerView.ViewHolder{
    private cocktails cocktails;
    private TextView textView;
    private ImageView Image;
    public cocktail_view_holder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_view);
        Image = itemView.findViewById(R.id.button_cocktail);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cocktailsId = cocktails.getId();
                String ImageUrl = cocktails.getImage();
                /*
                Send the id and changes to the inforamtion of the dinosaur screen
                Intent intent = new Intent(context, );
                intent.putExtra(VideoActivity.INTENT_DINOSAUR_ID, id);
                intent.putExtra(VideoActivity.INTENT_IMG_URL, ImageUrl);
                context.startActivity(intent);


                */
            }
        });
    }
    public void showData(cocktails dinosaur) {
        this.textView.setText(dinosaur.getName());
        Glide.with(itemView)
                .load(cocktails.getImage())
                .into(Image);

        this.cocktails = cocktails;
    }

}
