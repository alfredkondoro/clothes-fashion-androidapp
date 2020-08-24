package com.example.clothesfashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Boys extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boys);

      ImageView boyssuits = findViewById(R.id.boyssuits);
      ImageView boysshits = findViewById(R.id.boysshirt);
      ImageView boystrouser = findViewById(R.id.boystrouser);

      boyssuits.setOnClickListener(this);
      boysshits.setOnClickListener(this);
      boystrouser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.boyssuits){
            Intent BoysSuitIntent = new Intent(this,BoysSuit.class);
            startActivity(BoysSuitIntent);
        }

        if(view.getId() == R.id.boysshirt){
            Intent BoysShirtIntent = new Intent(this,BoysShirts.class);
            startActivity(BoysShirtIntent);
        }

        if(view.getId() == R.id.boystrouser){
            Intent BoysTrouserIntent = new Intent(this,BoysTrouser.class);
            startActivity(BoysTrouserIntent);
        }
    }
}