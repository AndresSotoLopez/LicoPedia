package com.app.licopedia;

import static com.app.licopedia.R.*;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class EditarCuenta extends Fragment {
    private Button buttonAcept;
    private Context context;
    private RequestQueue requestQueue;
    private EditText Email, User, Name, Surname, Password, RepeatPassword;

    public void onAttach(Context newContext) {
        super.onAttach(newContext);
        this.context = newContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layout.editar_cuenta, container, false);

        Email = view.findViewById(id.casilla_rellenarEmail);
        Email.setText("email@exampel.com");

        User = view.findViewById(id.casilla_usuario);
        User.setText("Alicia23");

        Name = view.findViewById(id.casilla_nombre);
        Name.setText("Ana");

        Surname = view.findViewById(id.casilla_apellido);
        Surname.setText("López Area");

        Password = view.findViewById(id.casilla_contraseña);
        Password.setText("1234567");

        RepeatPassword = view.findViewById(id.casilla_repetirContra);
        RepeatPassword.setText("1234567");

        buttonAcept = view.findViewById(id.boton_aceptar);

        buttonAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Acepta el cambio y guardarlo, luego vuelve a la configuracion
                
                // startActivity(new Intent(Configuracion.this, login.class));
                Toast.makeText(context, "Se han guardado correctamente los cambios.", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}