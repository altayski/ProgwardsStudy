package ru.progwards.java1.lessons.date;

import java.util.Calendar;


public class CalendarPrint {

    public static void printMonth(int month, int year) {
        String[] monthArray = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        String[] days = {"ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС"};
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);

        System.out.print(cal.get(Calendar.YEAR) + " " + monthArray[cal.get(Calendar.MONTH)] + '\n');
        for (String day : days) {
            System.out.print(day + " ");
        }
        System.out.println();
        int start;
        int startM = cal.get(Calendar.DAY_OF_WEEK);
        if(startM == 1){
            start = 6;
        }else start = startM - 2;

        int j = 0;
        while (j < start) {
            System.out.print("   ");
            j++;
        }
        for (int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            if (i < 10) {
                System.out.print(" " + i + " ");
            } else
                System.out.print(i + " ");
            if ((start + i) % 7 == 0) {
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        printMonth(3, 2025);
    }
}
