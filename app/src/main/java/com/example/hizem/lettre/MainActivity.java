package com.example.hizem.lettre;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit= (EditText)findViewById(R.id.editText);
    }
    public void login(View v){
        Intent i = new Intent(this,Mode.class);
        i.putExtra("username",edit.getText().toString());
        startActivity(i);
    }

}
