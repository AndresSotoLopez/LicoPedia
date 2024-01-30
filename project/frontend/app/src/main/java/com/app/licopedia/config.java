package com.app.licopedia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.ActionBar;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class config extends AppCompatActivity {
    private static String user_token;
    private Switch dark_mode;
    public Intent main_activity;
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_MODE = "dark_mode";
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        // Set values for variables
        queue = Volley.newRequestQueue(config.this);
        main_activity = getIntent();
        user_token = main_activity.getStringExtra("user-token");

        dark_mode = findViewById(R.id.dark_mode_config_activity);
        Button  edit_account = findViewById(R.id.edit_account_button);
        ImageButton main_screen = findViewById(R.id.main_screen_button);
        if (user_token == null || user_token.isEmpty()) {
            // if the token is empty, user is not logged in
            // User gets redirected to the register page
                    /*
                    Intent intent = new Intent(Searcher.this, RegisterActivity.class);
                    startActivity(intent);
                    */
            // Finish the activity, so the user cant get back from the register page
        }
        main_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(config.this, Main.class);
                // startActivity(intent);
            }
        });
        edit_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(config.this, edit_account.class);
                // startActivity(intent);
            }
        });


        switch_dark_mode();
    }

    private void switch_dark_mode() {

        // Load dark mode state from shared preferences
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isDarkMode = preferences.getBoolean(PREF_DARK_MODE, false);

        // Set the switch state based on the current dark mode
        dark_mode.setChecked(isDarkMode);

        // Handle switch change
        dark_mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Save dark mode state to shared preferences
                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                editor.putBoolean(PREF_DARK_MODE, isChecked);
                editor.apply();

                // Dynamically change the app theme
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                // Recreate the activity to apply the theme change immediately
                recreate();
            }
        });

    }
}
