package com.example.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class TimeConverterMainTest {

    private final TimeToWords converter = new TimeToWords();

    @Test
    void testSpecialCases() {
        assertEquals("midnight", converter.convert("00:00"));
        assertEquals("noon", converter.convert("12:00"));
    }

    @Test
    void testExactHour() {
        assertEquals("one o'clock", converter.convert("01:00"));
    }

    @Test
    void testPastMinutes() {
        assertEquals("five past two", converter.convert("02:05"));
        assertEquals("quarter past four", converter.convert("04:15"));
        assertEquals("half past seven", converter.convert("07:30"));
    }

    @Test
    void testToMinutes() {
        assertEquals("twenty-five to eight", converter.convert("07:35"));
        assertEquals("quarter to ten", converter.convert("09:45"));
        assertEquals("five to twelve", converter.convert("11:55"));
    }

    @Test
    void testDirectNumericFallback() {
        assertEquals("six thirty-two", converter.convert("06:32"));
        assertEquals("seven thirty-three", converter.convert("07:33"));
    }

    @Test
    void testInvalidFormat() {
        assertEquals("Invalid time", converter.convert("34:90"));
        assertEquals("Invalid time", converter.convert("abcd"));
        assertEquals("Invalid time", converter.convert(""));
        assertEquals("Invalid time", converter.convert("1-40"));
        assertEquals("Invalid time", converter.convert("3:23a"));
    }

    @Test
    void testNullInput() {
        assertEquals("Invalid time", converter.convert(null));
    }
}

