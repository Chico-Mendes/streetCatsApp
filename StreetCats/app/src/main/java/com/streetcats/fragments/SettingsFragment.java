package com.streetcats.fragments;

import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.streetcats.R;
import com.streetcats.listener.PreferenceLanguageChangeListener;
import com.streetcats.listener.PreferenceThemeChangeListener;


public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        Preference themePreference = findPreference("theme");
        if (themePreference != null) {
            themePreference.setOnPreferenceChangeListener(new PreferenceThemeChangeListener());
        }
        Preference languagePreference = findPreference("language");
        if (languagePreference != null) {
            languagePreference.setOnPreferenceChangeListener(new PreferenceLanguageChangeListener(getActivity()));
        }
    }

}