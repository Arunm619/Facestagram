package com.arunsudharsan.facestagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PasswordsCollector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwords_collector);
        Button btn_letsgo = (Button) findViewById(R.id.btn_letsgo);
        ImageButton fb= (ImageButton)findViewById(R.id.fbbutton);
        ImageButton ig= (ImageButton) findViewById(R.id.igbutton);
        btn_letsgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasswordsCollector.this,FacebookPassword.class);
                startActivity(i);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasswordsCollector.this, FacebookPassword.class);
                startActivity(i);
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasswordsCollector.this, InstagramPassword.class);
                startActivity(i);
            }
        });
    }
}
