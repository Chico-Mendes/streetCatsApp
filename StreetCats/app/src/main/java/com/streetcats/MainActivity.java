package com.streetcats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.streetcats.data.Datasource;
import com.streetcats.listener.TabSelectedListener;
import com.streetcats.model.Cat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String CAT_NAME = "com.example.recyclerview_gridlayout_cardview.CAT_NAME";

    public static String[] tabTitles = null;
    public static int[] tabIcons = null;
    public static int tabSize = 0;
    public static ArrayList<Cat> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize data.
        myDataset = new Datasource().loadNames();

        tabTitles = getResources().getStringArray(R.array.tab_titles);
        tabIcons = new int[]{R.drawable.ic_default,
                R.drawable.ic_default,
                R.drawable.ic_default};
        tabSize = Math.min(tabTitles.length, tabIcons.length);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        for(int position = 0; position < tabSize; position++) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(tabTitles[position]); // TODO: delete later
            tab.setIcon(tabIcons[position]);
            tabLayout.addTab(tab);
        }

        tabLayout.addOnTabSelectedListener(new TabSelectedListener(this));

        // select the initial fragment (StreetCats)
        tabLayout.selectTab(tabLayout.getTabAt(1));
    }
}