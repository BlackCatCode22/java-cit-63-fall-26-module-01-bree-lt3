/*
  Breanna Rayburn
  File: LargestOfThree.java
  Date: 08/18/2026
*/

import java.util.Scanner;

public class LargestOfThree 
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    
    int num1;
    int num2;
    int num3;
    
    System.out.print("First number: ");
    num1 = scanner.nextInt();

    System.out.print("Second number: ");
    num2 = scanner.nextInt();

    System.out.print("Third number: ");
    num3 = scanner.nextInt();

    if(num1 > num2 && num1 > num3) 
    {
      System.out.println("The biggest number is: " + num1);
    } else if (num2 > num1 && num2 > num3)
    {
      System.out.println("The biggest number is: " + num2);
    } else if (num3 > num1 && num3 > num2)
    {
      System.out.println("The biggest number is: " + num3);
    } else
    {
      System.out.println("Error at least 2 numbers are the same.");
    }
  }
}
