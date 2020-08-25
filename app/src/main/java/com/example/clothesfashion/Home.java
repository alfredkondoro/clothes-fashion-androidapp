package com.example.clothesfashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private static final String URL_CREATE_ACCOUNT = "http://192.168.43.72/mo/users.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button girlsbtn = findViewById(R.id.girlsbtn);
        Button boysbtn = findViewById(R.id.boysbtn);

        girlsbtn.setOnClickListener(this);
        boysbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.girlsbtn){
            Intent GirlsIntent = new Intent(this,Girls.class);
            startActivity(GirlsIntent);
        }

        if(view.getId() == R.id.boysbtn){
            Intent BoysIntent = new Intent(this,Boys.class);
            startActivity(BoysIntent);
        }
    }
    private void getUsers(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_CREATE_ACCOUNT, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                TextView textView = findViewById(R.id.users_list);
                Toast.makeText(Home.this, "Success: "+response.toString(), Toast.LENGTH_SHORT).show();
                textView.setText( response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Home.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }
}