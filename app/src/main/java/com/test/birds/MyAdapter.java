package com.test.birds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<BirdSet> mData=new ArrayList<>();
    private LayoutInflater mInflater;

    // data is passed into the constructor
    MyAdapter(Context context, ArrayList<BirdSet> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BirdSet animal = mData.get(position);
        holder.fBird.setText(animal.fBird);
        holder.sBird.setText(animal.sBird);
        holder.tBird.setText(animal.tBird);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView fBird;
        TextView sBird;
        TextView tBird;
        ViewHolder(View itemView) {
            super(itemView);
            fBird = itemView.findViewById(R.id.fBird);
            sBird = itemView.findViewById(R.id.sBird);
            tBird = itemView.findViewById(R.id.tBird);

        }

    }

}