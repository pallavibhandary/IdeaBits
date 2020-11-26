package com.example.ideabits.Viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideabits.Interface.ItemClickListener;
import com.example.ideabits.R;

public class SavedViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtImageName, txtImage;
    private ItemClickListener itemClickListener;

    public SavedViewHolder(@NonNull View itemView) {
        super(itemView);

        txtImageName = itemView.findViewById(R.id.save_image_name);

        txtImage= itemView.findViewById(R.id.myImageDesc);
    }

    @Override
    public void onClick(View view)
    {
        itemClickListener.onClick(view, getAdapterPosition(), false);

    }
    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }
}
