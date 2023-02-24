package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number) {
        int reverseNumber;
        reverseNumber = number % 10;
        number = number / 10;
        reverseNumber = reverseNumber * 10 + number % 10;
        number = number / 10;
        reverseNumber = reverseNumber * 10 + number % 10;
        return reverseNumber;
    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(789));
    }
}
