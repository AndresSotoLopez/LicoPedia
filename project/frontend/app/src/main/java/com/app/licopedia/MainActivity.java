package com.app.licopedia;

import static com.app.licopedia.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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

import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    private Button buttonAcept;
    private Context context=this;
    private RequestQueue requestQueue;
    private EditText Email, User, Name,Surname, Password,RepeatPassword;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        buttonAcept = findViewById(R.id.boton_aceptar);
        buttonAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Se han cambiado correctamente los cambios.",Toast.LENGTH_SHORT).show();
                EditUser();
            }
        });

    }
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
                        finish();
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

}