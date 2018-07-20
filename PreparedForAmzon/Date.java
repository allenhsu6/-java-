package PreparedForAmzon;

public class Date {
    private final int month;
    private final int year;
    private final int day;

    public Date(int year, int month, int date) {
        this.month = month;
        this.year = year;
        this.day = date;
    }

    @Override
    public String toString() {
        return "Date{" +
                year +
                "/" + month +
                "/" + day +
                '}';
    }


}
