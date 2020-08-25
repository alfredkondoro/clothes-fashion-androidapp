package com.example.clothesfashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username_input;
    private EditText password_input;
    private static final String URL_LOGIN = "http://192.168.43.225/mo/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button loginBtn = findViewById(R.id.login_btn);
        TextView createBtn = findViewById(R.id.create_account_btn);

        username_input = findViewById(R.id.username_login);
        password_input = findViewById(R.id.password_login);

        loginBtn.setOnClickListener(this);
        createBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.login_btn){
            String username = username_input.getText().toString().trim();
            String password = password_input.getText().toString().trim();
            if (!(username.isEmpty() || password.isEmpty())){
                login(username,password);
                //TODO: comment this
//              Intent HomeIntent = new Intent(this,Home.class);
//            startActivity(HomeIntent);
            }
            else {
                if(username.isEmpty() && !password.isEmpty()){
                    Toast.makeText(this, "Pleas enter your username", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty() && !username.isEmpty()){
                    Toast.makeText(this, "Pleas enter your  password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Pleas enter your username and password", Toast.LENGTH_SHORT).show();
                }

            }
        }

        if(view.getId() == R.id.create_account_btn){
            Intent RegisterIntent = new Intent(this,Register.class);
            startActivity(RegisterIntent);
        }
    }
    private void login(final String name, final String password){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Login Successful")){
                    Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    Intent HomeIntent = new Intent(MainActivity.this,Home.class);
                startActivity(HomeIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email",name);
                params.put("password",password);
                return  params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }
}