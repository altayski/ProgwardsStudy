package ru.progwards.java1.lessons.classescompare;

public class Cow extends Animal {
    @Override
    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        return 0.05;
    }

    Cow(String name) {
        super(name);
    }

    @Override
    public String kind() {
        return "корова";
    }

    @Override
    public String say() {
        return "мууууууу";
    }
}
