package gp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneChangeDateExample {

    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss a";

    public static void main(String[] args) throws ParseException {

        // the date
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 06, 29, 8, 30);
        Date date = cal.getTime();

        // format with tz
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Amsterdam");
        SimpleDateFormat formatterWithTimeZone = new SimpleDateFormat(DATE_FORMAT);
        formatterWithTimeZone.setTimeZone(timeZone);

        // change tz using formatter
        String sDate = formatterWithTimeZone.format(date);

        // string to object date
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date dateWithTimeZone = formatter.parse(sDate); // string to Date Object


        System.out.println("The actual date is: " + formatter.format(date));
        System.out.println("The date in " + timeZone.getID() + " is: " + sDate);
        System.out.println("Object date: " + formatter.format(dateWithTimeZone));
    }
}
