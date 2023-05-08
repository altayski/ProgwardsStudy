package ru.progwards.java1.lessons.params;

import java.util.Arrays;
import java.util.Collections;

public class ArrayInteger {
    private  byte[] digits;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }

    ArrayInteger(int n) {
        digits = new byte[n];
    }

    void fromString(String value) {
        digits = new byte[value.length()];
        // byte[] str = value.getBytes();
        for (int i = value.length() - 1; i >= 0; i--) {
            digits[i] = (byte) (value.charAt(value.length() - i - 1) - '0');
        }
    }

    boolean add(ArrayInteger num) {
        int pos=0;
        byte[] array = this.digits;//здесь хранится вызвавший массив
        int newSize = Math.max(digits.length, num.digits.length); // определяется длина будущего итогового массива
        // byte[]tmp=new byte[newSize]; //это будет временный массив, куда я запишу короткий, чтобы совпадали индексы
        digits = new byte[newSize];//будет итоговым массивом, куда запишется сумма
        int carry = 0;//сюда записывается остаток от сложения, то есть десятки
        byte aValue = 0, bValue = 0;//сюда записываются значения из массива для сложения
        if(array.length<num.digits.length) {//если вызывающий массив меньше параметра, то во временный массив копируется более короткий массив со смещением
            pos = num.digits.length - array.length;
            System.arraycopy(array,0,digits,pos,array.length);
        } if(array.length>num.digits.length){
            pos = array.length-num.digits.length;
            System.arraycopy(num.digits,0,digits,pos,num.digits.length);
        }

        for (int i = 0; i <digits.length ; i++) {
            aValue = array[array.length - 1 - i];
            bValue = digits[digits.length - 1 - i];
            int result = aValue + bValue + carry;
            digits[digits.length - 1 - i] = (byte) (result % 10);
            carry = result / 10;
//            if (digits[0] > 9) {
//                for (int j = 0; j < digits.length; j++) {
//                    digits[j]=0;
//                }
//                return false;
//            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayInteger ai = new ArrayInteger(15);
        ai.fromString("2469");
        ArrayInteger two = new ArrayInteger(15);
        two.fromString("135");
        boolean exp = ai.add(two);
        System.out.println(ai);
    }
}
