package com.streetcats.listener;

import android.content.Intent;
import android.view.View;

import com.streetcats.CatProfileActivity;
import com.streetcats.MainActivity;
import com.streetcats.model.Cat;

public class CatViewOnClickListener implements View.OnClickListener {
    Cat cat;

    public CatViewOnClickListener(Cat inCat) {
        cat = inCat;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), CatProfileActivity.class);
        intent.putExtra(MainActivity.CAT_NAME, cat.getName());
        view.getContext().startActivity(intent);
    }
}
