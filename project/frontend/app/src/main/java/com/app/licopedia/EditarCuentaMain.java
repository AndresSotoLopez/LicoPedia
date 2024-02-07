package com.app.licopedia;

import static com.app.licopedia.R.*;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;

public class EditarCuentaMain extends Fragment {
    private Button buttonAcept;
    private Context context;
    private RequestQueue requestQueue;
    private EditText Email, User, Name,Surname, Password,RepeatPassword;

    public void onAttach(Context newContext){
        super.onAttach(newContext);
        this.context = newContext;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layout.editar_cuenta_main, container, false);
        Email = view.findViewById(id.casilla_rellenarEmail);
        User = view.findViewById(id.casilla_usuario);
        Name = view.findViewById(id.casilla_nombre);
        Surname = view.findViewById(id.casilla_apellido);
        Password = view.findViewById(id.casilla_contraseña);
        RepeatPassword = view.findViewById(id.casilla_repetirContra);

        buttonAcept = view.findViewById(id.boton_aceptar);

        /****/
        buttonAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Se han guardado correctamente los cambios.",Toast.LENGTH_SHORT).show();
               // EditUser();
            }
        });
        return view;
    }
/**
    private  void  EditUser() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", Email.getText().toString());
            jsonObject.put("user", User.getText().toString());
            jsonObject.put("name", Name.getText().toString());
            jsonObject.put("surname", Surname.getText().toString());
            jsonObject.put("password", Password.getText().toString());
            jsonObject.put("repeat password", RepeatPassword.getText().toString());

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                Server.name + "/editUser",
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(context,"Usuario modificado correctamente.",Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error.networkResponse==null){
                            Toast.makeText(context,"No se ha podido establecer conexion", Toast.LENGTH_SHORT).show();
                        }else{
                            int serverCode= error.networkResponse.statusCode;
                            Toast.makeText(context,"Codigo de respuesta: "+serverCode, Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
        this.requestQueue.add(jsonObjectRequest);
    }
*/

}