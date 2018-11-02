package com.fkaps.glb;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class NewWorkoutActivity extends AppCompatActivity {

    private static final String TAG = "NewWorkOutActivity";
    RecyclerView newWorkoutRecyclerView;
    ArrayList<Workout> currentWorkoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);
        Log.d(TAG, "onCreate: ");

        currentWorkoutList = new ArrayList<>();

        initRecyclerView();

        //adds a workout to the recyclerview. the workout fields are populated from the (user inputted) text fields.
        Button btnAddNewExercise = findViewById(R.id.btnAddNewExcercise);

        btnAddNewExercise.setOnClickListener(View -> {
            //fetches the adapter used in initRecyclerView.
            RecyclerViewAdapter mAdapter = (RecyclerViewAdapter) newWorkoutRecyclerView.getAdapter();

            //finds the textfields.
            TextView tvExerciseName = findViewById(R.id.tvExerciseName);
            EditText etReps = findViewById(R.id.etReps);
            EditText etSets = findViewById(R.id.etSets);
            EditText etWeight = findViewById(R.id.etWeight);

            int reps, sets, weight;
            String excName = tvExerciseName.getText().toString();

            //the exerciseName textfield and weight text field should not be empty when adding an item. A fatal error will occur if so.
            if (tvExerciseName.getText() != "" && etWeight.getText().length() > 1) {
                reps = Integer.valueOf(etReps.getText().toString());
                sets = Integer.valueOf(etSets.getText().toString());
                weight = Integer.valueOf(etWeight.getText().toString());

                Workout workout = new Workout(excName, reps, sets, weight);
                mAdapter.addItem(workout);
                mAdapter.notifyItemInserted(currentWorkoutList.size() - 1);

                tvExerciseName.setText(null);
                etWeight.getText().clear();
            }
        });

    }

    //init the recycler view if the array contains data, otherwise the app crashes.
    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: ");
        newWorkoutRecyclerView = findViewById(R.id.newWorkoutRecyclerView);

        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(currentWorkoutList, this);
        newWorkoutRecyclerView.setAdapter(mAdapter);
        newWorkoutRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
