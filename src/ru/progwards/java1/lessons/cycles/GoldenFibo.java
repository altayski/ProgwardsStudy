package ru.progwards.java1.lessons.cycles;

public class GoldenFibo {
    public static int fiboNumber(int n) {
        int num1Start = 1;
        int num2Start = 1;
        if (n == 1) return num1Start;
        int fiboNum = 0;
        for (int i = 3; i <= n; i++) {
            fiboNum = num1Start + num2Start;
            num1Start = num2Start;
            num2Start = fiboNum;
        }
        return fiboNum;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        if (a == b && ((double) a / c) > 1.61703 && ((double) a / c) < 1.61903) {
            return true;
        }
        if (b == c && ((double) b / a) > 1.61703 && ((double) b / a) < 1.61903) {
            return true;
        }
        if (a == c && ((double) a / b) > 1.61703 && ((double) a / b) < 1.61903) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(fiboNumber(2));
        for (int i = 3; i <= 15; i++) {
            System.out.print(fiboNumber(i) + " ");
        }
        System.out.println();
        for (int i = 3; i < 15; i++)
            System.out.print(isGoldenTriangle(fiboNumber(i), fiboNumber(i), fiboNumber(i - 1)) + " ");
    }
}


