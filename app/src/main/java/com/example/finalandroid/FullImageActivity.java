package com.example.finalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImageActivity extends AppCompatActivity {
    int position;
    ImageView imageView;
    String imagelink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        Bundle bundle= getIntent().getExtras();
        if (bundle !=null){
            bundle.getString("position"   );
            imagelink = bundle.getString("image");
        }
        imageView.setImageURI(Uri.parse(imagelink));
    }
}
