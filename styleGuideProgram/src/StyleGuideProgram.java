/*
  File Name: StyleGuideProgram.java
  Author: Breanna
  Date: 08/20/26
  Course: CIT63 Java Programming
  Instructor: Professor Mohle
  Description: Demonstrates CIT63 style guidelines, program headers, and outputs current UTC data and time.
*/

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class StyleGuideProgram
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to the Java Programming Style Guide Program");

    displayUtcDateTime();
  }

  public static void displayUtcDateTime()
  {
    Instant nowUtc = Instant.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'and the time is:' HH:mm:ss 'UTC'").withZone(ZoneOffset.UTC);

    System.out.println("Today is " + formatter.format(nowUtc));
  }
}
