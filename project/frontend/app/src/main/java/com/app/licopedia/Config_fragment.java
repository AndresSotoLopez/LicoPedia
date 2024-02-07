package com.app.licopedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import com.app.licopedia.R;

public class Config_fragment extends Fragment {

    private Switch darkModeSwitch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_config, container, false);

        darkModeSwitch = view.findViewById(R.id.dark_mode_config_activity);
        switchDarkMode();

        return view;
    }

    private void switchDarkMode() {
        // Load dark mode state from shared preferences
        boolean isDarkMode = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean(getString(R.string.pref_dark_mode_key), false);

        // Set the switch state based on the current dark mode
        darkModeSwitch.setChecked(isDarkMode);

        // Handle switch change
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Save dark mode state to shared preferences
                PreferenceManager.getDefaultSharedPreferences(getContext())
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
