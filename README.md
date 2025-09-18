British Time Converter
======================

Description:
------------
A Java utility that converts 24-hour formatted time (HH:mm) into British English spoken form.

Examples:
- 00:00 -> midnight
- 12:00 -> noon
- 07:30 -> half past seven
- 07:35 -> twenty-five to eight
- 06:32 -> six thirty-two

Requirements:
-------------
- Java 8 or higher
- Maven 3 or higher

Project Structure:
------------
british-time-converter/
├── src/main/java/com/example/time/
│ ├── TimeConverterMain.java
│ └── TimeToWords.java
| └── NumberToWords.java
├── src/test/java/com/example/time/
│ └── TimeConverterMainTest.java
├── pom.xml
└── README.md

Build & Run:
------------
1. Compile and package:
   mvn clean package

2. Run the application:
   java -cp target/british-time-converter-1.0.jar com.example.time.TimeConverterMain

Run Tests:
----------
mvn test

Example:
--------
Input: 07:35
Output: twenty-five to eight