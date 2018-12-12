package com.example.hizem.lettre;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class BeginSolo extends AppCompatActivity {
TextView txt,time,score ;
EditText edit;
ProgressBar prg;
RadioButton radiofr;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_solo);
        txt=(TextView)findViewById(R.id.textView10);
        edit=(EditText)findViewById(R.id.editText6);
        radiofr=(RadioButton)findViewById(R.id.radioButton5);
        prg=(ProgressBar)findViewById(R.id.progressBar);
        img=(ImageView)findViewById(R.id.imageView);
        time=(TextView)findViewById(R.id.textView3);
        score=(TextView)findViewById(R.id.textView17);
        int a=getIntent().getIntExtra("number",7);
        int voyelle=getIntent().getIntExtra("number2",2);
        StringBuffer buffer= new StringBuffer();
        Data d = Data.getInstance();
        List<Character> voyList= new ArrayList<Character>();
        List<Character> conList= new ArrayList<Character>();
        for(int k=0;k<voyelle;k++){
            Character character=d.getVoyelle();
            voyList.add(character);
            buffer.append(character);
        }
        for(int k1=voyelle;k1<a;k1++){
            Character character1=d.getConsonne();
            conList.add(character1);
            buffer.append(character1);
        }
        String s = buffer.toString();

        txt.setText(s);



    }
    public void getWord(View v){
        if(Data.scores<10) {
            Data data = Data.getInstance();
            List<Character> charList = new ArrayList<Character>();
            String text = txt.getText().toString();
            for (int i = 0; i < text.length(); i++) {
                charList.add(text.charAt(i));
            }
            String largest = "";
            if (radiofr.isChecked()) {
                largest = data.LargestWordFr(charList);
            } else {
                largest = data.LargestWordEn(charList);
            }
            if (edit.getText().toString().equals(largest) && !largest.equals("")) {
                Toast.makeText(this, "Good", Toast.LENGTH_LONG).show();
                int progress = 0;
                progress = prg.getProgress();
                progress++;
                Data.scores++;
                prg.setProgress(progress);
                img.setImageResource(R.drawable.smile);
            } else if (largest.equals("")) {
                Toast.makeText(this, "There isn't any word match these letters", Toast.LENGTH_LONG).show();
                img.setImageResource(R.drawable.sad);
            } else {
                Toast.makeText(this, "The largest word using these letters is : " + largest, Toast.LENGTH_LONG).show();
                img.setImageResource(R.drawable.sad);
            }


        }else{
            Toast.makeText(this,"you have the max number of points",Context.MODE_PRIVATE).show();
        }
        score.setText("Score : "+String.valueOf(Data.scores));
    }

    public void generate(View v){

        int a=getIntent().getIntExtra("number",7);
        int voyelle=getIntent().getIntExtra("number2",2);
        StringBuffer buffer= new StringBuffer();
        Data d = Data.getInstance();
        List<Character> voyList= new ArrayList<Character>();
        List<Character> conList= new ArrayList<Character>();
        for(int k=0;k<voyelle;k++){
            Character character=d.getVoyelle();
            voyList.add(character);
            buffer.append(character);
        }
        for(int k1=voyelle;k1<a;k1++){
            Character character1=d.getConsonne();
            conList.add(character1);
            buffer.append(character1);
        }
        String s = buffer.toString();

        txt.setText(s);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String username=this.getIntent().getStringExtra("username");
        SharedPreferences shared = this.getSharedPreferences("scores",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(username,score.getText().toString());
        Set<String> listUsers= new HashSet<>();
        listUsers= shared.getStringSet("listusers",listUsers);
        listUsers.add(username);
        editor.putStringSet("listusers",listUsers);
        editor.commit();
        Data.scores=0;
    }
}
