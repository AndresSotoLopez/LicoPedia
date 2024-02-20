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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.List;

public class cocktails_fragment extends Fragment {
    private Context context;
    private RequestQueue requestQueue;
    private JsonArrayRequest request;
    private RecyclerView recyclerView;
    private List<cocktails> cocktailList;

    public static cocktails_fragment newInstance(){
        return new cocktails_fragment();
    }

    public void onAttach(Context newContext){
        super.onAttach(newContext);
        this.context = newContext;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_cocktails, container, false);
        String url_string = "https://raw.githubusercontent.com/AndresSotoLopez/LicoPedia/master/project/recursos/catalog2.json";
        ImageButton backButton = layout.findViewById(R.id.conf_button);
        ImageButton profileButton = layout.findViewById(R.id.profile_button);
        ImageButton searchButton = layout.findViewById(R.id.searchButton);
        EditText searchCocktailByName = layout.findViewById(R.id.searchCocktailByName);

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
        showData(url_string);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder queryString = new StringBuilder();
                String cocktail_name = searchCocktailByName.getText().toString().trim();
                if (!cocktail_name.isEmpty()) {
                    queryString.append("?name=").append(cocktail_name);
                }
                // String fullUrl = url_string + queryString;
                String fullUrl = "https://raw.githubusercontent.com/AndresSotoLopez/LicoPedia/master/project/recursos/catalog1.json";
                if (cocktailList != null){
                    cocktailList.clear();
                }
                showData(fullUrl);
                Toast.makeText(context, "Search Done", Toast.LENGTH_LONG).show();
            }

        });
        return layout;
    }
    private void showData(String fullUrl) {

        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        if (cocktailList != null){
            cocktailList.clear();
        }
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                fullUrl,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        boolean not_found= false;
                        if (response == null || response.length() == 0) {
                            cocktailList.add(new cocktails("Not Found", "https://example.com/not_found.jpg"));
                            not_found = true;

                        } else {
                            cocktails_list cocktails_list = new cocktails_list(response); // Instantiate DinosaurList with the JSONArray response
                            cocktail_adapter myAdapter = new cocktail_adapter(cocktails_list); // Pass the list from DinosaurList to the adapter
                            recyclerView.setAdapter(myAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(context)); // Use 'context' instead of 'this'
                        }
                        updateRecyclerView(not_found, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Error de la solicitud
                        if (error.networkResponse == null) {
                            Toast.makeText(context, "No se pudo establecer la conexión", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(context, "Error del servidor: " + error.networkResponse.statusCode, Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        // Agregar la solicitud a la cola
        requestQueue.add(request);
    }
    private void updateRecyclerView(boolean not_found, JSONArray response) {
        cocktails_list cocktailsList;
        if (not_found) {
            cocktailsList = new cocktails_list(new JSONArray(cocktailList));
        } else {
            cocktailsList = new cocktails_list(response);
        }
        cocktail_adapter myAdapter = new cocktail_adapter(cocktailsList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}