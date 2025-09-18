package com.example.time;

public class NumberToWords {
    private static final String[] ones = {
            "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    public static String toWord(int number) {
        if (number == 15) return "quarter";
        if (number == 30) return "half";

        if (number < 20) {
            return ones[number];
        }
        if (number < 60) {
            int tenPart = number / 10;
            int onePart = number % 10;
            return onePart == 0 ? tens[tenPart] : tens[tenPart] + "-" + ones[onePart];
        }
        return String.valueOf(number); 
    }
}

