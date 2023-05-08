package ru.progwards.java1.lessons.params;

public abstract class AbsInteger {
     int value;
    AbsInteger(int value){
        this.value = value;
    }
    AbsInteger() {
    }

    public abstract String toString();
    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        int result = num1.value +num2.value;
        if( result>=Byte.MIN_VALUE && result<=Byte.MAX_VALUE ){
            return new ByteInteger((byte) result);
        } if(result>=Short.MIN_VALUE && result <=Short.MAX_VALUE){
            return new ShortInteger((short) result);
        } else return new IntInteger(result);
    }

    public static void main(String[] args) {
       ByteInteger byteInteger1 = new ByteInteger((byte) 15);
       ByteInteger byteInteger  = new ByteInteger((byte) 16);
       ShortInteger shortInteger = new ShortInteger((short) 1000);
       ShortInteger shortInteger1 = new ShortInteger((short) 100001);
       ByteInteger plusInt = new ByteInteger((byte)30);
       IntInteger plusInt2 = new IntInteger(342000);
        System.out.println("Byte плюс Int "+add(plusInt,plusInt2));
        System.out.println("Два short "+add(shortInteger1,shortInteger));
        System.out.println("Два Byte "+add(byteInteger,byteInteger1));


    }
}
