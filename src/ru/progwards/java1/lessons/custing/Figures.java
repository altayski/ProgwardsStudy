package ru.progwards.java1.lessons.custing;


public class Figures {
    public static final double PI = 3.14;

    public static double circle(double r) {
        return r * r * PI;
    }

    public static double square(double n) {
        return n * n;
    }

    public static Double triangle(double k) {
        double p = (k + k + k) / 2;
        return Math.sqrt(p * (p - k) * (p - k) * (p - k));
    }

    public static double squareVsTraiange(double p) {
        return square(p) / triangle(p);
    }

    public static double squareVsCircle(double p) {
        return square(p) / circle(p);

    }

    public static double triangleVsCircle(double p) {
        return triangle(p) / circle(p);
    }

    public static void main(String[] args) {
        System.out.println(triangle(99.68727114192085));
        System.out.println(squareVsTraiange(4.0));
        System.out.println(squareVsCircle(20.66909005373059));
        System.out.println(circle(63.53645536658023));
        System.out.println(circle(63.53645536658023));
    }
}
