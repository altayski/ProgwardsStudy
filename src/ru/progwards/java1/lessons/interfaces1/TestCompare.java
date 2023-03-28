package ru.progwards.java1.lessons.interfaces1;

import java.util.Arrays;

public class TestCompare {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cow("Пестушка", 350),
                new Cow("Рыжая", 250),
                new Duck("Даша", 3),
                new Duck("Маша", 3.5),
                new Hamster("Акакий", 0.25),
                new Hamster("Поликарп", 0.32)
        };
        Arrays.sort(animals);
        System.out.println(Arrays.toString(animals));


    }
}
