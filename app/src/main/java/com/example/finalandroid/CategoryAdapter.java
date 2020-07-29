package com.example.finalandroid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Category> categories;

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item,parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPreview;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPreview = itemView.findViewById(R.id.imgPreview);
            name = itemView.findViewById(R.id.name);
        }

        public void binding(Category category) {
            Context context = itemView.getContext();
            Glide.with(context)
                    .load(category.getImgPreview())
                    .into(imgPreview);
            name.setText(category.getName());
        }
    }
}
