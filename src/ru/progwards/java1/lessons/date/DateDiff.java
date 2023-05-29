package ru.progwards.java1.lessons.date;

import java.util.Calendar;
import java.util.Date;

public class DateDiff {
    private static class TimeDifference {
        private final int years;
        private final int month;
        private final int days;
        private final int hours;
        private final int minutes;
        private final int seconds;
        private final int millis;

        public int getYears() {
            return years;
        }

        public int getMonth() {
            return month;
        }

        public int getDays() {
            return days;
        }

        public int getHours() {
            return hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public int getSeconds() {
            return seconds;
        }

        public int getMillis() {
            return millis;
        }

        TimeDifference(int years, int month, int days, int hours, int minutes, int seconds, int millis) {
            this.years = years;
            this.month = month;
            this.days = days;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.millis = millis;
        }
    }
    public static void timeBetween(Date date1, Date date2) {
        TimeDifference timeDifference;
        if(date1.before(date2)){
            timeDifference = calculateYearMonthDays(date1,date2);
        } else timeDifference = calculateYearMonthDays(date2,date1);
        System.out.println("Между date1 и date2 " + timeDifference.getYears() + " лет, " + timeDifference.getMonth() +
                " месяцев, " + timeDifference.getDays() + " дней, " + timeDifference.getHours() + " часов, " + timeDifference.getMinutes() + " минут, " + timeDifference.getSeconds() +
                " секунд, " + timeDifference.getMillis() + " миллисекунд");
    }

    public static void timeToBirthday(Date now, Date birthday) {
        TimeDifference timeDifference = calculateYearMonthDays(now, birthday);
        System.out.println("До дня рождения " + "лет " + timeDifference.getMonth() + " месяцев, " + timeDifference.getDays() + " дней, " + timeDifference.getHours() + " часов, "
                + timeDifference.getMinutes() + " минут, " + timeDifference.getSeconds() + " секунд, " + timeDifference.getMillis() + " миллисекунд");
    }

    private static TimeDifference calculateYearMonthDays(Date one, Date two) {//калькулятор на годы, месяцы, дни
        int yearsBetween=0, monthBetween=0, daysBetween, hourBetween, minutesBetween, secondsBetween, millisBetween;
        Calendar one1 = Calendar.getInstance();
        one1.setTime(one);
        Calendar two1 = Calendar.getInstance();
        two1.setTime(two);


        int yearOne = one1.get(Calendar.YEAR);
        int yearTwo = two1.get(Calendar.YEAR);
        if (one1.get(Calendar.YEAR) != two1.get(Calendar.YEAR)) {
            yearsBetween = Math.abs(yearTwo - yearOne);
        }
        if (one1.get(Calendar.MONTH) != two1.get(Calendar.MONTH)) {
            monthBetween = two1.get(Calendar.MONTH) - one1.get(Calendar.MONTH);
        }
        if (one1.get(Calendar.YEAR) == two1.get(Calendar.YEAR) && monthBetween < 0) {
            monthBetween = Math.abs(monthBetween);
        }
        if (monthBetween < 0) {
            monthBetween = 12 - one1.get(Calendar.MONTH) + two1.get(Calendar.MONTH);
            yearsBetween -= 1;
        }

        int daysInMonth = one1.getActualMaximum(Calendar.DAY_OF_MONTH);

        int dayOfMonth = one1.get(Calendar.DAY_OF_MONTH);

        daysBetween = daysInMonth - dayOfMonth + two1.get(Calendar.DAY_OF_MONTH);
        if (daysBetween < daysInMonth) {
            monthBetween -= 1;
        }
        if (daysBetween > daysInMonth) {
            daysBetween = Math.abs(daysBetween - daysInMonth);
        }
        if (daysBetween == daysInMonth) {
            daysBetween = 0;
        }

        int hourOne = one1.get(Calendar.HOUR_OF_DAY);
        int hourTwo = two1.get(Calendar.HOUR_OF_DAY);
        hourBetween = hourTwo - hourOne;
        if (hourBetween < 0) {
            hourBetween = (24 + hourTwo) - hourOne;
            daysBetween -= 1;
        }
        int minOne = one1.get(Calendar.MINUTE);
        int minTwo = two1.get(Calendar.MINUTE);
        minutesBetween = minTwo - minOne;
        if (minutesBetween < 0) {
            minutesBetween = (60 + minTwo) - minOne;
            hourBetween -= 1;
        }

        int secOne = one1.get(Calendar.SECOND);
        int secTwo = two1.get(Calendar.SECOND);
        secondsBetween = secTwo - secOne;
        int oneMillis = one1.get(Calendar.MILLISECOND);
        int twoMillis = two1.get(Calendar.MILLISECOND);
        millisBetween = twoMillis - oneMillis;
        if(millisBetween<0){
            millisBetween = (1000+twoMillis)-oneMillis;
            secondsBetween-=1;
        }
        if (secondsBetween < 0) {
            secondsBetween = (60 + secTwo) - secOne;
            minutesBetween = minutesBetween - 1;
        }
            if (minutesBetween < 0) {
                minutesBetween = 60 - Math.abs(minutesBetween);
                hourBetween = hourBetween - 1;
            }
            if (hourBetween < 0) {
                hourBetween = 24 - Math.abs(hourBetween);
                daysBetween = daysBetween - 1;
            }
            if (daysBetween < 0) {
                daysBetween = daysInMonth - 1;
                monthBetween = monthBetween - 1;
            }
            if (monthBetween < 0) {
                monthBetween = 12 - Math.abs(monthBetween);
                yearsBetween = yearsBetween - 1;
            }

        return new TimeDifference(yearsBetween, monthBetween, daysBetween, hourBetween, minutesBetween, secondsBetween, millisBetween);
    }

    public static void averageTime(Date[] events) {
        int sumYears = 0, sumMonth = 0, sumDays = 0, sumHours = 0, sumMinutes = 0, sumSeconds = 0, sumMillis = 0;
        int max = events.length;
        int count = max-1;
        TimeDifference timeDifference;

            timeDifference = calculateYearMonthDays(events[0], events[max-1]);
            sumYears = timeDifference.getYears();
            sumMonth = timeDifference.getMonth();
            sumDays = timeDifference.getDays();
            sumHours = timeDifference.getHours();
            sumMinutes = timeDifference.getMinutes();
            sumSeconds = timeDifference.getSeconds();
            sumMillis = timeDifference.getMillis();



//        if (sumSeconds > 60) {
//            sumMinutes += sumSeconds / 60;
//            sumSeconds %= 60;
//        }
//        if (sumMinutes > 60) {
//            sumHours += sumMinutes / 60;
//            sumMinutes %= 60;
//        }
//        if (sumHours > 24) {
//            sumDays += sumHours / 24;
//            sumHours %= 24;
//        }
//        if (sumDays > 31) {
//            sumMonth += sumDays / 31;
//            sumDays %= 31;
//        }

        int averageYear = sumYears / count;//среднее кол-во лет до целого
        int ostYear = sumYears %count;//остаток в годах
        sumMonth += ostYear * 12;//добавляю остаток в годах к месяцам
        int averageMonth = sumMonth / count;//среднее количество месяцев
        if(averageMonth ==12){
            averageYear+=1;
            averageMonth = 0;
        }
        int ostMonth = sumMonth %count;//остаток в месяцах
        sumDays += ostMonth * 31;//добавляю остаток в месяцах к дням
        int averageDays = sumDays / count;
        int ostDays = sumDays %count;
        sumHours += ostDays * 24;
        int averageHours = sumHours/count;
        int ostHours = sumHours % count;
        sumMinutes+=ostHours*60;
        int averageMinutes = sumMinutes / count;
        int ostMinutes = sumMinutes % count;
        sumSeconds+=ostMinutes*60;
        int averageSeconds = sumSeconds /count;
        int averageMillis = sumMillis / count;

        System.out.println("Среднее время между событиями " + averageYear + " лет, " + averageMonth + " месяцев, "
                + averageDays + " дней, " + averageHours + " часов, " + averageMinutes + " минут, " + averageSeconds +
                " секунд, " + averageMillis + " миллисекунд");
    }




    public static void main(String[] args) {
        Date one = new Date(2019, Calendar.MARCH, 21, 8, 6, 48);
        Date two = new Date(2024, Calendar.FEBRUARY, 20, 17, 35, 53);
        Date one1 = new Date(1973, Calendar.MARCH,1,9,37,46);
        Date two1 = new Date(2083, Calendar.DECEMBER,17, 12,33,5);
        System.out.println("Расчет между датами: ");
        //timeBetween(one, two);
      //  timeBetween(one1,two1);
        Date date = new Date(123, Calendar.MAY, 29, 10, 10, 13);
        Date dateNow = new Date();
        Date birth = new Date(99, Calendar.OCTOBER, 25, 13, 4, 37);

        Date testFrom = new Date(2021, 0, 0, 0, 0, 0);
        Date testFin = new Date(2022, 1, 0, 0, 0, 0);
        // System.out.print("Расчёт до дня рождения: ");
       // timeBetween(testFrom, testFin);
        //timeToBirthday(dateNow, birth);
        // timeToBirthday(date, birth);


        Date seul = new Date(88, 8, 17, 10, 0, 15);
        Date barselona = new Date(92, 6, 25, 9, 0, 20);
        Date atlanta = new Date(96, 6, 19, 10, 30, 26);
        Date sydnei = new Date(100, 8, 15, 16, 30, 37);
        Date athens = new Date(104, 7, 13, 10, 0, 56);
        Date peking = new Date(108, 7, 8, 12, 30, 57);
        Date london = new Date(112, 6, 27, 8, 30, 49);
        Date rio = new Date(116, 7, 5, 19, 30, 11);
        Date today = new Date();
        Date[] olympic = {seul, barselona, atlanta, sydnei, athens, peking, london, rio};
        //averageTime(olympic);

        Date june = new Date(1976, Calendar.JUNE, 24, 9, 9, 45);
        Date october = new Date(1983, Calendar.OCTOBER, 24, 18, 8, 14);
        Date september = new Date(1991, Calendar.SEPTEMBER, 12, 5, 3, 0);
        Date may = new Date(2006, Calendar.MAY, 26, 16, 51, 48);
        Date[] test = {june, october, september, may};
         averageTime(test);
        //  timeBetween(june,may);
        Date january = new Date(72,Calendar.JANUARY,3,19,6,32);
        Date august =  new Date(82,Calendar.AUGUST,13,20,20,52);
        Date february = new Date(96, Calendar.FEBRUARY,25,14,23,10);
        Date march = new Date(104,Calendar.MARCH,1,12,8,50);
        Date[] timeTest = {january,august,february,march};
        averageTime(timeTest);
    }
}
