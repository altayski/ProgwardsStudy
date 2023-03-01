package ru.progwards.java1.lessons.compare;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c) {
        int max;
        if (a > b) {
            max = a;
        } else max = b;
        if (max < c) {
            max = c;
        }
        return max;
    }

    public static int minSide(int a, int b, int c) {
        int min;
        if (a < b) {
            min = a;
        } else min = b;
        if (min > c) {
            min = c;
        }
        return min;
    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {
        if (a == b & a == c) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        System.out.println(maxSide(6, 1, 1));
        System.out.println(maxSide(3, 2, 4));
        System.out.println(maxSide(4, 4, 4));
        System.out.println(maxSide(1, 10, 7));


        System.out.println(minSide(1, 4, 3));
        System.out.println(minSide(6, 1, 1));
        System.out.println(minSide(2, 4, 4));

        System.out.println(isEquilateralTriangle(2, 2, 3));
        System.out.println(isEquilateralTriangle(2, 3, 2));
        System.out.println(isEquilateralTriangle(3, 2, 2));
        System.out.println(isEquilateralTriangle(2, 2, 2));
        System.out.println(isEquilateralTriangle(3, 3, 3));
    }

}