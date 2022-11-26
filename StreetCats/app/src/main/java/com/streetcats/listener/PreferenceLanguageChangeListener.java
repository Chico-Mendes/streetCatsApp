package com.streetcats.listener;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.preference.Preference;

import com.streetcats.MainActivity;

public class PreferenceLanguageChangeListener implements Preference.OnPreferenceChangeListener {
    Activity activity;

    public PreferenceLanguageChangeListener(Activity a) {
        activity = a;
    }

    @Override
    public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
        String language = newValue.toString();
        MainActivity.setLanguage(language, preference.getContext());
        activity.recreate();
        //Intent refresh = new Intent(preference.getContext(), MainActivity.class);
        //preference.getContext().startActivity(refresh);
        return true;
    }
}
