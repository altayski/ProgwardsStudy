package ru.progwards.java1.lessons.interfaces2;

public class CompareHome {
    public static boolean sameHome(Home h1, Home h2){
        System.out.println("Результат сравнения "+h1.getClass().getSimpleName()+" и "+h2.getClass().getSimpleName()+" равен "+h1.getHome().equals(h2.getHome()));
        return h1.getHome().equals(h2.getHome());
    }

    public static void main(String[] args) {
        Cow cow = new Cow("Пеструшка");
        Duck duck = new Duck("Соня");
        sameHome(cow,duck);//корова - утка
        Hamster akakiy = new Hamster("Акакий");
        sameHome(cow,akakiy);//корова - хомяк
        Hawk hawk = new Hawk();
        sameHome(cow,hawk);//корова - ястреб
        sameHome(duck,akakiy);//утка - хомяк
        sameHome(duck,hawk);//утка - ястреб
        sameHome(akakiy,hawk);//хомяк - ястреб
    }
}
