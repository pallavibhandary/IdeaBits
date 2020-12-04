package com.example.ideabits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ideabits.Model.Products;
import com.example.ideabits.Model.Saved;
import com.example.ideabits.Prevalent.Prevalent;
import com.example.ideabits.Viewholder.SavedViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

public class SaveImageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private TextView savedImageList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image);


        savedImageList = findViewById(R.id.saved_images_list);


        recyclerView = findViewById(R.id.save_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);





    }




    @Override
    protected void onStart()
    {
        super.onStart();
        final DatabaseReference saveListRef = FirebaseDatabase.getInstance().getReference().child("Save List");

        FirebaseRecyclerOptions<Saved> options =
                new FirebaseRecyclerOptions.Builder<Saved>()
                .setQuery(saveListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone()).child("Products"), Saved.class)
                        .build();

        FirebaseRecyclerAdapter<Saved, SavedViewHolder> adapter
                = new FirebaseRecyclerAdapter<Saved, SavedViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull SavedViewHolder holder, int position, @NonNull final Saved model)
            {
                holder.txtImageName.setText(model.getPname());
                holder.txtImage.setText(model.getDescription());

                holder.itemView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view)
                    {
                        CharSequence options[] = new CharSequence[]
                                {
                                        "Go To The Saved Image",
                                        "Remove"
                                };
                        AlertDialog.Builder builder= new AlertDialog.Builder(SaveImageActivity.this);
                        builder.setTitle("Saving Options");

                        builder.setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                if(i==0)
                                {
                                    Intent intent = new Intent(SaveImageActivity.this, ProductDetailsActivity.class);
                                    intent.putExtra("pid",model.getPid());
                                    startActivity(intent);
                                }

                                if(i==1)
                                {
                                    saveListRef.child("User View")
                                    .child(Prevalent.currentOnlineUser.getPhone())
                                            .child("Products")
                                            .child(model.getPid())
                                            .removeValue()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task)
                                                {
                                                    if (task.isSuccessful())
                                                    {
                                                        saveListRef.child("Admin View")
                                                                .child(Prevalent.currentOnlineUser.getPhone())
                                                                .child("Products")
                                                                .child(model.getPid())
                                                                .removeValue()
                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                        if (task.isSuccessful()) {
                                                                            Toast.makeText(SaveImageActivity.this, "Image Removed Successfully.", Toast.LENGTH_SHORT).show();
                                                                            Intent intent = new Intent(SaveImageActivity.this, HomePageActivity.class);
                                                                            startActivity(intent);
                                                                        }
                                                                    }
                                                                });


                                                    }
                                                };


                                });
                            }
                        }

                    }); builder.show();
                }

            });
            }

            @NonNull
            @Override
            public SavedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.save_items_list, parent,false);
                SavedViewHolder holder = new SavedViewHolder(view);
                return holder;

            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}