package ru.progwards.java1.lessons.wrappers;

public class NumMetrics {
    public static Integer sumDigits(Integer number){
        return (number%10)+(number/10%10)+(number/100);
    }
    public static Integer mulDigits(Integer number){
        return(number%10)*(number/10%10)*(number/100);
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(432));//9
        System.out.println(mulDigits(423));//24
    }
}
