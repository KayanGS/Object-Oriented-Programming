import java.time.LocalDate;

public final class DeadLine {

    private final String time;
    private final int day;
    private final int month;
    private final int year;

    /**
     * @param time
     * @param day
     * @param month
     * @param year
     */
    public DeadLine(String time, int day, int month, int year) {
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time; //################### RETURN ####################
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day; //################### RETURN ####################
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month; //################### RETURN ####################
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year; //################### RETURN ####################
    }

    /**
     * @param time
     * @return if date is past the deadline
     */
    public boolean beforeDeadline(LocalDate time) {
        boolean dateIsBefore = false;
        // If date is past the deadline will return true
        if (time.isAfter(LocalDate.of(year, month, day))) {
            dateIsBefore = false;
        } else {
            dateIsBefore = true;
        }
        //Return true if the date is past the deadline
        return dateIsBefore; //################### RETURN ####################
    }

    public String toString() {
        return (
        "DeadLine [" +
        "time: " +
        time +
        "date: " +
        day +
        "/" +
        month +
        "/" +
        year +
        "]"
        ); //################### RETURN ####################
    }
}
