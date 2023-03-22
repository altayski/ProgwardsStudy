package ru.progwards.java1.lessons.arrays1;



public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int maxInRow(int num) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[num].length; i++) {
            if (max < matrix[num][i]) {
                max = matrix[num][i];
            }
        }
        return max;
    }

    public int maxInCol(int num) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length - 1 < num) continue;
            if (max < matrix[i][num]) {
                max = matrix[i][num];
            }
        }
        return max;
    }

    public int max() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (maxInCol(i) > max) {
                max = maxInCol(i);
            }
        }
        return max;
    }

    public boolean isMatrix() {
        int countArray = matrix.length - 1;//количество одномерных массивов в двумерном массиве
        for (int[] ints : matrix) {//циклом проход по одномерным массивам (от 0 до countArray), сравнивая их длины
            if (matrix[countArray].length != ints.length) {
                return false;
            }
        }
        return true;
    }

    public int[][] transposition() {
        if (!isMatrix()) return null;
        int row = matrix[0].length;
        int column = matrix.length;
        int[][] rotateMatrix = new int[row][column];


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                rotateMatrix[j][i] = matrix[i][j];
            }
        }
        return rotateMatrix;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 4},
                       {4, 5,-6},
                       {7, 8, 6},
                       {8, 9, 10}};

        Matrix martix = new Matrix(mat);
      //  System.out.println("Максимальный элемент в строке массива " + martix.maxInRow(2));
       // System.out.println("Максимальный элемент в столбце массива " + martix.maxInCol(2));
       // System.out.println("Максимальный элемент в массиве " + martix.max());
        //System.out.println(martix.isMatrix());
       int[][] afterRotate =  martix.transposition();
        for (int i = 0; i < afterRotate.length; i++) {
            for (int j = 0; j < afterRotate.length; j++) {
                System.out.print(afterRotate[i][j]+" ");
            }
            System.out.println();
        }
    }
}
