package com.app.licopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Register extends AppCompatActivity {
    private static final String BASE_URL = "http://10.0.2.2:8000";
    private EditText editTextEmail,editTextPassword,editTextName,editTextSurnames;
    private Button buttonRegister;
    private Context context = this;
    private ImageView imagen;
    private TextView mostrarContraseña;
    private Boolean hide = true;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imagen = findViewById(R.id.ImageLogo);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextName = findViewById(R.id.editTextName);
        editTextSurnames = findViewById(R.id.editTextSurnames);
        mostrarContraseña = findViewById(R.id.MostrarContraseña);
        buttonRegister = findViewById(R.id.ButtonRegister);

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

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editTextPassword.getText().toString().equals(editTextPassword.getText().toString())) {
                    editTextPassword.setError("Contraseña diferente");
                }
                if (editTextPassword.length() == 0)
                    editTextPassword.setError("Falta Contraseña");

                if (editTextName.length() == 0)
                    editTextName.setError("Falta Nombre");

                if (editTextSurnames.length() == 0)
                    editTextSurnames.setError("Falta Apellidos");

                if (editTextEmail.length() == 0)
                    editTextEmail.setError("Falta Email");

                else {
                    register(editTextName, editTextSurnames, editTextEmail, editTextPassword);
                }
            }
        });

    }
    private void register(EditText editTextName, EditText editTextSurnames, EditText
            editTextEmail, EditText editTextPassword){
        queue = Volley.newRequestQueue(context);
        JSONObject requestBody = new JSONObject();
        try {

            requestBody.put("name", editTextName.getText().toString());
            requestBody.put("surnames", editTextSurnames.getText().toString());
            requestBody.put("email", editTextEmail.getText().toString());
            requestBody.put("password", editTextPassword.getText().toString());

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                BASE_URL + "/register",
                requestBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Toast.makeText(context, "Cuenta creada con éxito", Toast.LENGTH_SHORT).show();
                        //Intent intent = new Intent(context, .class);
                        //context.startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error.networkResponse == null) {
                            Toast.makeText(context, "Sin conexión", Toast.LENGTH_LONG).show();

                        } else if (error.networkResponse.statusCode == 409) {
                            Toast.makeText(context, "Cuenta ya registrada", Toast.LENGTH_SHORT).show();

                        } else {
                            int serverCode = error.networkResponse.statusCode;
                            Toast.makeText(context, "Error: " + serverCode, Toast.LENGTH_LONG).show();

                        }
                    }
                });
        this.queue.add(request);
    }
}

