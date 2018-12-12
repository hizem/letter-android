package com.example.hizem.lettre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Choices extends AppCompatActivity {
EditText edit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        edit =  (EditText)findViewById(R.id.editText9);

    }
    public void valider(View v){
        int a =getIntent().getIntExtra("number",7);
        String username=this.getIntent().getStringExtra("username");
        if((Integer.valueOf(edit.getText().toString())<=7) &&(Integer.valueOf(edit.getText().toString())>=0) ){
        Intent i = new Intent(this,BeginSolo.class);
        int b=Integer.valueOf(edit.getText().toString());
        i.putExtra("number",a);
        i.putExtra("number2",b);
        i.putExtra("username",username);
        startActivity(i);}else {
            Toast.makeText(this,"Le nombre doit étre entre 0 et "+a, Toast.LENGTH_LONG).show();

        }
    }
}
