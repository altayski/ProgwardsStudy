package ru.progwards.java1.lessons.arrays1;

public class ArraySort {
    public static void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i] > a[j]){
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {-10, 22, 50, 34, -9, -1, - 345, 899, 17, 34, 35, 36, 34, 0, 17, 444, 0};
        sort(array);
    }
}
