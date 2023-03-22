package ru.progwards.java1.lessons.arrays2;

public class DIntArray {
    private int[] array;

    public DIntArray() {
        array = new int[0];
    }

    public DIntArray(int[] array) {
        this.array = array;
    }

    public void add(int num) {//добавляет элемент num  в конец массива array
        int[] arrayCopy = new int[array.length + 1];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        arrayCopy[arrayCopy.length - 1] = num;
        array = arrayCopy;
    }

    public void atInsert(int pos, int num) {
        int[] arrayInsert = new int[array.length + 1];
        System.arraycopy(array, 0, arrayInsert, 0, pos);
        arrayInsert[pos] = num;
        for (int i = pos; i < array.length; i++) {
            arrayInsert[++pos] = array[i];
        }
    }

    public void atDelete(int pos) {
        int[] arrayDel = new int[array.length - 1];
        System.arraycopy(array, 0, arrayDel, 0, pos);
        for (int i = pos + 1; i < array.length; i++) {
            arrayDel[pos++] = array[i];
        }
    }

    public int at(int pos) {
        int element = 0;
        if (pos < array.length) {
            for (int i = 0; i < array.length; i++) {
                element = array[pos];
            }
        }
        return element;
    }

    public static void main(String[] args) {


        DIntArray dIntArray1 = new DIntArray();

        dIntArray1.add(82);
        dIntArray1.add(3);
        dIntArray1.add(14);
        dIntArray1.add(16);
        dIntArray1.add(-78);
        dIntArray1.add(40);
        dIntArray1.add(58);
        System.out.println(dIntArray1.at(0));
        //  dIntArray1.array = new int[5];
        //dIntArray1.atInsert(5,3);


        //DIntArray dIntArray = new DIntArray(new int[]{82,1,2,2,4,5,6});
//        System.out.println( dIntArray.at(0));
         //dIntArray.atInsert(3, 10);
         //dIntArray1.add(1);
        // dIntArray.add(6);
        //dIntArray.atDelete(2);
    }
}
