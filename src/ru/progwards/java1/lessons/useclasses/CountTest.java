package ru.progwards.java1.lessons.useclasses;


public class CountTest {
    public static void testInc(int count) {
        Count count1 = new Count();
        for (int i = 0; i < count; i++) {
            count1.inc();
            System.out.print(count1.getCount() + " ");
        }
        System.out.println("тест inc окончен");
    }

    public static void testDec(int count) {
        Count countWithCount = new Count(count);
        do {
            countWithCount.dec();
            System.out.print(countWithCount.getCount() + " ");
            if (countWithCount.getCount() == 0) {
                System.out.print('\n' + "count равен 0");
            }
        } while (countWithCount.getCount() > 0);
        System.out.println('\n' + "тест dec окончен");

    }

    public static void main(String[] args) {
        testInc(7);
        testInc(0);
        testInc(-1);
        testDec(9);
        testDec(0);
        testDec(-5);

    }
}
