package ru.progwards.java1.lessons.classescompare;

public class Hamster extends Animal {
    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.06;
    }

    Hamster(String name) {
        super(name);
    }

    @Override
    public String kind() {
        return "хомяк";
    }

    @Override
    public String say() {
        return "хрум-хрум-хрум";
    }
}
