package com.app.licopedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtén el FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Comienza una transacción de fragmento
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Reemplaza el contenido del contenedor con el fragmento cocktails_activity
        Fragment cocktailsFragment = new cocktails_activity(); // Instancia tu fragmento
        fragmentTransaction.replace(R.id.fragment_container, cocktailsFragment);

        // Añade la transacción a la pila de retroceso (back stack)
        fragmentTransaction.addToBackStack(null);

        // Realiza la transacción
        fragmentTransaction.commit();
    }
}
