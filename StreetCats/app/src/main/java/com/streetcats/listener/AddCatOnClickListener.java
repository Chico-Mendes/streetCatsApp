package com.streetcats.listener;

import android.content.Intent;
import android.view.View;

import com.streetcats.AddEditCatActivity;

public class AddCatOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), AddEditCatActivity.class);
        //intent.putExtra(MainActivity.CAT_NAME, item.getName());
        view.getContext().startActivity(intent);
    }
}
