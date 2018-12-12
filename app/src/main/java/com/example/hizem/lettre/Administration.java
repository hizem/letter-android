package com.example.hizem.lettre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Administration extends AppCompatActivity {
TextView word,wordl;
RadioButton rEn,rFr,rlFr,rlEn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);
        word = (TextView) findViewById(R.id.editText7);
        rFr = (RadioButton) findViewById(R.id.radioButton);
        rEn = (RadioButton) findViewById(R.id.radioButton2);
        rlFr=(RadioButton)findViewById(R.id.radioButton3);
        rlEn=(RadioButton)findViewById(R.id.radioButton4);
        wordl=(TextView)findViewById(R.id.textView15);
    }
    public void addDictionnary(View v){
          Data d = Data.getInstance();
          if(rFr.isChecked()){
              d.addFr(word.getText().toString());
          }else if(rEn.isChecked()){
              d.addEn(word.getText().toString());
          }

    }
    public void largestWord(View v){
        Data d=Data.getInstance();
        if(rlFr.isChecked()){
            String maxWord="";
            for(String i : d.getDictionnaryFr()){
                if(i.length()>maxWord.length()){
                    maxWord=i;
                }
            }
            wordl.setText(maxWord);
        }else if(rlEn.isChecked()){
            String maxWord="";
            for(String i : d.getDictionnaryEn()){
                if(i.length()>maxWord.length()){
                    maxWord=i;
                }
            }
            wordl.setText(maxWord);
        }
    }
}
