package com.streetcats.listener;

import android.content.Intent;
import android.view.View;

import com.streetcats.CatProfileActivity;
import com.streetcats.MainActivity;
import com.streetcats.model.Cat;

public class CatViewOnClickListener implements View.OnClickListener {
    Cat item;

    public CatViewOnClickListener(Cat input) {
        item = input;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), CatProfileActivity.class);
        intent.putExtra(MainActivity.CAT_NAME, item.getName());
        view.getContext().startActivity(intent);
    }
}
