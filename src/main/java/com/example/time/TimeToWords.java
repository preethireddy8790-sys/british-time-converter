package com.example.time;

public class TimeToWords {
    public String convert(String time) {

        if (time == null || !time.matches("\\d{1,2}:\\d{2}")) {
            return "Invalid time";
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            return "Invalid time";
        }

        // Handle special cases
        String special = handleSpecialCases(hour, minute);
        if (special != null) return special;

        // Exact hour
        if (minute == 0) {
            return getHourWord(hour) + " o'clock";
        }

        // Only use past/to for round minutes
        if (isRoundMinute(minute)) {
            if (minute <= 30) {
                return handlePast(hour, minute);
            } else {
                return handleTo(hour, minute);
            }
        }

        // Otherwise, just read hour + minute
        return getHourWord(hour) + " " + NumberToWords.toWord(minute);
    }

    // New helper method
    private boolean isRoundMinute(int minute) {
        return minute % 5 == 0;
    }


    private String handleSpecialCases(int hour, int minute) {
        if (hour == 0 && minute == 0) {
            return "midnight";
        }
        if (hour == 12 && minute == 0) {
            return "noon";
        }
        return null;
    }

    private String handlePast(int hour, int minute) {
        int h = hour % 12 == 0 ? 12 : hour % 12;
        String minuteWord = NumberToWords.toWord(minute);
        return minuteWord + " past " + NumberToWords.toWord(h);
    }

    private String handleTo(int hour, int minute) {
        int minutesTo = 60 - minute;
        int nextHour = (hour + 1) % 24;
        int h = nextHour % 12 == 0 ? 12 : nextHour % 12;
        String minuteWord = NumberToWords.toWord(minutesTo);
        return minuteWord + " to " + NumberToWords.toWord(h);
    }

    private String getHourWord(int hour) {
        int h = hour % 12 == 0 ? 12 : hour % 12;
        return NumberToWords.toWord(h);
    }
}
