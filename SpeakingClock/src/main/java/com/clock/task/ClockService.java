package com.clock.task;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class ClockService {

	private static final String[] hoursarr = { "midnight", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "midday" };
    private static final String[] minutesarr= { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "half" };

    public String convertTimeToWords(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();

        if (hour == 0 && minute == 0) {
            return "Time is Midnight";
        } else if (hour == 12 && minute == 0) {
            return "This is  Mid-day";
        } else {
            String hourInWords = hoursarr[hour % 12];
            String minuteInWords = minute == 0 ? "" : minutesarr[minute];
            return "It's " + hourInWords + (minute > 0 ? " " + minuteInWords : "");
        }

    }
}
