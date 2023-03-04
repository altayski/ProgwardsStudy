package ru.progwards.java1.lessons.classes1;


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
        if (hours < 10 && hours >= 0) {
            hour = "0" + hours;
        } else hour = String.valueOf(hours);

        if (seconds < 10 && seconds >= 0) {
            second = "0" + seconds;
        } else second = String.valueOf(seconds);
        return "" + hour + ":" + minutes + ":" + second + "";
    }

    public int toSeconds() {
        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    public int secondsBetween(Time time) {
        if (this.toSeconds() < time.toSeconds()) {
            return time.toSeconds() - this.toSeconds();
        } else return this.toSeconds() - time.toSeconds();
    }

    public static void main(String[] args) {
        Time time = new Time(1, 30, 5);
        Time time1 = new Time(1, 25, 5);
        System.out.println(time);
        System.out.println(time1.secondsBetween(time));
    }
}