package com.fkaps.glb;

public class Workout {
    //is id usable? number of workout in this session or something? static id to tally the number of exc?
    private int id;
    //the fields it should have.
    private String name;
    private int reps = 12;
    private int sets = 3;
    private int weight = 0;
    //bonus things. Shows the previous workout stats for easy overview.
    private int prevReps;
    private int prevSets;
    private int prevWeight;

    //constructor with name as input.
    public Workout(String name) {
        this.name = name;
    }

    //constructor with all the required fields to complete the workout.
    public Workout(String name, int reps, int sets, int weight) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
    }
    public String what() {
        return null;
    }

    public String formatToString() {
        return "Workout:" + name +
                "reps=" + reps +
                "sets" + sets +
                "weight" + weight;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", reps=" + reps +
                ", sets=" + sets +
                '}';
    }
    //NO GETTER OR SETTER FOR ID AT THE MOMENT.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrevReps() {
        return prevReps;
    }

    public void setPrevReps(int prevReps) {
        this.prevReps = prevReps;
    }

    public int getPrevSets() {
        return prevSets;
    }

    public void setPrevSets(int prevSets) {
        this.prevSets = prevSets;
    }

    public int getPrevWeight() {
        return prevWeight;
    }

    public void setPrevWeight(int prevWeight) {
        this.prevWeight = prevWeight;
    }
}
