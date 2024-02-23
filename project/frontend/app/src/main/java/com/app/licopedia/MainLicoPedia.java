package com.app.licopedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainLicoPedia extends AppCompatActivity {
    private Context main_context = this;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    private ImageView btnPerfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_licopedia);
        Activity activity = this;

        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navView);
        RecyclerView recyclerViewRecom = findViewById(R.id.recycler_recomendaciones);
        RecyclerView recyclerViewTen = findViewById(R.id.recycler_tendencias);
        RecyclerView recyclerViewBus = findViewById(R.id.recycler_buscados);


        // Configurar ActionBarDrawerToggle
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        // Vincular ActionBarDrawerToggle con DrawerLayout
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // Configurar el NavigationItemSelectedListener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Manejar los clics en los elementos del menú
                int itemId = item.getItemId();
                
                if (itemId == R.id.nav_item1) {
                    // Navegar a la Activity correspondiente para el elemento 1
                    startActivity(new Intent(MainLicoPedia.this, MainLicoPedia.class));
                } else if (itemId == R.id.nav_item2) {
                    // Navegar a la Activity correspondiente para el elemento 2
                    startActivity(new Intent(MainLicoPedia.this, LicoresFragment.class));
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LicoresFragment()) .addToBackStack(null).commit();
                } else if (itemId == R.id.nav_item3) {
                    // Navegar a la Activity correspondiente para el elemento 3
                    startActivity(new Intent(MainLicoPedia.this, cocktails_fragment.class));
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new cocktails_fragment()) .addToBackStack(null).commit();
                } else if (itemId == R.id.nav_item4) {
                    // Navegar a la Activity correspondiente para el elemento 4
                    startActivity(new Intent(MainLicoPedia.this, LicoresGuardadosMain.class));
                } else if (itemId == R.id.nav_item5) {
                    // Navegar a la Activity correspondiente para el elemento 5
                    startActivity(new Intent(MainLicoPedia.this, maps_activity.class));
                } else if (itemId == R.id.nav_item6) {
                    // Navegar a la Activity correspondiente para el elemento 5
                    startActivity(new Intent(MainLicoPedia.this, Config_fragment.class));
                }
                
                
                // Cerrar el cajón de navegación después de manejar el clic en un elemento
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

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
                        LicoAdapter licoAdapter = new LicoAdapter(allLicores, activity, MainLicoPedia.this);
                        recyclerViewRecom.setAdapter(licoAdapter);
                        recyclerViewRecom.setLayoutManager(new LinearLayoutManager(activity));
                        LinearLayoutManager layoutManagerRecom = new LinearLayoutManager(main_context, LinearLayoutManager.HORIZONTAL, false);
                        recyclerViewRecom.setLayoutManager(layoutManagerRecom);
                    }
                }, new Response.ErrorListener() {
            // Callback para manejar errores en la respuesta
            @Override
            public void onErrorResponse(VolleyError error) {
                // Muestra un Toast con el mensaje de error
                Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //Petición para el recyclerView de Tendencias
        JsonArrayRequest requestTendencias = new JsonArrayRequest(
                Request.Method.GET,
                "https://raw.githubusercontent.com/AndresSotoLopez/LicoPedia/master/project/recursos/catalog2.json",
                null,
                new Response.Listener<JSONArray>() {
                    // Callback para manejar la respuesta exitosa
                    @Override
                    public void onResponse(JSONArray response) {
                        // Lista para almacenar objetos LicoData
                        List<LicoData> allLicores = new ArrayList<>();

                        // Itera sobre el JSONArray para crear objetos LicoData
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject licores = response.getJSONObject(i);
                                LicoData data = new LicoData(licores);
                                allLicores.add(data);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // Configura el RecyclerView con el adaptador y el administrador de diseño
                        LicoAdapterTendencias licoAdapterTen = new LicoAdapterTendencias(allLicores, activity, MainLicoPedia.this);
                        recyclerViewTen.setAdapter(licoAdapterTen);
                        LinearLayoutManager layoutManagerTen = new LinearLayoutManager(main_context, LinearLayoutManager.HORIZONTAL, false);
                        recyclerViewTen.setLayoutManager(layoutManagerTen);
                    }
                }, new Response.ErrorListener() {
            // Callback para manejar errores en la respuesta
            @Override
            public void onErrorResponse(VolleyError error) {
                // Muestra un Toast con el mensaje de error
                Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //Petición del recyclerView de Buscados
        JsonArrayRequest requestBuscados = new JsonArrayRequest(
                Request.Method.GET,
                "https://raw.githubusercontent.com/AndresSotoLopez/LicoPedia/master/project/recursos/catalog3.json",
                null,
                new Response.Listener<JSONArray>() {
                    // Callback para manejar la respuesta exitosa
                    @Override
                    public void onResponse(JSONArray response) {
                        // Lista para almacenar objetos LicoData
                        List<LicoData> allLicores = new ArrayList<>();

                        // Itera sobre el JSONArray para crear objetos LicoData
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject licores = response.getJSONObject(i);
                                LicoData data = new LicoData(licores);
                                allLicores.add(data);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // Configura el RecyclerView con el adaptador y el administrador de diseño
                        LicoAdapterBuscados licoAdapterBuscados = new LicoAdapterBuscados(allLicores, activity, MainLicoPedia.this);
                        recyclerViewBus.setAdapter(licoAdapterBuscados);
                        LinearLayoutManager layoutManagerBus = new LinearLayoutManager(main_context, LinearLayoutManager.HORIZONTAL, false);
                        recyclerViewBus.setLayoutManager(layoutManagerBus);
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
        // Primera solicitud a la cola
        cola.add(request);
        // Segunda solicitud a la cola
        cola.add(requestTendencias);
        // Tercera solicitud a la cola
        cola.add(requestBuscados);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejar eventos de clic en el icono de la barra de herramientas (el icono de menú)
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Método para que al clicar en el ImageView del Perfil me lleve a dicha actividad
    public void onProfileButtonClick(View view) {
        // Manejar el clic en el botón de perfil
        Intent intent = new Intent(this, datos_personales.class);
        startActivity(intent);
    }
}

