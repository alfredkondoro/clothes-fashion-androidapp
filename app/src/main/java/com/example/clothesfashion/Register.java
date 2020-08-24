package com.example.clothesfashion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText username_input;
    private EditText email_input;
    private EditText phonenumber_input;
    private EditText password_input;
    private EditText confirmpassword_input;
    private static final String URL_CREATE_ACCOUNT = "http://192.168.43.72/mo/create_account.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerbtn = findViewById(R.id.register_btn);

        username_input = findViewById(R.id.username_register);
        email_input = findViewById(R.id.email_register);
        phonenumber_input = findViewById(R.id.phonenumber_register);
        password_input = findViewById(R.id.password_register);
        confirmpassword_input = findViewById(R.id.password2_register);

        registerbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.register_btn){
            //Intent MainActivityIntent = new Intent(this,MainActivity.class);
            //startActivity(MainActivityIntent);

            String username = username_input.getText().toString().trim();
            String email = email_input.getText().toString().trim();
            String phonenumber = phonenumber_input.getText().toString().trim();
            String password = password_input.getText().toString().trim();
            String confirmpassword = confirmpassword_input.getText().toString().trim();


            if (!(username.isEmpty() || email.isEmpty() || phonenumber.isEmpty() || password.isEmpty() || confirmpassword.isEmpty())){
                if (password.equals(confirmpassword)){
                    try {
                        createAcount(username,email,phonenumber,password);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Intent MainActivityIntent =new Intent(this,MainActivity.class);
                    startActivity(MainActivityIntent);
                }
                else {
                    Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                if ((username.isEmpty() || email.isEmpty() || phonenumber.isEmpty() || password.isEmpty() || confirmpassword.isEmpty())){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }

    public void createAcount(final String name, final String email, final String phone_number, final String password) throws JSONException {

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CREATE_ACCOUNT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Register.this, "Success"+response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Register.this, "Fail"+error, Toast.LENGTH_SHORT).show();
                System.out.println("ERROR: "+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name",name);
                params.put("email",email);
                params.put("phone_number",phone_number);
                params.put("password",password);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }
}