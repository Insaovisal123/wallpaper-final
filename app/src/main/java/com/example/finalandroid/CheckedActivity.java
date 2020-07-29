package com.example.finalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class CheckedActivity extends AppCompatActivity {
    String imageUrl;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked);

        imageView = findViewById(R.id.select_image);

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            imageUrl = intent.getStringExtra("imageUrl");
            Glide.with(this)
                    .load(imageUrl)
                    .into(imageView);
        }
    }
}
