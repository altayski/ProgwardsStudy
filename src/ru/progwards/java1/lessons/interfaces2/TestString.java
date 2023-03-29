package ru.progwards.java1.lessons.interfaces2;

public class TestString {
    public static void print(ToString any){
        System.out.println(any.getString());
    }

    public static void main(String[] args) {
        print(new Cow("Пеструшка", 270));
        print(new Duck("Даша", 3.3));
        print(new Hamster("Поликарп",0.32));
        print(new Time(1,12,55));
        print(new ComplexNum(22,5));

    }
}
