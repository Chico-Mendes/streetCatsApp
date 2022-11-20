package com.streetcats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    public static String[] tabTitles = null;
    public static int[] tabIcons = null;
    public static int tabSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabTitles = getResources().getStringArray(R.array.tab_titles);
        tabIcons = new int[]{R.drawable.ic_default,
                R.drawable.ic_default,
                R.drawable.ic_default};
        tabSize = Math.min(tabTitles.length, tabIcons.length);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        for(int position = 0; position < tabSize; position++) {
            TabLayout.Tab tab = tabLayout.newTab();
            //tab.setText(tabTitles[position]);
            tab.setIcon(tabIcons[position]);
            tabLayout.addTab(tab);
        }
    }
}