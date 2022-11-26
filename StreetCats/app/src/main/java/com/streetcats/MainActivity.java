package com.streetcats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.streetcats.data.Datasource;
import com.streetcats.listener.TabSelectedListener;
import com.streetcats.model.Cat;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String ADD_EDIT = "com.streetcats.ADD_EDIT";
    public static final String CAT_NAME = "com.streetcats.CAT_NAME";

    public static String[] tabTitles;
    public static int[] tabIcons;
    public static int tabSize;
    public static int tabPosition = 1;
    private static TabLayout tabLayout;
    private static TabSelectedListener tabSelectedListener;

    public static ArrayList<Cat> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the pre-defined preferences
        setPreferences();
        // Set view
        setContentView(R.layout.activity_main);

        // Initialize data.
        myDataset = new Datasource().loadNames();

        tabTitles = getResources().getStringArray(R.array.tab_titles);
        tabIcons = new int[]{R.drawable.ic_default,
                R.drawable.ic_default,
                R.drawable.ic_default,
                R.drawable.ic_settings};
        tabSize = Math.min(tabTitles.length, tabIcons.length);
        tabLayout = findViewById(R.id.tab_layout);
        tabSelectedListener = new TabSelectedListener(this);

        for(int position = 0; position < tabSize; position++) {
            TabLayout.Tab tab = tabLayout.newTab();
            if(position!=3) tab.setText(tabTitles[position]); // TODO: delete later
            tab.setIcon(tabIcons[position]);
            tabLayout.addTab(tab);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        tabLayout.addOnTabSelectedListener(tabSelectedListener);

        // select the current tab (default -> StreetCats)
        tabLayout.selectTab(tabLayout.getTabAt(tabPosition));
    }

    @Override
    protected void onPause() {
        super.onPause();
        tabLayout.removeOnTabSelectedListener(tabSelectedListener);
    }

    private void setPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = sharedPreferences.getString("theme", "system default");
        setTheme(theme);
        String language = sharedPreferences.getString("language", "en");
        setLanguage(language, this);
    }

    public static void setTheme(String theme) {
        switch (theme) {
            case "light theme":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case "dark theme":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            default:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }

    public static void setLanguage(String language, Context context) {
        Locale locale;
        if ("pt-PT".equals(language)) {
            locale = new Locale("pt", "PT");
        } else {
            locale = new Locale("en");
        }
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        //context = context.createConfigurationContext(configuration);
        context.getResources().updateConfiguration(configuration,
                context.getResources().getDisplayMetrics());
    }
}