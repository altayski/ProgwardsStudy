
package ru.progwards.java1.lessons.date;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class BubbleTest {
    public static final int COUNT = 100000;

    public static void fill(Integer[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < COUNT; i++) {
            int n;
            do {
                n = ThreadLocalRandom.current().nextInt();
            } while (map.containsKey(n));
            a[i] = n;
            map.put(n, n);
        }
    }

    public static void bubbleSort(Integer[] a) {
        long[] timeResult = new long[5];
        long totalTime = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                long start1 = System.currentTimeMillis();
                int n = j + 1;
                long start2 = System.currentTimeMillis();
                if (a[j].compareTo(a[n]) < 0) {
                    long start3 = System.currentTimeMillis();
                    Integer tmp = a[j];
                    long start4 = System.currentTimeMillis();
                    a[j] = a[n];
                    long start5 = System.currentTimeMillis();
                    a[n] = tmp;
                    long start6 = System.currentTimeMillis();

                    timeResult[0] += start2 - start1;
                    timeResult[1] += start3 - start2;
                    timeResult[2] += start4 - start3;
                    timeResult[3] += start5 - start4;
                    timeResult[4] += start6 - start5;
                }
            }
        }
        for (long l : timeResult) {
            totalTime += l;
        }
        System.out.println("Общее время выполнения: " + totalTime + " мс");
        System.out.println("Таблица процентного соотношения выполнения строк кода:");
        System.out.println(" Строка\t| Время выполнения (мс) | Процент выполнения |");
       for (int i = 0; i < timeResult.length; i++) {
           double percento = ((double) timeResult[i] / totalTime) * 100;
            System.out.printf("\t%d \t\t\t  %d \t  \t\t\t%.2f%% \t\t \n", i + 1, timeResult[i], percento);
       }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[COUNT];
        fill(a);
        bubbleSort(a);
    }

}
