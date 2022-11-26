package com.streetcats.listener;

import androidx.annotation.NonNull;
import androidx.preference.Preference;

import com.streetcats.MainActivity;

public class PreferenceThemeChangeListener implements Preference.OnPreferenceChangeListener {
    @Override
    public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
        String theme = newValue.toString();
        MainActivity.setTheme(theme);
        return true;
    }
}
