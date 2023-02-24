package ru.progwards.java1.lessons.custing;

public class Figures {
    public static final double PI=3.14;

    public static double circle(double r){
        return PI*r*r;
    }
    public static double square(double n){
        return n*n;
    }
    public static Double triangle(double k){
        double p = (k+k+k)/2.0;
        return Math.sqrt(p*((p-k)*(p-k)*(p-k)));
    }
    public static double squareVsTriangle(double p){//исправлена опечатка squareVsTraiange
        return square(p)/triangle(p);
    }
    public static double squareVsCircle(double p){
      return   square(p)/circle(p);
    }
    public static double triangleVsCircle(double p){
        return triangle(p)/circle(p);
    }

    public static void main(String[] args) {
        System.out.println(triangle(12.75));
        System.out.println(squareVsTriangle(4.0));
        System.out.println(squareVsCircle(3.0));
        System.out.println(triangleVsCircle(6.0));
    }
}
