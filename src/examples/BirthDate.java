package examples;

public class BirthDate {

    public enum month{
        JAN, FEB, MAR, APRIL, MAY, JUN, JUL, AUG, SEPT, OCT, NOV, DEC;
    }
    private int day;
    private month month;
       private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public BirthDate.month getMonth() {
        return month;
    }

    public void setMonth(BirthDate.month month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
