package com.app.licopedia;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

public class LicoresViewHolder extends RecyclerView.ViewHolder{
    private LicoresData allLicores;
    private TextView textView;
    private ImageView Image;
    public LicoresViewHolder(@NonNull View itemView) {

    super(itemView);
    textView = itemView.findViewById(R.id.textRecyclerView);
    Image = itemView.findViewById(R.id.img_licor);
        itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Context context = view.getContext();
                /*
                Send the id and changes to the information of the dinosaur screen
                Intent intent = new Intent(context, Licor_Seleccionado.class);
                intent.putExtra("id", cocktailsId);
                context.startActivity(intent);
                */
        }
    });
}
    public void bindLicoMethod(LicoresData allLicores, Activity activity) {
        this.allLicores = allLicores;
        if (allLicores != null){
            textView.setText(allLicores.getName());
            Glide.with(itemView)
                    .load(allLicores.getImageUrl())
                    .into(Image);
        } else {
            this.textView.setText("Unknown");
        }
    }
}
