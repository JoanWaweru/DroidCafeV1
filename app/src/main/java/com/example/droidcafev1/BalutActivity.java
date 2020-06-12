package com.example.droidcafev1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BalutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balut);

        TextView balutTitle = findViewById(R.id.balut_title);
        TextView balutDescription = findViewById(R.id.balut_description);
        ImageView balutImage = findViewById(R.id.balut_image);

        balutTitle.setText(getIntent().getStringExtra("dTitle"));
        balutDescription.setText(getIntent().getStringExtra("dDescription"));

        Glide.with(this).load(getIntent().getIntExtra("dImage", 0)).into(balutImage);
    }
}
