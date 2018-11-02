package com.fkaps.glb;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    User user = new User("Default");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //sets the user welcome textview to the users name
        TextView tvUserName = (TextView)findViewById(R.id.tv_UserName);
        //sets a placeholder name. Place a ! in the if condition to enable original intention.
        if (user.getName().contains("Default")) {
            tvUserName.setText(user.getName() + " user");
        }

        //should start WorkoutListActivity
        ImageButton ibWorkoutList = (ImageButton) findViewById(R.id.ib_WorkoutList);
        ibWorkoutList.setOnClickListener((View) -> {
            Intent startWorkoutListIntent = new Intent(getApplicationContext(), WorkoutListActivity.class);
            //startWorkoutListIntent.putExtra() if you want to pass the user object (remember serilizer)
            startActivity(startWorkoutListIntent);
        });
        //starts new workout activity
        ImageButton ibNewWorkout = (ImageButton) findViewById(R.id.ib_NewWorkout);
        ibNewWorkout.setOnClickListener((View) -> {
            Intent startNewWorkOutIntent = new Intent(getApplicationContext(), NewWorkoutActivity.class);
            startActivity(startNewWorkOutIntent);
        });


    }

    //the values should come from the textview boxes?
    private void editUser(String name, int age, int height, double weight) {
        user.name = name;
        user.age = age;
        user.height = height;
        user.weight = weight;
    }


}
