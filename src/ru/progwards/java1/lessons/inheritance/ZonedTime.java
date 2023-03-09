package ru.progwards.java1.lessons.inheritance;

public class ZonedTime extends Time {
    TimeZone zone;

    public ZonedTime(int hours, int minutes, int seconds) {
        super(hours, minutes, seconds);
        zone = null;
    }

    public ZonedTime(int hours, int minutes, int seconds, TimeZone zone) {
        super(hours, minutes, seconds);
        this.zone = zone;
    }

    @Override
    public TimeZone getTimeZone() {
        return zone;
    }

    @Override
    public int secondsBetween(Time time) {
        int timeCorrection = 0;
        int timeTosec;
        if (this.toSeconds() < time.toSeconds()) {
            timeTosec = time.toSeconds() - this.toSeconds();
        } else timeTosec = this.toSeconds() - time.toSeconds();


        if (this.getTimeZone() == null && time.getTimeZone() != null) {
            timeCorrection = Math.abs(time.getTimeZone().hours * 60 * 60 + time.getTimeZone().minutes * 60);

        } else if (this.getTimeZone() != null && time.getTimeZone() == null) {
            timeCorrection = Math.abs(this.getTimeZone().hours * 60 * 60 + this.getTimeZone().minutes * 60);

        } else if (this.getTimeZone() != null & time.getTimeZone() != null) {
            timeCorrection = Math.abs(this.getTimeZone().hours * 3600 + this.getTimeZone().minutes * 60 + time.getTimeZone().hours * 3600 + time.getTimeZone().minutes * 60);
        }

        return timeTosec - timeCorrection;
    }

    public static void main(String[] args) {
        ZonedTime zt1 = new ZonedTime(4, 6, 44, new TimeZone(-2, 58));
        Time t1 = new Time(21, 2, 7);
        Time t2 = new Time(10, 2, 7);
        System.out.println(t1.secondsBetween(t2));
        System.out.println(zt1.secondsBetween(t1));

//        ZonedTime zt1 = new ZonedTime(4, 51, 3, new TimeZone(-1));
//        ZonedTime zt2 = new ZonedTime(9, 11, 44, new TimeZone(-2));
//        System.out.println(zt1.secondsBetween(zt2));


        TimeZone bratislava = new TimeZone(2);
        TimeZone batumi = new TimeZone(4);
        ZonedTime bratislavaTime = new ZonedTime(17, 14, 0, bratislava);
        ZonedTime batumiTime = new ZonedTime(19, 14, 0, batumi);
        ZonedTime london = new ZonedTime(15, 55, 0);
        ZonedTime rekjavik = new ZonedTime(14, 55, 0);
        System.out.println(london.secondsBetween(rekjavik));
//        TimeZone RioZone = new TimeZone(-4, 0);
//        ZonedTime rio = new ZonedTime(12, 10, 0, RioZone);
//        System.out.println(london.secondsBetween(rio));
//
//        System.out.println(bratislavaTime.secondsBetween(london));//расчет разницы между гринвичем и братиславой
//        System.out.println(bratislavaTime.secondsBetween(london));//расчет разницы между братиславой и гринвичем
//
        System.out.println(batumiTime.secondsBetween(bratislavaTime));

    }
}