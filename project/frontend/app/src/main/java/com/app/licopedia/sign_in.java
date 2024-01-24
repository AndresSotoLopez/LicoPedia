package com.app.licopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class sign_in extends AppCompatActivity {
    
    private EditText email, password;
    private String semail, spassword;
    private Button sign_in, register;
    private FirebaseAuth auth;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        
        auth = FirebaseAuth.getInstance();
        
        email = findViewById(R.id.sign_in_email);
        password = findViewById(R.id.sign_in_password);
        sign_in = findViewById(R.id.sign_in_login_button);
        register = findViewById(R.id.sign_in_register_button);
        
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                semail = email.getText().toString().trim();
                spassword = password.getText().toString().trim();
                
                auth.signInWithEmailAndPassword(semail, spassword)
                        .addOnCompleteListener(sign_in.this, task -> {
                    
                    if ((task.isSuccessful())){
                        
                        startActivity(new Intent(com.app.licopedia.sign_in.this, mainActivity.class));
                        finish();
                        
                    }
                    else
                        Toast.makeText(com.app.licopedia.sign_in.this, "Error at Sign IN", Toast.LENGTH_LONG).show();
                });
                
            }
        });
        
        
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                startActivity(new Intent(sign_in.this, register.class));
                
            }
        });
        
    }
}