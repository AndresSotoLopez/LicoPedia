package com.app.licopedia;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.List;

public class LicoresFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private List<LicoresData> licoresDataList = new ArrayList<>(); // Inicializar la lista
    private List<LicoresData> filteredLicoresList = new ArrayList<>(); // Lista filtrada
    private String user_token;

    public static LicoresFragment newInstance() {
        return new LicoresFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_licores, container, false);
        String url_string = "https://raw.githubusercontent.com/AndresSotoLopez/LicoPedia/master/project/recursos/catalog2.json";

        ImageButton backButton = layout.findViewById(R.id.conf_button);
        ImageButton profileButton = layout.findViewById(R.id.profile_button);
        ImageButton searchButton = layout.findViewById(R.id.searchButton);
        EditText searchLicorByName = layout.findViewById(R.id.searchLicorByName);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), MainLicoPedia.class);
                intent.putExtra("user-token", user_token);
                startActivity(intent);
            }

        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), datos_personales.class);
                intent.putExtra("user-token", user_token);
                startActivity(intent);
            }
        });

        recyclerView = layout.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        showData(url_string);

        searchButton.setOnClickListener(v -> {
            String licor_name = searchLicorByName.getText().toString().trim();
            filterLicores(licor_name); // Filtra los licores según el nombre proporcionado
        });

        return layout;
    }

    private void filterLicores(String query) {
        filteredLicoresList.clear();
        for (LicoresData licor : licoresDataList) {
            if (licor.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredLicoresList.add(licor); // Agrega los licores que coinciden con la consulta a la lista filtrada
            }
        }
        updateRecyclerView(); // Actualiza el RecyclerView con la lista filtrada
    }

    private void showData(String fullUrl) {
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                fullUrl,
                null,
                response -> {
                    if (response == null || response.length() == 0) {
                        Toast.makeText(requireContext(), "No se encontraron datos", Toast.LENGTH_LONG).show();
                    } else {
                        LicoresList licores_list = new LicoresList(response);
                        licoresDataList = licores_list.get_licores_list();
                        filteredLicoresList.clear();
                        filteredLicoresList.addAll(licoresDataList); // Agrega todos los licores a la lista filtrada inicialmente
                        updateRecyclerView();
                    }
                },
                error -> {
                    if (error.networkResponse == null) {
                        Toast.makeText(requireContext(), "No se pudo establecer la conexión", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(requireContext(), "Error del servidor: " + error.networkResponse.statusCode, Toast.LENGTH_LONG).show();
                    }
                }
        );

        requestQueue.add(request);
    }

    private void updateRecyclerView() {
        LicoresAdapter myAdapter = new LicoresAdapter(filteredLicoresList, requireActivity());
        recyclerView.setAdapter(myAdapter);
    }
}