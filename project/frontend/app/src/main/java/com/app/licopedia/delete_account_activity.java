package com.app.licopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class delete_account_activity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_account_activity);
        Button yes_button = findViewById(R.id.yes_button);
        Button no_button = findViewById(R.id.no_button);

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(delete_account_activity.this, "Cuenta eliminada con éxito", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(delete_account_activity.this, sign_in.class);
                startActivity(intent);
            }
        });

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(delete_account_activity.this, MainLicoPedia.class);
                startActivity(intent);
            }
        });
    }
}