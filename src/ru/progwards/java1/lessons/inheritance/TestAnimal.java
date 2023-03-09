package ru.progwards.java1.lessons.inheritance;

public class TestAnimal {
    public static void printAnimal(Animal animal){
        System.out.println(animal+" - "+animal.say()+"!");
    }

    public static void main(String[] args) {
        Cow pestushka = new Cow("Пеструшка");
        printAnimal(pestushka);
        Cow cowRedHead = new Cow("Рыжая");
        printAnimal(cowRedHead);
        Duck dasha = new Duck("Даша");
        printAnimal(dasha);
        Duck masha = new Duck("Маша");
        printAnimal(masha);
        Hamster akakij = new Hamster("Акакий");
        printAnimal(akakij);
        Hamster polikarp = new Hamster("Поликарп");
        printAnimal(polikarp);
    }
}
