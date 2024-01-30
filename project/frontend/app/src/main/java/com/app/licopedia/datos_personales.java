package com.app.licopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class datos_personales extends AppCompatActivity {

    private TextView email, password, direccion, movil;
    private Button cerrar_sesion, eliminar_cuenta;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        //Asignamos los botones del xml
        cerrar_sesion = findViewById(R.id.datosp_close_session);
        eliminar_cuenta = findViewById(R.id.datosp_delete_account);

        //Conseguir datos del usuario con el token que se envia desde la main_activity
        //Con getString obtenemos el token


        //Obtenemos los datos del usuario y los sustituimos en la siguientes variables
        email = findViewById(R.id.datosp_email_data);
        email.setText("email@example.com");

        password = findViewById(R.id.datosp_password_data);
        password.setText("password");

        direccion = findViewById(R.id.datospp_direc_data);
        direccion.setText("Direccion de prueba");

        movil = findViewById(R.id.datosp_movil_data);
        movil.setText("123456789");

        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(datos_personales.this, "Prueba", Toast.LENGTH_LONG).show();
                //Eliminar token
                //startActivity(new Intent(datos_personales.this, login.class));

            }
        });

        eliminar_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(datos_personales.this, "Prueba", Toast.LENGTH_LONG).show();
                //Eliminar datos del usuario + sesion de usuario
               // startActivity(new Intent(datos_personales.this, login.class));

            }
        });

    }
}