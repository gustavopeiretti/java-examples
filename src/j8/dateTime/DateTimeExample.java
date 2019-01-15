package j8.dateTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeExample {

    public static void main(String[] args) {

        // LocalDate
        localDateExample();

        // LocalTime
        localTimeExample();

        // LocalDateTime
        localDateTimeExample();

        // ZonedDateTime
        zonedDateTimeExample();

        // Period
        periodExample();

        // Duration
        durationExample();

    }


    private static void localDateExample() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());

        LocalDate localDateOf = LocalDate.of(2017, 10, 10);
        System.out.println(localDateOf.toString()); // 2017-10-10

        LocalDate datePlus = localDateOf.plusDays(7);
        System.out.println(datePlus.toString());  // 2017-10-17

        LocalDate dateMinus = localDateOf.minusDays(7);
        System.out.println(dateMinus.toString()); // 2017-10-03

        boolean isBefore = LocalDate.of(2017, 10, 10)
                .isBefore(LocalDate.of(2017, 8, 20));
        System.out.println(isBefore); // false


        boolean isAfter = LocalDate.of(2017, 10, 10)
                .isAfter(LocalDate.of(2017, 8, 20));
        System.out.println(isAfter); // true
    }

    private static void localTimeExample() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime hour = LocalTime.of(6, 30);
        System.out.println(hour); // 06:30


        LocalTime localTimePlus = hour.plus(1, ChronoUnit.HOURS);
        System.out.println(localTimePlus); // 07:30

        LocalTime localTimeMinus = hour.minus(60, ChronoUnit.SECONDS);
        System.out.println(localTimeMinus); // 06:29

        boolean isBeforeHour = LocalTime.parse("08:30")
                .isBefore(LocalTime.parse("10:20"));
        System.out.println(isBeforeHour); // true
    }

    private static void localDateTimeExample() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);


        LocalDateTime localDateTimeOf = LocalDateTime.of(2017, Month.AUGUST, 20, 8, 30);
        System.out.println(localDateTimeOf); // 2017-08-20T08:30


        LocalDateTime localDateTimePlus = localDateTimeOf.plusDays(5);
        System.out.println(localDateTimePlus); // 2017-08-25T08:30

        LocalDateTime localDateTimeMinus = localDateTimePlus.minusMinutes(10);
        System.out.println(localDateTimeMinus); // 2017-08-25T08:20
    }


    private static void zonedDateTimeExample() {
        ZoneId.getAvailableZoneIds().forEach(z -> System.out.println(z)); // list of all zones

        ZoneId zoneId = ZoneId.of("America/Panama");
        LocalDateTime localDateTimeOf = LocalDateTime.of(2017, Month.AUGUST, 20, 8, 30);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTimeOf, zoneId);
        System.out.println(zonedDateTime); // 2017-08-20T08:30-05:00[America/Panama]

        ZonedDateTime tokyoDateTime = localDateTimeOf.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyoDateTime); // 2017-08-20T08:30+09:00[Asia/Tokyo]
    }


    private static void periodExample() {
        LocalDate startLocalDate = LocalDate.of(2017, 10, 10);
        LocalDate endLocalDate = startLocalDate.plus(Period.ofDays(10));  // 2017-10-20

        int diffDays = Period.between(startLocalDate, endLocalDate).getDays();
        System.out.println(diffDays); // 10
    }

    private static void durationExample() {
        LocalTime startLocalTime = LocalTime.of(8, 30);
        LocalTime endLocalTime = startLocalTime.plus(Duration.ofHours(3));  // 11:30

        long diffSeconds = Duration.between(startLocalTime, endLocalTime).getSeconds();
        System.out.println(diffSeconds); // 10800 seconds
    }

}
