package gp;

import java.text.ParseException;
import java.util.TimeZone;

public class TimeZoneAvailables {

    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss a";

    public static void main(String[] args) throws ParseException {

        String[] ids = TimeZone.getAvailableIDs();
        for (String availableId : ids) {
            TimeZone timeZone = TimeZone.getTimeZone(availableId);
            System.out.print("Available Time Zone:" + availableId);
            System.out.println(" -- Time Zone info:" + timeZone);
        }

    }
}
