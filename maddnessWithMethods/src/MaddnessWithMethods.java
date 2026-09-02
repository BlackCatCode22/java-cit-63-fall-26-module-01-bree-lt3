import java.util.Scanner;

public class MaddnessWithMethods 
{
  public static void main(String[] args)
  {
    // get 2 user ints and assign them 
    System.out.print("Enter a number: ");
    int num1 = getAnIntFromTheUser();
    System.out.print("Enter another number: ");
    int num2 = getAnIntFromTheUser();

    compareTwoInts(num1, num2);
    sumTwoInts(num1, num2);
  }

  public static int getAnIntFromTheUser()
  {
    Scanner scanner = new Scanner(System.in);
    
    int userInt = scanner.nextInt();
    
    return userInt;
  }

  public static void compareTwoInts(int num1, int num2)
  {
    if (num1 > num2)
    {
      System.out.println(num1 + " is greater than " + num2);
    } else
    {
      System.out.println(num2 + " is greater than " + num1);
    }
  }

  public static void sumTwoInts(int num1, int num2)
  {
    int sum = num1 + num2;
    System.out.println("The sum of the two numbers are: " + sum);
  }
}
