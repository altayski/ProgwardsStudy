package ru.progwards.java1.lessons.interfaces2;



public abstract class Animal implements IColor, Comparable<Animal>, Home, ToString, CompareWeight{
    enum FoodKind {
        HAY,
        CORN
    }
    String name;
    double weight;
    Animal(String name, double weight){//конструктор имя, вес
        this.name = name;
        this.weight = weight;
    }

    abstract public FoodKind getFoodKind();//возвращает вид еды, которое ест животное

    abstract public double getFoodCoeff();//возвращает коэффициент веса еды к весу животного

    public double calculateFoodWeight() {
        return this.getWeight() * this.getFoodCoeff();
    }

    public double calculateFoodPrice() {
        if (this.getFoodKind() == FoodKind.HAY) {
            return calculateFoodWeight() * 2;
        } else if (this.getFoodKind() == FoodKind.CORN) {
            return calculateFoodWeight() * 15;
        } else return 0;
    }
    public Animal(String name) {
        this.name = name;
    }

    public abstract String kind();

    public abstract String say();

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    public int compareTo(Animal animal) {// модификатор на public с default
        return Double.compare(this.weight, animal.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.weight, weight) == 0 && name.equals(animal.name);
    }

    @Override
    public String getString() {
        return toString();//добавлен
    }

    @Override
    public String toString() {
        return "Это " + this.kind() + " " + this.name+" "+this.weight+" "+this.getColor();
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight) {
        CompareResult result = null;
        if(this.getWeight()<smthHasWeight.getWeight()) result = CompareResult.LESS;
        else if (this.getWeight() == smthHasWeight.getWeight()) result = CompareResult.EQUAL;
        else if (this.getWeight() > smthHasWeight.getWeight()) result= CompareResult.CREATER;
        return result;
    }
}
