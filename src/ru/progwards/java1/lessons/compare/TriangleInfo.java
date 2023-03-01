package ru.progwards.java1.lessons.compare;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c) {
        return (a < (b + c)) && (b < (a + c)) && (c < (a + b));
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        boolean isOk = true;
        if (a > b && a > c) {
            if (a * a == b * b + c * c)
                return isOk;
        }

        if (b > a && b > c) {
            if (b * b == a * a + c * c)
                return isOk;
        }

        if (c > a && c > b) {
            if (c * c == b * b + a * a)
                return isOk;
        }
        return false;
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        return a == b || b == c || c == a;
    }

    public static void main(String[] args) {
        System.out.println(isTriangle(1, 2, 3));
        System.out.println(isRightTriangle(10, 24, 26));
        System.out.println(isIsoscelesTriangle(2, 2, 3));
        System.out.println(isIsoscelesTriangle(2, 3, 2));
        System.out.println(isIsoscelesTriangle(3, 2, 2));
        System.out.println(isIsoscelesTriangle(2, 2, 2));
        System.out.println(isIsoscelesTriangle(1, 2, 1));

    }
}