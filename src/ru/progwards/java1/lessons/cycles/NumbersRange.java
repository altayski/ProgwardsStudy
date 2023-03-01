package ru.progwards.java1.lessons.cycles;

public class NumbersRange {
    public static long sumNumbers(int start, int finish) {
        long sum = 0;
        for (; start <= finish; start++) sum += start;
        return sum;
    }

    public static long sumOdd(int start, int finish) {
        long sum = 0;
        for (; start <= finish; start++) {
            if (start % 2 == 0)
                sum += start;
        }
        return sum;
    }

    public static long sumEvenIdx(int start, int finish) {
        long sum = 0;
        for (int index = 1; start <= finish;start++, index++) {
            if(index % 2 !=0) sum += start;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(1, 10));
        System.out.println(sumOdd(12, 22));
        System.out.println(sumEvenIdx(12,22));
    }
}
