package ru.progwards.java1.lessons.wrappers;

public class AccuracyDoubleFloat {
    public static final Float PI = 3.14f;

    public static double volumeBallDouble(double radius) {

        return 4.0 / 3 * PI * (Math.pow(radius, 3));
    }

    public static Float volumeBallFloat(Float radius) {
        return 4.0f / 3.0f * PI * radius*radius*radius;
    }

    public static Double calculateAccuracy(Double radius) {
        return volumeBallDouble(radius) - volumeBallFloat(radius.floatValue());
    }

    public static void main(String[] args) {

        System.out.println("Метод Double " + volumeBallDouble(1));
        System.out.println("Метод Float " + volumeBallFloat(1f));
        System.out.println(calculateAccuracy(6371.2));
    }
}
