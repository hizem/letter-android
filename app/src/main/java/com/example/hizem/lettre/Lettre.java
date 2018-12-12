package com.example.hizem.lettre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Lettre extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lettre);
    }

    @Override
    public void onClick(View v) {
        String username=this.getIntent().getStringExtra("username");
        Intent i = new Intent(this,Choices.class);
        if(v.getId() == R.id.button6){
            i.putExtra("number",7);
            i.putExtra("username",username);
            startActivity(i);
        }else if(v.getId() == R.id.button7){
            i.putExtra("number",9);
            i.putExtra("username",username);
            startActivity(i);
        }else if(v.getId() == R.id.button8){
            i.putExtra("number",8);
            i.putExtra("username",username);
            startActivity(i);
        }else if(v.getId()==R.id.button9){
            i.putExtra("number",10);
            i.putExtra("username",username);
            startActivity(i);
        }
    }
}
