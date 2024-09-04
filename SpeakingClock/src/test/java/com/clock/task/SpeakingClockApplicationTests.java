package com.clock.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeakingClockApplicationTests {

	@Autowired
    private ClockService timeService;

    @Test
    public void testConvertTimeToWords_Midnight() {
        LocalTime midnight = LocalTime.of(0, 0);
        String result = timeService.convertTimeToWords(midnight);
        assertEquals("Time is Midnight", result);
    }

    @Test
    public void testConvertTimeToWords_Midday() {
        LocalTime midday = LocalTime.of(12, 0);
        String result = timeService.convertTimeToWords(midday);
        assertEquals("This is  Mid-day", result);
    }

    @Test
    public void testConvertTimeToWords_NormalTime() {
        LocalTime time = LocalTime.of(8, 34);
        String result = timeService.convertTimeToWords(time);
        assertEquals("It's eight thirty-four", result);
    }

}
