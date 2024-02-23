package com.app.licopedia;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.app.licopedia.databinding.ActivityMapsBinding;

public class maps_activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        float zoomLevel = 14;
        LatLng coruna = new LatLng(43.36297091175255, -8.409256603259596);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coruna, zoomLevel));

        //Marcadores de los bares
        LatLng mas_ramon = new LatLng(43.357938854149, -8.40787495894729);
        mMap.addMarker(new MarkerOptions().position(mas_ramon).title("Bar MasRamón"));

        LatLng berry = new LatLng(43.35946583306643, -8.404469386201331);
        mMap.addMarker(new MarkerOptions().position(berry).title("Bar Berry"));

        LatLng deivy = new LatLng(43.355487440742145, -8.409318820100221);
        mMap.addMarker(new MarkerOptions().position(deivy).title("Bar Deivy"));

        LatLng a_sardineira = new LatLng(43.35199753323476, -8.412396046897252);
        mMap.addMarker(new MarkerOptions().position(a_sardineira).title("Bar A Sardiñeira"));

        LatLng nely = new LatLng(43.35257124389151, -8.408845596378697);
        mMap.addMarker(new MarkerOptions().position(nely).title("Bar Nely"));

        LatLng tomalascanas = new LatLng(43.3558148137865, -8.401168126454008);
        mMap.addMarker(new MarkerOptions().position(tomalascanas).title("Bar Tomalascañas"));

        LatLng a_escala = new LatLng(43.361260942632235, -8.41063788895121);
        mMap.addMarker(new MarkerOptions().position(a_escala).title("Bar A'Escala"));

        LatLng bahia2 = new LatLng(43.356689804714385, -8.414736304325956);
        mMap.addMarker(new MarkerOptions().position(bahia2).title("Bar Bahía 2"));
    }
}