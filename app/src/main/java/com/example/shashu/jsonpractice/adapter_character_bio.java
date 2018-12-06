package com.example.shashu.jsonpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class adapter_character_bio extends AppCompatActivity {
    TextView character_bio_name;
    TextView description;
    ImageView character_bio_img;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.item_character_bio);
        character_bio_img = findViewById(R.id.character_bio_img);
        character_bio_name = findViewById(R.id.character_bio_name);
        description = findViewById(R.id.description);
        Intent intent = getIntent();
        character_bio_name.setText(intent.getExtras().getString("name"));
        Glide.with(character_bio_img.getContext()).load(intent.getExtras().getString("thumbnail")).into(character_bio_img);
        description.setText(intent.getExtras().getString("description"));
    }
}
