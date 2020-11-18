package com.example.ideabits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class AddNewImage extends AppCompatActivity {
    private String CategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_image);

        CategoryName = getIntent().getExtras().get("category").toString();
        Toast.makeText(this,CategoryName,Toast.LENGTH_SHORT).show();
    }
}