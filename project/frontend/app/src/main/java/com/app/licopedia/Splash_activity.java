package com.app.licopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Splash_activity extends AppCompatActivity {
    private ProgressBar progressbar;
    private static final int SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressbar = findViewById(R.id.progress_bar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crear un Intent para iniciar la actividad principal

               Intent intent = new Intent(Splash_activity.this, MainLicoPedia.class);
               startActivity(intent);

                // Cerrar la actividad de bienvenida para que no pueda volver atrás
                finish();
            }
        }, SPLASH_DELAY);

    }
}