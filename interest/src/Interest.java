/*
  Breanna Rayburn
  File: SumOfTwoInts.java
  Date: 08/18/2026
*/

public class Interest 
{
  public static void main(String[] args)
  {
    double principal;
    double rate;
    double interest;

    principal = 17000;
    rate = 0.027;
    interest = principal * rate;

    principal = principal + interest;

    System.out.print("The interest earned is $");
    System.out.println(interest);
    System.out.print("The value of the investment after one year is $");
    System.out.println(principal);
  }
}
