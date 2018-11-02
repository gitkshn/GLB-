package com.fkaps.glb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    //sets the tag for debugging.
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Workout> mWorkoutList;
    private Context mContext;
    //constructor.
    public RecyclerViewAdapter(ArrayList<Workout> mWorkoutList, Context mContext) {
        this.mWorkoutList = mWorkoutList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_workout_detail, parent,false);
        return new ViewHolder(view);
    }
    //fills the data into the recyclerviewer.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called. ");

        //when you scroll down the list, this method is called and it is used to update the list with
        //new data at the ith position. Try to compile and see if it works without as the list is not long.
        holder.tvListExerciseName.setText(mWorkoutList.get(position).getName());
        holder.tvRepsAndSets.setText(String.valueOf(mWorkoutList.get(position).getReps() + " x " + mWorkoutList.get(position).getSets()));
        holder.tvWeightKG.setText(String.valueOf(mWorkoutList.get(position).getWeight() + " KG"));

        holder.mRelativeLayout.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Clicked on: " + mWorkoutList.get(position));
            Toast.makeText(mContext, mWorkoutList.get(position).getName() + " Toast tested", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return mWorkoutList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvListExerciseName;
        TextView tvRepsAndSets;
        TextView tvWeightKG;
        GridLayout mRelativeLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            tvListExerciseName = itemView.findViewById(R.id.tvListExerciseName);
            tvRepsAndSets = itemView.findViewById(R.id.tvRepsAndSets);
            tvWeightKG = itemView.findViewById(R.id.tvWeightKG);
            mRelativeLayout = itemView.findViewById(R.id.mRelativeLayout);
        }
    }
    void addItem(Workout workout) {
        Log.d(TAG, "addItem: ");

        mWorkoutList.add(workout);

    }
}
