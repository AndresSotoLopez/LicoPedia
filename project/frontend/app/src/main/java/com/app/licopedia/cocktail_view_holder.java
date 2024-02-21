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
        textView = itemView.findViewById(R.id.textRecyclerView);
        Image = itemView.findViewById(R.id.img_dinosaur);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cocktailsDescription = cocktails.getDescription();
                Context context = view.getContext();
                /*
                Send the id and changes to the inforamtion of the dinosaur screen
                Intent intent = new Intent(context, );
                intent.putExtra("id", cocktailsId);
                context.startActivity(intent);


                */
            }
        });
    }
    public void showData(cocktails cocktails) {
        this.cocktails = cocktails;
        if (cocktails != null){
            textView.setText(cocktails.getName());
            Glide.with(itemView)
                    .load(cocktails.getImage())
                    .into(Image);
        } else {
            this.textView.setText("Unknown");
        }
    }

}
