package com.streetcats.listener;

import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.streetcats.AddEditCatActivity;
import com.streetcats.MainActivity;
import com.streetcats.model.Cat;

public class AddEditCatOnClickListener implements View.OnClickListener {
    String addEdit;
    Cat cat;

    public AddEditCatOnClickListener(String inStr, @Nullable Cat inCat) {
        addEdit = inStr;
        cat = inCat;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), AddEditCatActivity.class);
        intent.putExtra(MainActivity.ADD_EDIT, addEdit);
        if (cat != null) {
            intent.putExtra(MainActivity.CAT_NAME, cat.getName());
        }
        view.getContext().startActivity(intent);
    }
}
