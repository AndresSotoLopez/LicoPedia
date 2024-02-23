package com.app.licopedia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import com.app.licopedia.R;

public class Config_fragment extends AppCompatActivity {

    private Switch darkModeSwitch;
    private Context context = this;
    
    private ImageButton edit_user;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_config);
        
        switchDarkMode();
        
        // Edit user data button
        edit_user = findViewById(R.id.main_screen_button);
        edit_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                startActivity(new Intent(context,sign_in.class));
                
            }
        });
        
    }
    
    private void switchDarkMode() {
        // Load dark mode state from shared preferences
        boolean isDarkMode = PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(getString(R.string.pref_dark_mode_key), false);

        // Set the switch state based on the current dark mode
        darkModeSwitch.setChecked(isDarkMode);

        // Handle switch change
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Save dark mode state to shared preferences
                PreferenceManager.getDefaultSharedPreferences(context)
                        .edit()
                        .putBoolean(getString(R.string.pref_dark_mode_key), isChecked)
                        .apply();

                // Dynamically change the app theme
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}
