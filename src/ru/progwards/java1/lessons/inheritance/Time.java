package ru.progwards.java1.lessons.inheritance;


public class Time {
    public int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        String hour;
        String second;
        String minut;
        if (hours < 10 && hours >= 0) {
            hour = "0" + hours;
        } else hour = "" + hours;
        if (minutes >= 0 && minutes < 10) {
            minut = "0" + minutes;
        } else minut = "" + minutes;

        if (seconds < 10 && seconds >= 0) {
            second = "0" + seconds;
        } else second = "" + seconds;
        return hour + ":" + minut + ":" + second;
    }

    public int toSeconds() {
         return hours * 60 * 60 + minutes * 60 + seconds;
    }

    public int secondsBetween(Time time) {
        if (this.toSeconds() < time.toSeconds()) {
            return time.toSeconds() - this.toSeconds();
        } else return this.toSeconds() - time.toSeconds();
    }
    public TimeZone getTimeZone(){
        return null;
    }

    public static void main(String[] args) {
        Time time = new Time(1, 3, 5);
        Time time1 = new Time(1, 25, 5);
        System.out.println(time);
        System.out.println(time1.secondsBetween(time));
    }
}