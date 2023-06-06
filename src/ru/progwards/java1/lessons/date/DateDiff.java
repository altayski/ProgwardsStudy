package ru.progwards.java1.lessons.date;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
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
        timeDifference = date1.getTime() < date2.getTime() ? calculateBefore(convert(date1), convert(date2)) : calculateAfter(convert(date1), convert(date2));
        System.out.println("Между date1 и date2 "
                + timeDifference.getYears() + " лет, "
                + timeDifference.getMonth() + " месяцев, "
                + timeDifference.getDays() + " дней, "
                + timeDifference.getHours() + " часов, "
                + timeDifference.getMinutes() + " минут, "
                + timeDifference.getSeconds() + " секунд, "
                + timeDifference.getMillis() + " миллисекунд");
    }

    public static void timeToBirthday(Date now, Date birthday) {
        TimeDifference timeDifference;
        timeDifference = now.getTime() < birthday.getTime() ? calculateBefore(convert(now), convert(birthday)) : calculateAfter(convert(now), convert(birthday));
        System.out.println("До дня рождения "
                + timeDifference.getMonth() + " месяцев, "
                + timeDifference.getDays() + " дней, "
                + timeDifference.getHours() + " часов, "
                + timeDifference.getMinutes() + " минут, "
                + timeDifference.getSeconds() + " секунд, "
                + timeDifference.getMillis() + " миллисекунд");
    }

    private static LocalDateTime convert(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));
    }
    private static TimeDifference calculateAfter(LocalDateTime start, LocalDateTime end) {
        int yearsBetween = 0, monthBetween = 0, daysBetween = 0, hourBetween = 0, minutesBetween = 0, secondsBetween = 0, millisBetween = 0;
        while (start.isAfter(end)) {
            yearsBetween++;
            start = start.minusYears(1);
        }
        while (start.isBefore(end)) {
            monthBetween++;
            start = start.plusMonths(1);
        }
        start = start.minusMonths(1);
        monthBetween--;
        while (start.isBefore(end)) {
            daysBetween++;
            start = start.plusDays(1);
        }
        start = start.minusDays(1);
        daysBetween--;
        while (start.isBefore(end)) {
            hourBetween++;
            start = start.plusHours(1);
        }
        start = start.minusHours(1);
        hourBetween--;
        while (start.isBefore(end)) {
            minutesBetween++;
            start = start.plusMinutes(1);
        }
        start = start.minusMinutes(1);
        minutesBetween--;
        while (start.isBefore(end)) {
            secondsBetween++;
            start = start.plusSeconds(1);
        }
        start = start.minusSeconds(1);
        secondsBetween--;
        millisBetween = whereAreMillis(start.getNano(), end.getNano());
        return new TimeDifference(yearsBetween, monthBetween, daysBetween, hourBetween, minutesBetween, secondsBetween, millisBetween);
    }

    private static TimeDifference calculateBefore(LocalDateTime start, LocalDateTime end) {
        int yearsBetween = 0, monthBetween = 0, daysBetween = 0, hourBetween = 0, minutesBetween = 0, secondsBetween = 0, millisBetween = 0;
        while (start.isBefore(end)) {
            start = start.plusYears(1);
            yearsBetween++;
        }
        start = start.minusYears(1);
        yearsBetween--;
        while (start.isBefore(end)) {
            start = start.plusMonths(1);
            monthBetween++;
        }
        start = start.minusMonths(1);
        monthBetween--;
        while (start.isBefore(end)) {
            start = start.plusDays(1);
            daysBetween++;
        }
        start = start.minusDays(1);
        daysBetween--;
        while (start.isBefore(end)) {
            start = start.plusHours(1);
            hourBetween++;
        }
        start = start.minusHours(1);
        hourBetween--;
        while (start.isBefore(end)) {
            start = start.plusMinutes(1);
            minutesBetween++;
        }
        start = start.minusMinutes(1);
        minutesBetween--;
        while (start.isBefore(end)) {
            start = start.plusSeconds(1);
            secondsBetween++;
        }
        start = start.minusSeconds(1);
        secondsBetween--;
        millisBetween = whereAreMillis(start.getNano(), end.getNano());
        return new TimeDifference(yearsBetween, monthBetween, daysBetween, hourBetween, minutesBetween, secondsBetween, millisBetween);
    }

    private static int whereAreMillis(int start, int end) {
        int milllisBetween = 0;
        if (end < start) {
            end += 1000;
            milllisBetween = end - start;
        } else if (end > start) {
            milllisBetween = end - start;
        }
        return milllisBetween;
    }


    public static void averageTime(Date[] events) {
        int sumYears = 0, sumMonth = 0, sumDays = 0, sumHours = 0, sumMinutes = 0, sumSeconds = 0, sumMillis = 0;
        int max = events.length;
        int count = max - 1;
        TimeDifference timeDifference;
         LocalDateTime avBegin = LocalDateTime.of(1976, Month.JUNE,24,9,9,45,288);//первая
       LocalDateTime avEnd = LocalDateTime.of(2006,Month.MAY,26,16,51,48,298);//первая
        //        timeDifference = calculateBefore(convert(events[0]), convert(events[max - 1]));
       timeDifference = calculateBefore(avBegin,avEnd);
       // LocalDateTime av = LocalDateTime.of(1972, Month.JANUARY, 3, 19, 6, 32,214);// втора
       // LocalDateTime avF = LocalDateTime.of(2004, Month.MARCH, 1, 12, 8, 50,220);//вторая
       // timeDifference = calculateBefore(av,avF);
//        LocalDateTime sk = LocalDateTime.of(1978,Month.JULY,18,3,8,46,376);
//        LocalDateTime skF = LocalDateTime.of(2002,Month.JUNE,15,5,23,57,386);
//        timeDifference = calculateBefore(sk,skF);
        sumYears = timeDifference.getYears();
        sumMonth = timeDifference.getMonth();
        sumDays = timeDifference.getDays();
        sumHours = timeDifference.getHours();
        sumMinutes = timeDifference.getMinutes();
        sumSeconds = timeDifference.getSeconds();
        sumMillis = timeDifference.getMillis();
        LocalDateTime test = LocalDateTime.of(sumYears,sumMonth,sumDays,sumHours,sumMinutes,sumSeconds,sumMillis);
        long total = (long) (sumYears* 365*24*60*60*1000L +
                        sumMonth*30*24*60*60*1000L +
                        sumDays*24*60*60*1000L +
                        sumHours*60*60*1000L +
                        sumMinutes*60*1000L +
                        sumSeconds*1000L +
                        sumMillis);
        long average = total / max;
        int avYear =(int) (total / (365*24*60*60*1000L))/3;
        int ostYear=(int)  (total % (30*24*60*60*1000L))/3;

        int avMonth = (int) ((total   % (365 * 24 * 60 * 60 * 1000L)) / (30 * 24 * 60 * 60 * 1000L));
        int avDays = (int)((total % (30 * 24 * 60 * 60 * 1000L)) / (24 * 60 * 60 * 1000L));
        int avHours = (int)((average % (24 * 60 * 60 * 1000L)) / (60 * 60 * 1000L));
        int avMinutes = (int)((average % (60 * 60 * 1000L)) / (60 * 1000L));
        int avSec = (int) ((average % (60 * 1000L)) / 1000L);
        int avMill = (int)(average%1000L);



        int averageYear = sumYears / count;//среднее кол-во лет до целого
       // int ostYear = sumYears % count;//остаток в годах
        sumMonth += ostYear * 12;//добавляю остаток в годах к месяцам
        int averageMonth = sumMonth / count;//среднее количество месяцев
        if (averageMonth == 12) {
            averageYear += 1;
            averageMonth = 0;
        }
        int ostMonth = sumMonth % count;//остаток в месяцах
        sumDays += ostMonth * 31;//добавляю остаток в месяцах к дням
        int averageDays = Math.round((float)sumDays / count);
         int ostDays = sumDays %count;
          sumHours+= ostDays * 24;
        int averageHours = sumHours /3;
        int ostHours = sumHours % count;
        // sumMinutes+=ostHours*60;
        int averageMinutes = sumMinutes / count;
        int ostMinutes = sumMinutes % count;
         sumSeconds+=ostMinutes*60;
        int averageSeconds = sumSeconds / count;
        int ostSec = sumSeconds%count;
        sumMillis+=ostSec %1000;
        int averageMillis = sumMillis / count;


        System.out.println("Среднее время между событиями "
                + avYear + " лет, "
                + avMonth + " месяцев, "
                + avDays + " дней, "
                + avHours + " часов, "
                + avMinutes + " минут, "
                + avSec + " секунд, "
                + avMill + " миллисекунд");
    }


    public static void main(String[] args) {
//       Date one = new Date(2019, Calendar.MARCH, 21, 8, 6, 48);
//        Date two = new Date(2024, Calendar.FEBRUARY, 20, 17, 35, 53);
//        Date one1 = new Date(1973, Calendar.MARCH,1,9,37,46);
//        Date two1 = new Date(2083, Calendar.DECEMBER,17, 12,33,5);
//        Date september1 = new Date(2098, Calendar.SEPTEMBER, 3, 17, 33, 7);
//        Date april = new Date(2087, Calendar.APRIL, 6, 6, 19, 21);
//        Date febr19 = new Date(2019,Calendar.FEBRUARY,21);
//        Date febr20 = new Date(2024, Calendar.FEBRUARY,20);
//        Date dec30 = new Date(2022, Calendar.DECEMBER,29);
//        Date mart5 = new Date(2023,Calendar.MARCH,5);
//        timeBetween(dec30,mart5);
        // timeBetween(febr19,febr20);

        //System.out.println("Расчет между датами: ");
        // timeBetween(one1, two1);
        //timeBetween(two,one);
        //   timeBetween(september1,april);
        Date date = new Date(123, Calendar.JANUARY, 1, 10, 10, 13);
        // Date dateNow = new Date();
        // System.out.println(dateNow);
        // Date birth = new Date(123, Calendar.MAY, 30, 13, 4, 37);

        Date testFrom = new Date(1999, Calendar.OCTOBER, 25, 13, 4, 37);
        Date testFin = new Date(2023, Calendar.MAY, 29, 10, 10, 13);
       // System.out.print("Расчёт до дня рождения: ");
        // timeBetween(date, birth);//этот вариант проверить!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //timeToBirthday(dateNow, birth);
        // timeToBirthday(date, birth);
        // timeToBirthday(testFin,testFrom);
        Date apr95 = new Date(1995, Calendar.APRIL, 2, 7, 54, 29);
        Date may23 = new Date(2023, Calendar.MAY, 19, 14, 46, 11);
       // timeToBirthday(may23, apr95);
        // timeBetween(apr95,may23);


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
        Date january = new Date(72, Calendar.JANUARY, 3, 19, 6, 32);
        Date august = new Date(82, Calendar.AUGUST, 13, 20, 20, 52);
        Date february = new Date(96, Calendar.FEBRUARY, 25, 14, 23, 10);
        Date march = new Date(104, Calendar.MARCH, 1, 12, 8, 50);
        Date[] timeTest = {january, august, february, march};
         // averageTime(timeTest);
        LocalDateTime avBegin = LocalDateTime.of(1976, Month.JUNE,24,9,9,45,288);//для первого
        LocalDateTime avEnd = LocalDateTime.of(2006,Month.MAY,26,16,51,48,298);//для первого
//          calculateBefore(avBegin,avEnd);// первая проверка среднего
//        LocalDateTime av = LocalDateTime.of(1972, Month.JANUARY, 3, 19, 6, 32,214);
//        LocalDateTime avF = LocalDateTime.of(2004, Month.MARCH, 1, 12, 8, 50,220);
        LocalDateTime sk = LocalDateTime.of(1978,Month.JULY,18,3,8,46,376);
        LocalDateTime skF = LocalDateTime.of(2002,Month.JUNE,15,5,23,57,386);
    }
}
