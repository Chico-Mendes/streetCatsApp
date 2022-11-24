package com.streetcats.listener;

import androidx.fragment.app.FragmentActivity;

import com.google.android.material.tabs.TabLayout;
import com.streetcats.R;
import com.streetcats.fragments.DefaultFragment;
import com.streetcats.fragments.StreetCatsFragment;

public class TabSelectedListener implements TabLayout.OnTabSelectedListener {
    FragmentActivity fragmentActivity;

    public TabSelectedListener(FragmentActivity fa){
        fragmentActivity = fa;
    }
    
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        switch (position) {
            case 1:
                fragmentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, StreetCatsFragment.class, null).commit();
                break;
            default:
                fragmentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, DefaultFragment.class, null).commit();
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
}
