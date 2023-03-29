package ru.progwards.java1.lessons.interfaces2;



public class Cow extends Animal {
    @Override
    public Color getColor() {
        return Color.RED;
    }
    public Cow(String name, double weight) {
        super(name, weight);

    }

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

    @Override
    public String getHome() {
        return "ферма";
    }
}
