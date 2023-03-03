package ru.progwards.java1.lessons.cycles;

public class GoldenFibo {
    public static int fiboNumber(int n) {
        int num1Start = 1;
        int num2Start = 1;
        if (n == 1) return num1Start;
        if (n == 2) return num2Start;
        int fiboNum = 0;
        for (int i = 3; i <= n; i++) {
            fiboNum = num1Start + num2Start;
            num1Start = num2Start;
            num2Start = fiboNum;
        }
        return fiboNum;
    }
    /*

В этой задаче не существенно, но в принципе, для дальнейшей поддержки программы лучше вычислительную часть выносить в отдельную функцию.
В данном случае можно сделать функцию с двумя параметрами, которая производит деление и сравнение.
     */
    public static boolean comp(int a, int b){
        return ((double) a / b) > 1.61703 && ((double) a / b) < 1.61903;//добавил метод вычисления и сравнения
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        if (a == b && comp(a,c)) {
            return true;
        }
        if (b == c &&  comp(b,a)) {
            return true;
        }
        if (a == c && comp(a,b)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
       for (int i = 3; i <= 15; i++) {//  вывожу первые 15 чисел Фибоначчи
           System.out.print(fiboNumber(i) + " ");
        }
        System.out.println();
        int i = 3;
        while (fiboNumber(i) <= 100) {
            boolean goldenTriangle = isGoldenTriangle(fiboNumber(i), fiboNumber(i-1), fiboNumber(i));
            if(goldenTriangle){
                System.out.print("Длина основания "+ fiboNumber(i-1)+", ");
                System.out.println("длина одного ребра "+fiboNumber(i)+", длина второго ребра "+fiboNumber(i)+".");
            }
            i++;
        }
    }
}

