package com.app.licopedia;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class cocktails_activity extends Fragment {
    private Context context;
    private RecyclerView recyclerView;

    public static cocktails_activity newInstance(){
        return new cocktails_activity();
    }

    public void onAttach(Context newContext){
        super.onAttach(newContext);
        this.context = newContext;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.activity_cocktails, container, false);


        ImageButton backButton = layout.findViewById(R.id.conf_button);
        ImageButton profileButton = layout.findViewById(R.id.profile_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Favourites.this, MainDodoDex.class);
                //intent.putExtra("user-token", user_token);
                //startActivity(intent);
            }

        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Favourites.this, datos_personales.class);
                //intent.putExtra("user-token", user_token);
                //startActivity(intent);
            }
        });

        this.recyclerView = layout.findViewById(R.id.recyclerView);


        return layout;
    }
}