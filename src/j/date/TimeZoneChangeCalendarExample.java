package gp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneChangeCalendarExample {

    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss a";

    public static void main(String[] args) throws ParseException {

        // calendar with tx
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Amsterdam");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 06, 29, 8, 30);
        calendar.setTimeZone(timeZone);

        // get calendar using fields
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        System.out.println("The actual date is: " + formatter.format(calendar.getTime()));
        System.out.print("The date in " + timeZone.getID() + " is: ");
        System.out.print(" Day:" + dayOfMonth);
        System.out.print(" Month:" + (month + 1)); // base zero
        System.out.print(" Year:" + year);
        System.out.print(" Hour:" + hourOfDay);
        System.out.print(" Min:" + minute);
        System.out.print(" Sec:" + second);

        System.out.println();

        // calendar getTime with DateFormat
        SimpleDateFormat formatterWithTimeZone = new SimpleDateFormat(DATE_FORMAT);
        formatterWithTimeZone.setTimeZone(timeZone);
        System.out.println("Calendar.getTime() - Date in Local TZ:" + formatterWithTimeZone.format(calendar.getTime()));

    }
}
