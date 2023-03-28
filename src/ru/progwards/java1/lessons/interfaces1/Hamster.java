package ru.progwards.java1.lessons.interfaces1;

public class Hamster extends Animal {
    public Hamster(String name, double weight){
        super(name, weight);
    }
    @Override
    public Color getColor(){
        return Color.BEIGE;
    }
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
