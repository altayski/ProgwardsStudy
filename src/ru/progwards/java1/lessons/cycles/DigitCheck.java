package ru.progwards.java1.lessons.cycles;

public class DigitCheck {
    public static boolean containsDigit(int number, int digit) {
        if (number == 0 && digit == 0) return true;
        boolean result = false;
        while (number >= 1) {
            if (number % 10 == digit) {
                result = true;
                break;
            }
            number = number / 10;
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(containsDigit(125, 1));
    }
}
