package com.streetcats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddEditCatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_cat);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String title = intent.getStringExtra(MainActivity.ADD_EDIT);
        setTitle(title);
    }
}