package ru.progwards.java1.lessons.interfaces2;

public class ComplexNum implements ToString {
    int a;
    int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + "+" + b + "i";
    }

    public ComplexNum add(ComplexNum num) {

        return new ComplexNum(a + num.a, b + num.b);
    }

    public ComplexNum sub(ComplexNum num) {
        return new ComplexNum(a - num.a, b - num.b);
    }

    public ComplexNum mul(ComplexNum num) {
        return new ComplexNum(a * num.a - b * num.b, b * num.a + a * num.b);
    }

    public ComplexNum div(ComplexNum num) {
        int del = (num.a * num.a + num.b * num.b);
        return new ComplexNum((a * num.a + b * num.b) / del, (b * num.a - a * num.b) / del);
    }

    @Override
    public String getString() {//добавлен
        return toString();
    }


    public static void main(String[] args) {
        ComplexNum complexNum = new ComplexNum(1, 56);
        ComplexNum complexNum1 = new ComplexNum(1, 10);
        System.out.println(complexNum.add(complexNum1));
        System.out.println(complexNum);
    }
}
