package com.arunsudharsan.facestagram;

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

public class InstagramPassword extends AppCompatActivity implements View.OnClickListener{


    private Button saveig;
    private EditText usernameig;
    private EditText pwdig;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_password);

        saveig = (Button) findViewById(R.id.igsaveBtn);
        usernameig = (EditText) findViewById(R.id.ignameEditText);
        pwdig = (EditText) findViewById(R.id.igpwdEditText);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        Button btn_letsgo = (Button) findViewById(R.id.btn_letsgo);
        btn_letsgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InstagramPassword.this,MainActivity.class);
                startActivity(i);
            }
        });
        saveig.setOnClickListener(this);
    }
    private void saveUserinfo() {


        String igusername = usernameig.getText().toString().trim();
        String igpassword = pwdig.getText().toString().trim();

        if(TextUtils.isEmpty(igusername))
        {
            Toast.makeText(this,"Enter Username!",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(igpassword))
        {
            Toast.makeText(this,"Enter password!",Toast.LENGTH_SHORT).show();


            return;
        }

        iguserinfo iguserinfo = new iguserinfo(igusername,igpassword);

        databaseReference.child("Instagram"+igusername+"  ").setValue(iguserinfo);
        Toast.makeText(this,"Successfully Logged In! Hit Lets Go!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view ==saveig)
        {
            saveUserinfo();
        }
    }
}
