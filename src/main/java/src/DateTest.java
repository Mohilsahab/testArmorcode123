package src;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        Date date1 = new Date(2021);
        System.out.println(date);
        System.out.println(date1);
        System.out.println(date.compareTo(date1));
    }
}
