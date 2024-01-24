package com.app.licopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sign_in extends AppCompatActivity {
    
    private EditText email, password;
    private String semail, spassword;
    private Button sign_in, register;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        
        email = findViewById(R.id.sign_in_email);
        password = findViewById(R.id.sign_in_password);
        sign_in = findViewById(R.id.sign_in_login_button);
        register = findViewById(R.id.sign_in_register_button);
        
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                semail = email.getText().toString();
                spassword = password.getText().toString();
                
                
                
            }
        });
        
        
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                //startActivity(new Intent(sign_in.this, register.class));
                
            }
        });
        
    }
}