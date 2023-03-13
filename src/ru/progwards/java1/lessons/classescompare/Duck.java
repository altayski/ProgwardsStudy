package ru.progwards.java1.lessons.classescompare;

public class Duck extends Animal {
    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.04;
    }

    Duck(String name){
        super(name);
    }

    @Override
    public String kind() {
        return "утка";
    }

    @Override
    public String say() {
        return "кря-кря" ;
    }
}
