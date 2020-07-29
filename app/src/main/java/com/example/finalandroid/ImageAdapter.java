package com.example.finalandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    List<Image> images;


   public ImageAdapter(List<Image> images) {
        this.images = images;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_items, parent, false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Image image = images.get(position);
        Context context = holder.itemView.getContext();
        Glide.with(context)
                .load(image.getUrl())
                .into(holder.imageView);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Context context = v.getContext();
               Intent intent = new Intent(context, CheckedActivity.class);
               intent.putExtra("imageUrl", images.get(position).getUrl());
               context.startActivity(intent);
           }
       });

    }


    @Override
    public int getItemCount() {
        return images.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }

}
