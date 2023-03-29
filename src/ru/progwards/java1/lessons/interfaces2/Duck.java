package ru.progwards.java1.lessons.interfaces2;



public class Duck extends Animal {
    @Override
    public Color getColor(){
        return Color.GRAY;
    }
    public Duck(String name, double weight){
        super(name, weight);
    }
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

    @Override
    public String getHome() {
        return "ферма";
    }
}
