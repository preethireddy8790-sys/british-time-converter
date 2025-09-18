package com.example.time;

import java.util.Scanner;

/**
 * Hello world!
 */
public class TimeConverterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeToWords converter = new TimeToWords();

        System.out.println("Enter time in HH:mm format:");
        String input = scanner.nextLine();

        String result = converter.convert(input);
        System.out.println("Spoken form: " + result);
    }
}




