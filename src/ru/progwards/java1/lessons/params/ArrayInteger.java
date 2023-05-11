package ru.progwards.java1.lessons.params;

import java.util.Arrays;
public class ArrayInteger {
    private byte[] digits;

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
        for (int i = 0; i < value.length(); i++) {
            digits[i] = (byte) (value.charAt(i) - '0');
        }
    }

    public boolean add(ArrayInteger num) {
        int newSize = Math.max(digits.length, num.digits.length);
        byte[] result = new byte[newSize];
        int carry = 0;
        int aValue, bValue;

        for (int i = 0; i < newSize; i++) {
            if (i < digits.length) {
                aValue = digits[digits.length - i - 1];
            } else aValue = 0;
            if (i < num.digits.length) {
                bValue = num.digits[num.digits.length - i - 1];
            } else bValue = 0;
            int sum = aValue + bValue + carry;
            result[newSize - i - 1] = (byte) (sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            Arrays.fill(digits,(byte)0);
            return false;
        }

        digits = result;
        return true;
    }

    public static void main(String[] args) {
        ArrayInteger ai = new ArrayInteger(15);
        ai.fromString("15657265");
        System.out.println(ai);
        ArrayInteger two = new ArrayInteger(15);
        two.fromString("95657265");
        boolean exp = ai.add(two);
        System.out.println(ai);
    }
}
