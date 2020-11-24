
package com.example.ideabits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminCategory extends AppCompatActivity {

    private ImageView fashion, quotes;
    private ImageView travel, Diy;
    private ImageView dog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        fashion =  findViewById(R.id.fashion);
        quotes =  findViewById(R.id.quotes);
        travel =  findViewById(R.id.travel);
        Diy =  findViewById(R.id.diy);
        dog =  findViewById(R.id.dog);

        fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategory.this, AddNewImage.class);
                intent.putExtra("category", "fashion");
                startActivity(intent);
            }
        });

        quotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategory.this, AddNewImage.class);
                intent.putExtra("category", "Quotes");
                startActivity(intent);
            }
        });

        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategory.this, AddNewImage.class);
                intent.putExtra("category", "Travel");
                startActivity(intent);
            }
        });

        Diy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategory.this, AddNewImage.class);
                intent.putExtra("category", "diy & Arts");
                startActivity(intent);
            }
        });

        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategory.this, AddNewImage.class);
                intent.putExtra("category", "Dog");
                startActivity(intent);
            }
        });
    }
}