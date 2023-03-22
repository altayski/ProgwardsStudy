package ru.progwards.java1.lessons.arrays2;

import java.util.Arrays;

public class IntArrays {

    public static String toString(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        int maxLength = a.length - 1;//количество элементов
        if (maxLength == -1) return "[]";// для пустого массива
        int i = 0;//если 1 и более элементов, пойдет цикл
        while (i <= maxLength) {
            sb.append(a[i]);
            if (i == maxLength)//после последнего элемента добавить скобку и вернуть строку
                return sb.append("]").toString();
            sb.append(", ");
            i++;
        }
        return sb.toString();//?
    }


    private static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static boolean equals1(int[] a1, int[] a2) {
        boolean equals = true;
        if (a1.length != a2.length) return false;
        if (a1.length > 0) {
            sort(a1);
            sort(a2);
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                equals = false;
                break;
            }
        }
        return equals;
    }

    public static boolean equals2(int[] a1, int[] a2){
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1,a2);
    }


    public static void main(String[] args) {
        int[] m = {1,2,3};
        int[] n = {1,5,3};
        int[] t = {1,2,3};
        int[] c = {3,2,1};
        int[] x = {1,2};

        System.out.println(equals1(m,t));//одинаковые массивы
        System.out.println(equals1(t,m));//симметричность
        System.out.println(equals1(m, n));//разные массивы
        System.out.println(equals1(c,m));//перевернутый массив
        System.out.println(equals1(m,c));
        System.out.println(equals1(x,m));//

    }
}
