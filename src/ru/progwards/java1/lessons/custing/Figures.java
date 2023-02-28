package ru.progwards.java1.lessons.custing;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Figures {
    public static final double PI = 3.14;

    public static double circle(double r) {
        return PI * r * r;
    }

    public static double square(double n) {
        return n * n;
    }

    public static Double triangle(double k) {
        double p = (k + k + k) / 2;
        double result = Math.sqrt(p * ((p - k) * (p - k) * (p - k)));
        BigDecimal bd = new BigDecimal(result);
        BigDecimal roundOff = bd.setScale(11, RoundingMode.FLOOR);
        return roundOff.doubleValue();
    }

    public static double squareVsTraiange(double p) {
        return square(p) / triangle(p);
    }

    public static double squareVsCircle(double p) {
        double result = square(p) / circle(p);
        BigDecimal bd = new BigDecimal(result);
        BigDecimal floor = bd.setScale(16, RoundingMode.FLOOR);
        return floor.doubleValue();
    }

    public static double triangleVsCircle(double p) {
        return triangle(p) / circle(p);
    }

    public static void main(String[] args) {
        System.out.println(triangle(99.68727114192085));
        System.out.println(squareVsTraiange(4.0));
        System.out.println(squareVsCircle(20.66909005373059));
        System.out.println(triangleVsCircle(6.0));
    }
}
