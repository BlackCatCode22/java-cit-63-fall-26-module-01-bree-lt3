/*
  Breanna Rayburn
  File: SumOfTwoInts.java
  Date: 08/18/2026
*/

import java.util.Scanner;

public class SumOfTwoInts 
{
  public static void main (String[] args) 
  {
    int firstInt = getAnIntFromTheUser();
    int secondInt = getAnIntFromTheUser();

    int sum = sumTwoInts(firstInt, secondInt);

    System.out.println("The sum is: " + sum);

  }

  public static int getAnIntFromTheUser() 
  {
    Scanner scanner = new Scanner(System.in); 

    System.out.print("Enter an integer: ");
    int userInt = scanner.nextInt();

    return userInt;
  }

  public static int sumTwoInts(int firstInt, int secondInt) 
  {
    int sum = firstInt + secondInt;

    return sum;
  }
}
