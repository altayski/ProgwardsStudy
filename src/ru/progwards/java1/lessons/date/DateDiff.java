package ru.progwards.java1.lessons.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class DateDiff {
    private static class TimeDifference {
         static LocalDateTime refresh;
        static void setRefresh(LocalDateTime refresh) {
            TimeDifference.refresh = refresh;
        }
        static LocalDateTime getRefresh() {
            return TimeDifference.refresh;
        }

    }

    public static void timeBetween(Date date1, Date date2) {
        System.out.println("Между date1 и date2 " + calculateYears(convert(date1),convert(date2))+" лет, "+calculate(convert(date1),convert(date2)));

    }

    public static void timeToBirthday(Date now, Date birthday) {
          calculateYears(convert(now),convert(birthday));
        System.out.println("До дня рождения "+calculate(convert(now),convert(birthday)));

    }

    private static LocalDateTime convert(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static String calculate(LocalDateTime start, LocalDateTime end) {
        int monthBetween = 0, daysBetween = 0, hourBetween = 0, minutesBetween = 0, secondsBetween = 0, millisBetween = 0;
        int startDay = start.getDayOfMonth();
        start = TimeDifference.getRefresh();
        while (start.isBefore(end)) {
            monthBetween++;
            start = start.plusMonths(1);
        }
        int finishDay = start.getDayOfMonth();
        start = start.minusMonths(1).plusDays(startDay - finishDay);
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
        int st = start.getNano() / 1000000;
        int ed = end.getNano() / 1000000;
        millisBetween = calculateMillis(st, ed);
        return monthBetween + " месяцев, " + daysBetween + " дней, " + hourBetween+ " часов, " + minutesBetween+ " минут, " + secondsBetween + " секунд, "
                + millisBetween + " миллисекунд";
    }

    private static int calculateMillis(int start, int end) {

        int milllisBetween = 0;
        if (end < start) {
            end += 1000;
            milllisBetween = end - start;
        } else if (end > start) {
            milllisBetween = end - start;
        }
        return milllisBetween;
    }

    private static int calculateYears(LocalDateTime start, LocalDateTime end) {
        int yearsBetween = 0;
        boolean isAfter = start.isAfter(end);
        while (start.isAfter(end) == isAfter) {
            yearsBetween++;
            start = start.plusYears(isAfter ? -1 : 1);
        }
        yearsBetween -= isAfter ? 0 : 1;
        start = start.plusYears(isAfter ? 0 : -1);
        TimeDifference.setRefresh(start);
        return yearsBetween;

    }


    public static void averageTime(Date[] events) {
        long fromDate = events[0].toInstant().toEpochMilli();
        long fromDate2 = events[events.length - 1].toInstant().toEpochMilli();
        long difference = (fromDate2 - fromDate) / (events.length - 1);
        Instant epo = Instant.EPOCH;
        Instant dateFinish = Instant.ofEpochMilli(difference);
        LocalDateTime zero = LocalDateTime.ofInstant(epo, ZoneId.of("UTC"));
        LocalDateTime fromDateTime = LocalDateTime.ofInstant(dateFinish, ZoneId.of("UTC"));
        System.out.println("Среднее время между событиями "+ calculateYears(zero,fromDateTime)+" лет, "+calculate(zero,fromDateTime));
    }


    public static void main(String[] args) {
        Date one = new Date(119, Calendar.MARCH, 21, 8, 6, 48);
        Date two = new Date(124, Calendar.FEBRUARY, 20, 17, 35, 53);
        Date one1 = new Date(73, Calendar.MARCH, 1, 9, 37, 46);
        Date two1 = new Date(183, Calendar.DECEMBER, 17, 12, 33, 5);
        Date september1 = new Date(198, Calendar.SEPTEMBER, 3, 17, 33, 7);
        Date april = new Date(187, Calendar.APRIL, 6, 6, 19, 21);
        Date febr19 = new Date(2019, Calendar.FEBRUARY, 21);
        Date febr20 = new Date(2024, Calendar.FEBRUARY, 20);
//        Date dec30 = new Date(2022, Calendar.DECEMBER,29);
//        Date mart5 = new Date(2023,Calendar.MARCH,5);
//        timeBetween(dec30,mart5);
        //timeBetween(febr19,febr20);

        //System.out.println("Расчет между датами: ");
       // timeBetween(one1, two1);
        // timeBetween(one,two);
        // timeBetween(april,september1);
        Date date = new Date(123, Calendar.JANUARY, 1, 10, 10, 13);
        // Date dateNow = new Date();
        // System.out.println(dateNow);
        // Date birth = new Date(123, Calendar.MAY, 30, 13, 4, 37);

        Date testFrom = new Date(1999, Calendar.OCTOBER, 25, 13, 4, 37);
        Date testFin = new Date(2023, Calendar.MAY, 29, 10, 10, 13);
        // System.out.print("Расчёт до дня рождения: ");

        Date apr95 = new Date(95, Calendar.APRIL, 2, 7, 54, 29);
        Date may23 = new Date(123, Calendar.MAY, 19, 14, 46, 11);
        timeToBirthday(may23, apr95);

        Date june = new Date(76, 5, 24, 9, 9, 45);
        Date october = new Date(83, 9, 24, 18, 8, 14);
        Date september = new Date(91, 8, 12, 5, 3, 0);
        Date may = new Date(106, 4, 26, 16, 51, 48);
        Date[] test1 = {june, october, september, may};
       // averageTime(test1);
        Date january = new Date(72, 0, 3, 19, 6, 32);
        Date august = new Date(82, 8, 13, 20, 20, 52);
        Date february = new Date(96, 1, 25, 14, 23, 10);
        Date march = new Date(104, 2, 1, 12, 8, 50);
        Date[] timeTest2 = {january, august, february, march};
        //averageTime(timeTest2);
        //18 июля 1978 года, 03:08:46.376
        // 21 мая 1984 года, 19:05:06.386
        // 20 января 1996 года, 02:19:36.386
        //15 июня 2002 года, 05:23:57.386
        Date jule1978 = new Date(78, 6, 18, 3, 8, 46);
        Date may1984 = new Date(84, 4, 21, 19, 5, 6);
        Date jan1996 = new Date(96, 0, 20, 2, 19, 46);
        Date june2002 = new Date(102, 5, 15, 5, 23, 57);
        Date[] timeTest3 = {jule1978, may1984, jan1996, june2002};
        //  averageTime(timeTest3);
        //  13 ноября 2098 года, 00:04:12.034 и 20 мая 1991 года, 20:37:06.804 вывел на консоль:
        Date date1991 = new Date(91, 04, 20, 20, 37, 6);
        Date date2098 = new Date(198, 10, 13, 0, 4, 12);
        // timeBetween(date1991,date2098);
        //30 сентября 2069 года, 14:12:32.228 и 17 мая 2088 года, 12:19:52.725 вывел на консоль:
        Date date2069 = new Date(169, 8, 30, 14, 12, 32);
        Date date2088 = new Date(188, 4, 17, 12, 19, 52);
         timeBetween(date2069, date2088);


    }
}
