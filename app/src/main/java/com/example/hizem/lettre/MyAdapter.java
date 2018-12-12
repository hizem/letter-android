package com.example.hizem.lettre;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> users;
    private List<String> scores;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView username;
        public TextView score;


        public MyViewHolder(View v) {
            super(v);
            ConstraintLayout constLay = (ConstraintLayout)((LinearLayout )v).getChildAt(0);
            username = (TextView) constLay.getChildAt(0);
            score = (TextView) constLay.getChildAt(1);



        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String> users, List<String> scores) {
        this.users=users;
        this.scores=scores;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.score, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.username.setText(this.users.get(position));
        holder.score.setText(this.scores.get(position));






    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.users.size();
    }
}