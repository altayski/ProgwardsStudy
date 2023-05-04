package ru.progwards.java1.lessons.params;

public class FloatNumber {
    private boolean sign;
    private long mantissa;
    private int exp;

    FloatNumber() {

    }

    @Override
    public String toString() {
        StringBuilder num = new StringBuilder();
        if (!sign) num.append("-");
        char[] mantissaStr = Long.toString(mantissa).toCharArray();
        long expCorrection = mantissaStr.length + exp - 1;
        if (mantissaStr.length == 1) {
            num.append(mantissaStr[0]);
            num.append(".");
            num.append("0");
        } else {
            num.append(mantissaStr[0]);
            num.append(".");
            for (int i = 1; i < mantissaStr.length; i++) {
                num.append(mantissaStr[i]);
            }
        }
        if (expCorrection != 0) {
            num.append("E");
            num.append(expCorrection);

        }
        return num.toString();
    }

    FloatNumber(boolean sign, long mantissa, int exp) {
        this.sign = sign;
        this.mantissa = mantissa;
        this.exp = exp;
    }

    FloatNumber(String num) {
        char[] arr = num.toCharArray();
        StringBuilder mantissaBuild = new StringBuilder();//для целого
        StringBuilder expBuild = new StringBuilder();// для экспоненты
        int i = 0;
        //найти знак во входящей строке
        if (arr[0] == '-') {
            sign = false;
            i++;
        } else sign = true;

        // парсим мантиссу целую часть
        while (i < arr.length && Character.isDigit(arr[i])) {
            mantissa = Long.parseLong(mantissaBuild.append(arr[i]).toString());//получили мантиссу до дробной части
            i++;
        }
        long correction = 0;
        if (i < arr.length && arr[i] == '.') {// мантиссa после точки до e или E если она есть
            i++;
            while (i < arr.length && Character.isDigit(arr[i])) {
                correction++;
                mantissa = Long.parseLong(mantissaBuild.append(arr[i]).toString());
                i++;
            }
        }
        boolean minus = false;
        if (i < arr.length && (arr[i] == 'e' || arr[i] == 'E')) {
            i++;

            if (arr[i] == '-') {
                minus = true;
                i++;
            }
        }
        while (i < arr.length && Character.isDigit(arr[i])) {
            exp = Integer.parseInt(expBuild.append(arr[i]).toString());
            i++;
        }
        if (minus) {
            exp = -exp;
        } else if (!expBuild.toString().isEmpty()) {
            exp = Integer.parseInt(expBuild.toString());
        } else exp = 0;

        while (correction > 0) {
            exp--;
            correction--;
        }

        System.out.println("Знак: " + sign);
        System.out.println("Мантисса: " + mantissa);
        System.out.println("Экспонента: " + exp);
    }

    double toDouble() {
        return Math.pow(10, exp) * mantissa;
    }

    void fromDouble(double num) {
        int index = 0;
        String valueOf = String.valueOf(num);
        if (valueOf.startsWith("-")) {
            sign = false;
            valueOf = valueOf.substring(1);
        } else sign = true;
        if (valueOf.endsWith(".0")) {
            valueOf = valueOf.substring(0, valueOf.length() - 2);
        }
        if (valueOf.contains(".") && !valueOf.contains("E")) {
            int indX = valueOf.indexOf(".");
            exp = indX - valueOf.length() + 1;
        }

        if (valueOf.contains(".") && valueOf.contains("E")) {
            int indE = valueOf.indexOf("E");
            String expN = valueOf.substring(indE + 1);
            valueOf = valueOf.substring(0, indE);
            int correct = valueOf.length() - 2;
            exp = Integer.parseInt(expN) - correct;
        }
        char[] array = valueOf.toCharArray();
        StringBuilder mantissaBuild = new StringBuilder();
        while (index < array.length && (Character.isDigit(array[index]) || array[index] == '.')) {
            if (Character.isDigit(array[index])) {
                mantissaBuild.append(array[index]);
            }
            index++;
        }
        mantissa = Long.parseLong(mantissaBuild.toString());
        // System.out.println("Знак " + sign + "\n" + "Мантисса " + mantissa + "\n" + "Экспонента " + exp + "\n");
    }

    void negative() {
        sign = !sign;
    }

    FloatNumber add(FloatNumber num) {
        boolean signF = this.sign&& num.sign;
        double res;
        double x = this.toDouble();
        double y = num.toDouble();
        if(!signF){
             res = x-y;
        } else
         res = x + y;
        FloatNumber result = new FloatNumber();
        result.fromDouble(res);
        return result;
    }

    FloatNumber sub(FloatNumber num) {
        FloatNumber a = new FloatNumber(this.sign, this.mantissa, this.exp);
        FloatNumber b = new FloatNumber(num.sign, num.mantissa, num.exp);
        b.negative();

        return a.add((b));
    }
    public static void main(String[] args) {

        FloatNumber fl = new FloatNumber();
        //fl.fromDouble(-1.0005e-308);
        // fl.fromDouble(123456789e7);
        //fl.fromDouble(-1.50e-308);
        //  fl.fromDouble(123.411e6);
        fl.fromDouble(1.23456e6);
          FloatNumber str = new FloatNumber("1e1");
        FloatNumber str1 = new FloatNumber(true, 2, 5);
        System.out.println("Вызывает str1 = " + str1);

        FloatNumber str2 = new FloatNumber(false, 1, 5);
        //  System.out.println("Два одинаковых FloatNumber "+str1.add(str2));
        //  System.out.println("Результат сложения str1 и str2 = "+result);
        //  System.out.println("Сложение конструктор - входящая строка String " + str1.add(str));
         System.out.println("Сложение fromDouble и строковое представление String "+str.add(str2));
        System.out.println("Вычитание fromDouble и строковое представление String " + str1.sub(str2));
        double res = 2e5 - 1e5;
        System.out.println("Такой же пример сложения компьютером = " + res);
        System.out.println("str1 после сложения = " + str1);
        System.out.println("str2 после сложения = "+str2);


    }
}
