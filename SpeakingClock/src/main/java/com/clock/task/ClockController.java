package com.clock.task;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/speakingclock")
public class ClockController {
	@Autowired
    private ClockService clockService;

    @GetMapping("/current")
    public ResponseEntity<String> getCurrentTimeInWords() {
        String timeInWords = clockService.convertTimeToWords(LocalTime.now());
        return ResponseEntity.ok(timeInWords);
    }

    @GetMapping("/convert/{time}")
    public ResponseEntity<String> convertTime(@PathVariable String time) throws InvalidTimeFormatException {
        try {
            String timeInWords = clockService.convertTimeToWords(LocalTime.parse(time));
            return ResponseEntity.ok(timeInWords);
        } catch (DateTimeParseException e) {
            throw new InvalidTimeFormatException("Invalid time format, expected HH:mm");
        }
    }

}
