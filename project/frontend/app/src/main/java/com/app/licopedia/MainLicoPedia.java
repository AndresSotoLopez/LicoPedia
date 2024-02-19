package com.app.licopedia;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainLicoPedia extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context main_context = this;
    private LicoAdapter adapter;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Activity activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_licopedia);

        drawerLayout = findViewById(R.id.drawerLayout);
        recyclerView = findViewById(R.id.recycler_recomendaciones);

        // Realiza una solicitud JSON usando Volley para obtener datos del catálogo
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://raw.githubusercontent.com/AndresSotoLopez/LicoPedia/master/project/recursos/catalog1.json",
                null,
                new Response.Listener<JSONArray>() {
                    // Callback para manejar la respuesta exitosa
                    @Override
                    public void onResponse(JSONArray response) {
                        // Lista para almacenar objetos LicoData
                        List<LicoData> allLicores = new ArrayList<>();

                        // Itera sobre el JSONArray para crear objetos LicoData
                        for (int i = 0; i < response.length(); i++){
                            try{
                                JSONObject licores = response.getJSONObject(i);
                                LicoData data = new LicoData(licores);
                                allLicores.add(data);
                            } catch (JSONException e){
                                e.printStackTrace();
                            }
                        }

                        // Configura el RecyclerView con el adaptador y el administrador de diseño
                        adapter = new LicoAdapter(allLicores, activity, main_context);
                        recyclerView.setAdapter(adapter);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(main_context, LinearLayoutManager.HORIZONTAL, false);
                        recyclerView.setLayoutManager(layoutManager);

                    }
                }, new Response.ErrorListener() {
            // Callback para manejar errores en la respuesta
            @Override
            public void onErrorResponse(VolleyError error) {
                // Muestra un Toast con el mensaje de error
                Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Cola de solicitudes Volley
        RequestQueue cola = Volley.newRequestQueue(this);
        // Agrega la solicitud a la cola
        cola.add(request);
    }
}
