package com.example.hizem.lettre;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scores extends AppCompatActivity {
    public RecyclerView mRecyclerView ;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> users= new ArrayList<>();
    private List<String> scores = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler);

        SharedPreferences sharedScores = this.getSharedPreferences("scores",Context.MODE_PRIVATE);
        Set<String> listUsers=sharedScores.getStringSet("listusers",new HashSet<String>());

        Iterator it= listUsers.iterator();

        while(it.hasNext()){
            String username=it.next().toString();
            users.add(username);
            scores.add(sharedScores.getString(username,"0"));
            Log.d("hello world :","");
        }


        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(users,scores);
        mRecyclerView.setAdapter(mAdapter);
    }
}
