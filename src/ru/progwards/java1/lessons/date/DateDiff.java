package ru.progwards.java1.lessons.date;


import java.time.*;
import java.util.Date;

public class DateDiff {
    public static void timeBetween(Date date1, Date date2) {
        Period period = calculateYearMonthDays(convertToLocalDate(date1), convertToLocalDate(date2));
        Duration duration = calculateMinutesSecondsMillis(convertToLocalDateTime(date1), convertToLocalDateTime(date2));
        System.out.println("Между date1 и date2 " + period.getYears() + " лет, " + period.getMonths() +
                " месяцев, " + period.getDays() + " дней, " + duration.toMinutesPart() + " минут, " + duration.toSecondsPart() +
                " секунд, " + duration.toMillisPart() + " миллисекунд");
    }

    public static void timeToBirthday(Date now, Date birthday) {
        Period period = calculateYearMonthDays(convertToLocalDate(now), convertToLocalDate(birthday));//находим период: годы, месяцы, дни
        Duration duration = calculateMinutesSecondsMillis(convertToLocalDateTime(now), convertToLocalDateTime(birthday));//находим время: минуты, секунды, миллисекунды
        System.out.println("До дня рождения " + period.getMonths() + " месяцев, " + period.getDays() + " дней, " + duration.toMinutesPart() + " минут, " + duration.toSecondsPart() + " секунд, " + duration.toMillisPart() + " миллисекунд");
        // System.out.print("До дня рождения ");
        // System.out.printf("%d месяцев, %d дней, %d минут, %d секунд, %d миллисекунд",period.getMonths(),period.getDays(),duration.toMinutesPart(),duration.toSecondsPart(),duration.toMillisPart());

    }

    public static void averageTime(Date[] events) {
        int sumYears = 0, sumMonth=0, sumDays=0, sumMunutes=0, sumSeconds=0, sumMillis = 0;
        int max = events.length;
        Period period;
        Duration duration;
        LocalDate[] localDates = new LocalDate[events.length];
        LocalDateTime[] localDateTimes = new LocalDateTime[events.length];
        for (int i = 0; i < events.length; i++) {
            localDates[i] = convertToLocalDate(events[i]);
            localDateTimes[i] = convertToLocalDateTime(events[i]);
        }

            for (int i=0,j = 1; i<max-1 && j < max; j++, i++) {
                period = calculateYearMonthDays(localDates[i], localDates[j]);
                sumYears+= period.getYears();
                sumMonth+= period.getMonths();
                sumDays+= period.getDays();
        }
        for (int i = 0, j= 1; i < max-1&& j <max; i++, j++) {
            duration = calculateMinutesSecondsMillis(localDateTimes[i],localDateTimes[j]);
            sumMunutes+=duration.toMinutesPart();
            sumSeconds+= duration.toSecondsPart();
            sumMillis+= duration.toMillisPart();

        }
        long averageYear =Math.round(sumYears*1.0/max);
        long averageMonth = Math.round(sumMonth*1.0/max);
        long averageDays = Math.round(sumDays*1.0/max);
        long averageMinutes = Math.round(sumMunutes*1.0/max);
        long averageSeconds = Math.round(sumMunutes*1.0/max);
        long averageMillis = Math.round(sumMillis*1.0/max);

        System.out.println("Среднее время между событиями "+averageYear+" лет, "+averageMonth+" месяцев, "+averageDays+" дней, "+averageMinutes+" минут, "+averageSeconds+" секунд, "+averageMillis+" миллисекунд");
    }

    private static LocalDateTime convertToLocalDateTime(Date time) {//конвертер из Date в LocalDateTime для расчета часового времени
        return time.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private static LocalDate convertToLocalDate(Date date) {//конвертер из Date в LocalDate для расчета периода времени
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static Period calculateYearMonthDays(LocalDate one, LocalDate two) {//калькулятор на годы, месяцы, дни
        return Period.between(one, two);
    }
    private static Duration calculateMinutesSecondsMillis(LocalDateTime one, LocalDateTime two) {//калькулятор на время
        return Duration.between(one, two);
    }


    public static void main(String[] args) {
        // DateDiff diff = new DateDiff();
        Date one = new Date(2010, 0, 29);
        Date two = new Date(2011, 2, 31, 11, 10, 50);
        System.out.println("Расчет между датами: ");
       // timeBetween(two, one);
        Date date = new Date();
        Date birth = new Date(124, 2, 12, 7, 00);
       // System.out.print("Расчёт до дня рождения: ");
      //  timeToBirthday(date, birth);
        Date seul = new Date(88, 8, 17, 10, 0, 15);
        Date barselona = new Date(92, 6, 25, 9, 0, 20);
        Date atlanta = new Date(96, 6, 19, 10, 30, 26);
        Date sydnei = new Date(100, 8, 15, 16, 30, 37);
        Date athens = new Date(104, 7, 13, 10, 0, 56);
        Date peking = new Date(108, 7, 8, 12, 30, 57);
        Date london = new Date(112, 6, 27, 8, 30, 49);
        Date rio = new Date(116, 7, 5, 19, 30, 11);
        Date today = new Date();
        Date[] olympic = {seul, barselona, atlanta, sydnei, athens, peking, london, rio,today};
        averageTime(olympic);
       // timeBetween(london,rio);
    }
}
