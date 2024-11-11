import java.time.LocalDate;

public class MyDate {
    int day;
    int month;
    int year;

    public MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getAge(){
        return LocalDate.now().getYear() - this.year;
    }

    @Override
    public String toString(){
        return day +"."+month+"."+year;
    }
}
