package com.streetcats.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.streetcats.MainActivity;
import com.streetcats.R;
import com.streetcats.adapter.ItemAdapter;

public class StreetCatsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_street_cats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new ItemAdapter(view.getContext(), MainActivity.myDataset));

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
    }

    public void onPlusCat(View view) {
    }
}