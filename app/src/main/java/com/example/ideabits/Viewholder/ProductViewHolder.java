package com.example.ideabits.Viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ideabits.Interface.ItemClickListener;
import com.example.ideabits.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtImageName, txtImageDescription;
    public ImageView imageView;
    public ItemClickListener listener;


    public ProductViewHolder(View itemView)
    {
        super(itemView);


        imageView = itemView.findViewById(R.id.product_image);
        txtImageName = itemView.findViewById(R.id.image_name);
        txtImageDescription = itemView.findViewById(R.id.image_description);

    }

    public void setItemClickListener(ItemClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view)
    {
        listener.onClick(view, getAdapterPosition(), false);
    }
}
