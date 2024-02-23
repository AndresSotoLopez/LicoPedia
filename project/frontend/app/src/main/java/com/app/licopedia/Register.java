package com.app.licopedia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {
    private static final String BASE_URL = "http://10.0.2.2:8000";
    private EditText editTextEmail,editTextPassword,editTextName,editTextSurnames;
    private Button buttonRegister;
    private Context context = this;
    private ImageView imagen;
    private TextView mostrarContraseña;
    private Boolean hide = true;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        imagen = findViewById(R.id.ImageLogo);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextName = findViewById(R.id.editTextName);
        editTextSurnames = findViewById(R.id.editTextSurnames);
        mostrarContraseña = findViewById(R.id.MostrarContraseña);
        buttonRegister = findViewById(R.id.ButtonRegister);

        buttonRegister.setOnClickListener(v -> registrarUsuario());

        mostrarContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hide) {
                    hide = false;
                    editTextPassword.setTransformationMethod(null);
                } else {
                    hide = true;
                    editTextPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

    }
    private void registrarUsuario(){
        String nombre = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(nombre)){
            editTextName.setError("Ingresa tu nombre");
            return;
        }
        if (TextUtils.isEmpty(email)){
            editTextEmail.setError("Ingresa tu correo electrónico");
            return;
        }
        if (TextUtils.isEmpty(password) || password.length() < 6){
            editTextPassword.setError("Ingresa una contraseña válida (mínimo 6 caracteres)");
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        FirebaseUser user = mAuth.getCurrentUser();
                        //Guardar datos adicionales en Realtime Database
                        Usuario nuevoUsuario = new Usuario(nombre, email);
                        FirebaseDatabase.getInstance().getReference("usuarios")
                                .child(user.getUid())
                                .setValue(nuevoUsuario)
                                .addOnCompleteListener(taskDb -> {
                                   if (taskDb.isSuccessful()) {
                                       Toast.makeText(Register.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                                       //startActivity(new Intent(Register.this, sign_in.class));
                                       finish();
                                   } else {
                                       Toast.makeText(Register.this, "Error al guardar los datos: " + taskDb.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                   }
                                });
                    } else {
                        Log.e("TagError", task.getException().getMessage());
                        Toast.makeText(Register.this, "Registro fallido: " +
                                task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    static class Usuario {
        public String nombre, correo;

        public Usuario(String nombre, String correo){
            this.nombre = nombre;
            this.correo = correo;
        }
    }
}

