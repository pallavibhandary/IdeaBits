package com.example.ideabits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SearchImagesActivity extends AppCompatActivity {

    private Button searchBtn;
    private EditText inputText;
    private RecyclerView searchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_images);

        inputText = findViewById(R.id.search_1);
        searchBtn = findViewById(R.id.search_images);
        searchList = findViewById(R.id.search_list);
        searchList.setLayoutManager(new LinearLayoutManager(SearchImagesActivity.this));


    }
}