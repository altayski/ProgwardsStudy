package ru.progwards.java1.lessons.basics;

public class Astronomy {
    public static final double PI = 3.14;

    public static Double sphereSquare(Double r) {
        return 4 * PI * Math.pow(r, 2);
    }

    public static Double earthSquare() {
        return sphereSquare(6371.2);
    }

    public static Double mercurySquare() {
        return sphereSquare(2439.7);
    }

    public static Double jupiterSquare() {
        return sphereSquare(71492d);
    }

    public static Double earthVsMercury() {
        return earthSquare() / mercurySquare();
    }

    public static Double earthVsJupiter() {
        return earthSquare() / jupiterSquare();
    }

    public static void main(String[] args) {
        System.out.println("Площадь поверхности Земли " + earthSquare());
        System.out.println("Площадь поверхности Меркурия " + mercurySquare());
        System.out.println("Площадь поверхности Юпитера " + jupiterSquare());
        System.out.println("Отношение площади поверхности Земли к площади поверхности Меркурия " + earthVsMercury());
        System.out.println("Отношение площади поверхности Земли к площади поверхности Юпитера " + earthVsJupiter());

    }
}
