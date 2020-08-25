package com.example.clothesfashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Girls extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls);

        ImageView girlsdress = findViewById(R.id.girlsdress);
        ImageView girlsshirts = findViewById(R.id.girlsshirts);
        ImageView girlstrouser = findViewById(R.id.girlstrouser);

        girlsdress.setOnClickListener(this);
        girlsshirts.setOnClickListener(this);
        girlstrouser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.girlsdress){
            Intent GirlsDressIntent = new Intent(this,GirlsDress.class);
            startActivity(GirlsDressIntent);
        }

        if(view.getId() == R.id.girlsshirts){
            Intent GirlsTrouserIntent = new Intent(this,GirlsTrouser.class);
            startActivity(GirlsTrouserIntent);
        }

        if(view.getId() == R.id.girlstrouser){
            Intent GirlsShirtIntent = new Intent(this,GirlsShirts.class);
            startActivity(GirlsShirtIntent);
        }
    }
}