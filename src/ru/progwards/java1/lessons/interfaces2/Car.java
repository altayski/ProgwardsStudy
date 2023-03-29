package ru.progwards.java1.lessons.interfaces2;

public class Car implements CompareWeight {
    private double weight;

    Car(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Это автомобиль грузоподъемностью "+this.weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight) {
        CompareResult result = null;
        if(this.getWeight()<smthHasWeight.getWeight()) result = CompareResult.LESS;
        else if (this.getWeight() == smthHasWeight.getWeight()) result = CompareResult.EQUAL;
        else if (this.getWeight() > smthHasWeight.getWeight()) result= CompareResult.CREATER;
        return result;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}

