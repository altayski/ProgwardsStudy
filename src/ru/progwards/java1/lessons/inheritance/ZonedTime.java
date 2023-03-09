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
            timeCorrection = time.getTimeZone().hours * 3600 + time.getTimeZone().minutes * 60;

        } else if (this.getTimeZone() != null && time.getTimeZone() == null) {
            timeCorrection = this.getTimeZone().hours * 3600 + this.getTimeZone().minutes * 60;

        } else if (this.getTimeZone() != null & time.getTimeZone() != null) {
            timeCorrection = this.getTimeZone().hours * 3600 + this.getTimeZone().minutes * 60 + time.getTimeZone().hours * 3600 + time.getTimeZone().minutes * 60;
        }

        return timeTosec + timeCorrection;
    }

    public static void main(String[] args) {

        ZonedTime zt1 = new ZonedTime(8, 40, 55, new TimeZone(0, 28));
        Time t1 = new Time(18, 22, 23);
        System.out.println(zt1.secondsBetween(t1));


        ZonedTime zt2 = new ZonedTime(4, 6, 44, new TimeZone(-2, 58));
        Time t2 = new Time(21, 2, 7);

        System.out.println(zt2.secondsBetween(t2));

        ZonedTime zt3 = new ZonedTime(4, 51, 3, new TimeZone(-1));
        ZonedTime zt4 = new ZonedTime(9, 11, 44, new TimeZone(-2));
        System.out.println(zt3.secondsBetween(zt4));
    }
}