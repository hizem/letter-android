package com.example.hizem.lettre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
    }
    public void soloMode(View v){
        String username=this.getIntent().getStringExtra("username");
        Intent i = new Intent(this,Lettre.class);
        i.putExtra("username",username);
        startActivity(i);
    }
    public void adminisration(View v){
        Intent i = new Intent(this,Administration.class);
        startActivity(i);
    }
    public void scores(View v){
        Intent i = new Intent(this,Scores.class);
        startActivity(i);
    }
}
