package ru.progwards.java1.lessons.params;

import java.util.Arrays;
public class ArrayInteger {
    private final byte[] digits;

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

        for (int i = 0; i < digits.length; i++) {
            digits[i] = (byte) (value.charAt(i) - '0');
        }
    }

    public boolean add(ArrayInteger num) {
        int newSize = Math.max(digits.length, num.digits.length);
        int carry = 0;
        int aValue, bValue;
        if(digits.length<num.digits.length){
            Arrays.fill(digits,(byte)0);
            return false;
        }
        for (int i = 0; i < digits.length; i++) {
                aValue = digits[digits.length - i - 1];
            if (i < num.digits.length) {
                bValue = num.digits[num.digits.length - i - 1];
            } else bValue = 0;
            int sum = aValue + bValue + carry;
            digits[newSize - i - 1] = (byte) (sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            Arrays.fill(digits,(byte)0);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayInteger ai = new ArrayInteger(7);
        ai.fromString("8492152");
        System.out.println(ai);
        ArrayInteger two = new ArrayInteger(24);
        two.fromString("922337203685477580794093");
        boolean exp = ai.add(two);
        System.out.println(exp);
        System.out.println(ai);
    }
}
