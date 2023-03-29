package ru.progwards.java1.lessons.interfaces2;

public class ArraySort {
    public static void sort(CompareWeight[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i].getWeight() > a[j].getWeight()){
                    CompareWeight tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Car zil = new Car(12000);
        Car uaz = new Car(2000);
        Car lC = new Car(2700);
        Car oka = new Car(800);
        Car sub = new Car(1150);
        CompareWeight[] compareWeights = {zil, uaz, lC, oka, sub};
        sort(compareWeights);
        for(CompareWeight value : compareWeights){
            System.out.println(value);
        }
    }
}
