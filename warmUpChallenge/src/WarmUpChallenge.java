// ===============================
// File Name: WarmUpChallenge.java
// Programmer: Breanna Rayburn
// ===============================

import java.util.Scanner;

public class WarmUpChallenge 
{
  public static void main(String[] args)
  {
    System.out.println("The largest int is " + largestOfTwo(getAnIntFromTheUser(), getAnIntFromTheUser()));
    //sumTwoInts(getAnIntFromTheUser(), getAnIntFromTheUser());
  }
  
  public static int getAnIntFromTheUser()
  {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please enter a number: ");
    int userInt = scanner.nextInt();

    return userInt;
  }

  public static int largestOfTwo(int num1, int num2)
  {
    if (num1 > num2)
    {
      return num1;
    } else
    {
      return num2;
    }
  }

  public static void sumTwoInts(int num1, int num2)
  {
    int sum = num1 + num2;
    System.out.println("The sum is " + sum);
  }
}
