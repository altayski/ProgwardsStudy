package ru.progwards.java1.lessons.date;

import java.time.Instant;
import java.time.LocalDateTime;
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
        timeDifference = calculate(convert(date1), convert(date2));
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
        timeDifference = calculate(convert(now), convert(birthday));
        System.out.println("До дня рождения "
                + timeDifference.getMonth() + " месяцев, "
                + timeDifference.getDays() + " дней, "
                + timeDifference.getHours() + " часов, "
                + timeDifference.getMinutes() + " минут, "
                + timeDifference.getSeconds() + " секунд, "
                + timeDifference.getMillis() + " миллисекунд");
    }

    private static LocalDateTime convert(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static TimeDifference calculate(LocalDateTime start, LocalDateTime end) {
        int yearsBetween = 0, monthBetween = 0, daysBetween = 0, hourBetween = 0, minutesBetween = 0, secondsBetween = 0, millisBetween = 0;
        boolean isAfter = start.isAfter(end);
        while(start.isAfter(end) == isAfter){
            yearsBetween++;
            start =  start.plusYears(isAfter ? -1 : 1);
        }
        yearsBetween -= isAfter ? 0 : 1;
        start = start.plusYears(isAfter ? 0 : -1);

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
        int st = start.getNano();
        int ed = end.getNano();
        millisBetween = whereAreMillis(st, ed);
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
        return milllisBetween/1000000;
    }


    public static void averageTime(Date[] events) {
        TimeDifference timeDifference;
        //LocalDateTime one = convert(events[0]);
        //LocalDateTime two = convert(events[events.length-1]);
        long fromDate = events[0].toInstant().toEpochMilli();
        long fromDate2 = events[events.length-1].toInstant().toEpochMilli();
        long difference = (fromDate2-fromDate) / (events.length-1);

       // LocalDateTime avBegin = LocalDateTime.of(1978, Month.JULY, 18, 3, 8, 46,376000000);//первая
        //LocalDateTime avEnd = LocalDateTime.of(2002, Month.JUNE, 15, 5, 23, 57,386000000);//первая
        // LocalDateTime av = LocalDateTime.of(1972, Month.JANUARY, 3, 19, 6, 32,214000000);// втора
         //LocalDateTime avF = LocalDateTime.of(2004, Month.MARCH, 1, 12, 8, 50,220000000);//вторая
        // timeDifference = calculateBefore(av,avF);
//        LocalDateTime sk = LocalDateTime.of(1978,Month.JULY,18,3,8,46,376000000);
//        LocalDateTime skF = LocalDateTime.of(2002,Month.JUNE,15,5,23,57,386000000);
                //LocalDateTime avg = LocalDateTime.of(1974,8,24,2,8,13,603000000);
        //LocalDateTime dec = LocalDateTime.of(2008,12,21,15,27,23,608000000);

       // long milliseconds = avBegin.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
       // long milliseconds1 = avEnd.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
       // long diff = (milliseconds1-milliseconds)/3;
        Instant epo = Instant.EPOCH;
        //Instant finish = Instant.ofEpochMilli(diff);
        Instant dateFinish = Instant.ofEpochMilli(difference);
       // timeDifference = calculateBefore(avBegin, avEnd);
        LocalDateTime zero = LocalDateTime.ofInstant(epo,ZoneId.of("UTC"));
       // LocalDateTime dateTime = LocalDateTime.ofInstant(finish,ZoneId.of("UTC"));
        LocalDateTime fromDateTime = LocalDateTime.ofInstant(dateFinish,ZoneId.of("UTC"));
        timeDifference = calculate(zero,fromDateTime);

        //        timeDifference = calculateBefore(convert(events[0]), convert(events[max - 1]));
        // LocalDateTime av = LocalDateTime.of(1972, Month.JANUARY, 3, 19, 6, 32,214);// втора
        // LocalDateTime avF = LocalDateTime.of(2004, Month.MARCH, 1, 12, 8, 50,220);//вторая
        // timeDifference = calculateBefore(av,avF);
//        LocalDateTime sk = LocalDateTime.of(1978,Month.JULY,18,3,8,46,376);
//        LocalDateTime skF = LocalDateTime.of(2002,Month.JUNE,15,5,23,57,386);
//        timeDifference = calculateBefore(sk,skF);



        System.out.println("Среднее время между событиями "
                + timeDifference.getYears() + " лет, "
                + timeDifference.getMonth() + " месяцев, "
                + timeDifference.getDays() + " дней, "
                + timeDifference.getHours() + " часов, "
                + timeDifference.getMinutes() + " минут, "
                + timeDifference.getSeconds() + " секунд, "
                + timeDifference.getMillis() + " миллисекунд");
    }


    public static void main(String[] args) {
      Date one = new Date(2019, Calendar.MARCH, 21, 8, 6, 48);
       Date two = new Date(2024, Calendar.FEBRUARY, 20, 17, 35, 53);
        Date one1 = new Date(1973, Calendar.MARCH,1,9,37,46);
        Date two1 = new Date(2083, Calendar.DECEMBER,17, 12,33,5);
        Date september1 = new Date(2098, Calendar.SEPTEMBER, 3, 17, 33, 7);
        Date april = new Date(2087, Calendar.APRIL, 6, 6, 19, 21);
//        Date febr19 = new Date(2019,Calendar.FEBRUARY,21);
//        Date febr20 = new Date(2024, Calendar.FEBRUARY,20);
//        Date dec30 = new Date(2022, Calendar.DECEMBER,29);
//        Date mart5 = new Date(2023,Calendar.MARCH,5);
//        timeBetween(dec30,mart5);
        // timeBetween(febr19,febr20);

        //System.out.println("Расчет между датами: ");
        // timeBetween(one1, two1);
       // timeBetween(one,two);
           timeBetween(april,september1);
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
       //  timeToBirthday(testFin,testFrom);
        Date apr95 = new Date(1995, Calendar.APRIL, 2, 7, 54, 29);
        Date may23 = new Date(2023, Calendar.MAY, 19, 14, 46, 11);
         timeToBirthday(may23,apr95);

        Date june = new Date(76, 5, 24, 9, 9, 45);
        Date october = new Date(83, 9, 24, 18, 8, 14);
        Date september = new Date(91, 8, 12, 5, 3, 0);
        Date may = new Date(106, 4, 26, 16, 51, 48);
        Date[] test1 = {june, october, september, may};
          averageTime(test1);
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
        Date jule1978 = new Date(78,6,18,3,8,46);
        Date may1984 = new Date(84,4,21,19,5,6);
        Date jan1996 = new Date(96,0,20,2,19,46);
        Date june2002 = new Date(102,5,15,5,23,57);
        Date[] timeTest3 = {jule1978,may1984,jan1996,june2002};
      //  averageTime(timeTest3);


    }
}
