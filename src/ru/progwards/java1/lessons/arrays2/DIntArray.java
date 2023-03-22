package ru.progwards.java1.lessons.arrays2;

public class DIntArray {
    private int[] array;

    public DIntArray() {
        array = new int[0];
    }

    public void add(int num) {//добавляет элемент num  в конец массива array
        int[] arrayCopy = new int[array.length + 1];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        arrayCopy[arrayCopy.length - 1] = num;
        array = arrayCopy;
    }

    public void atInsert(int pos, int num) { //вставка элемента на определенную позицию
        int[] arrayInsert = new int[array.length + 1];
        System.arraycopy(array, 0, arrayInsert, 0, pos);
        arrayInsert[pos] = num;
        for (int i = pos; i < array.length; i++) {
            arrayInsert[++pos] = array[i];
        }
        array = arrayInsert;
    }

    public void atDelete(int pos) { //удаление элемента с позиции
        int[] arrayDel = new int[array.length - 1];
        System.arraycopy(array, 0, arrayDel, 0, pos);
        for (int i = pos + 1; i < array.length; i++) {
            arrayDel[pos++] = array[i];
        }
        array=arrayDel;
    }

    public int at(int pos) {
               return array[pos];
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
        System.out.println("Третий элемент перед вставкой: "+dIntArray1.at(3));
        dIntArray1.atInsert(3,1000);
        System.out.println("Третий элемент после вставки: "+dIntArray1.at(3));

        System.out.println("Пятый элемент перед удалением: "+dIntArray1.at(5));
        dIntArray1.atDelete(5);
        System.out.println("Пятый элемент после удаления: "+dIntArray1.at(5));

    }
}
