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
        double todouble = 1;
        if (exp < 0) {
            while (exp != 0) {
                todouble = todouble / 10.0;
                exp++;
            }
        }
        if (exp > 0) {
            while (exp != 0) {
                todouble = todouble * 10.0;
                exp--;
            }
        }
        double res = mantissa * todouble;
         return Math.floor(res * 1000) / 1000;

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
        System.out.println("Знак " + sign + "\n" + "Мантисса " + mantissa + "\n" + "Экспонента " + exp + "\n");
    }

    void negative() {
        sign = !sign;
    }

    FloatNumber add(FloatNumber num) {
        boolean signF = this.sign && num.sign;
        double res;
        double x = this.toDouble();
        double y = num.toDouble();
        if (!signF) {
            res = x - y;
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
        System.out.println("Проба toString " + new FloatNumber(true, 645602, 3));
        FloatNumber toDoub = new FloatNumber(true, 355304, 3);
       // toDoub.toDouble();
        System.out.println("Метод toDouble " + toDoub.toDouble());
        fl.fromDouble(2.80840082775E8);
       // fl.toDouble();
        System.out.println("Метод fromDouble toDouble " + fl.toDouble());

        FloatNumber toNeg = new FloatNumber(true, 86378, 2);
        toNeg.negative();
        System.out.println("Метод negative " + toNeg);
        double res = 93810e2 + 85699e3;
        System.out.println("Проверяем комп " + res);
        FloatNumber one = new FloatNumber(true, 93810, 2);
        FloatNumber two = new FloatNumber(true, 85699, 3);
        System.out.println("Плюс " + one.add(two));
        FloatNumber three = new FloatNumber(true, 939156, 3);
        FloatNumber four = new FloatNumber(true, 759963, 3);
        System.out.println("Минус " + three.sub(four));
        double minus = 939156e3 - 759963e3;
        System.out.println("Комп минус" + minus);
        fl.fromDouble(902.387);

        System.out.println(fl.toDouble());


    }
}
