package com.app.licopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class datos_personales extends AppCompatActivity {

    private TextView email, password, direccion, movil;
    private Button cerrar_sesion, eliminar_cuenta;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        //Asignamos los botones del xml
        cerrar_sesion = findViewById(R.id.datosp_close_session);
        eliminar_cuenta = findViewById(R.id.datosp_delete_account);

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
                
                mAuth.signOut();
                startActivity(new Intent(datos_personales.this, sign_in.class));
                finishAffinity();

            }
        });

        eliminar_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (user != null) {
                    // Delete the user's account
                    user.delete()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(datos_personales.this, sign_in.class));
                                    finishAffinity();
                                } else {
                                    Toast.makeText(datos_personales.this, "No se ha podido borrar la cuenta", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                else
                    Toast.makeText(datos_personales.this, "Error al borrar la cuenta", Toast.LENGTH_SHORT).show();
               

            }
        });

    }
}