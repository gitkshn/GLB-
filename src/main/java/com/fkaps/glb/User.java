package com.fkaps.glb;

public class User {
    String name;
    int age;
    double bmi;
    double weight;
    int height;

    //not sure if it should be used.
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi() {
        if (0 < this.height && 0 < this.weight) {
            double height = (double) this.height / 100;
            double weight = this.weight;
            this.bmi = weight / (height * height);
        }
        else {
            this.bmi = -1;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0 && 220 < weight) {
            this.weight = -1;
        }
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
