package com.app.licopedia;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class cocktails_activity extends Fragment {
    private Context context;
    private RequestQueue requestQueue;
    private JsonArrayRequest request;
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
        String url_string = "";

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
        recyclerView = layout.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        List<cocktails> cocktails = new ArrayList<>();
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url_string,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        cocktails_list dinosaurList = new cocktails_list(response); // Instantiate DinosaurList with the JSONArray response

                        cocktail_adapter myAdapter = new cocktail_adapter(dinosaurList); // Pass the list from DinosaurList to the adapter
                        recyclerView.setAdapter(myAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(context)); // Use 'context' instead of 'this'

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.networkResponse == null) {
                    Toast.makeText(context, "Connection could not be established", Toast.LENGTH_LONG).show();
                } else {
                    int serverCode = error.networkResponse.statusCode;
                    Toast.makeText(context, "Server error: " + serverCode, Toast.LENGTH_LONG).show();
                }
            }
        }
        );

        requestQueue.add(request);

        return layout;
    }
}