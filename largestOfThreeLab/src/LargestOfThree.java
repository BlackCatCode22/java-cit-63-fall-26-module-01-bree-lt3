// =============================
// File Name: LargestOfThree.java
// Author: Breanna and LJ
// Date: August 25, 2026
// Course: CIT63 Java Programming
// Instructor: Professor Dennis Mohle
// Description: Determines the largest of three hard-coded integers using nested if-else decision control structures.
// =============================

public class LargestOfThree 
{
  public static void main(String[] args)
  {
    int num1 = 3;
    int num2 = 12;
    int num3 = 4;
    int largestInt;

    if (num1 > num2)
    {
      if (num1 > num3)
      {
        largestInt = num1;
      }
      else
      {
        largestInt = num3;
      }
    }
    else
    {
      if (num2 > num3)
      {
        largestInt = num2;
      }
      else
      {
        largestInt = num3;
      }
    }

    System.out.println("The numbers are: " + num1 + ", " + num2 + ", " + num3);
    System.out.println("The largest number is: " + largestInt);
  }
}
