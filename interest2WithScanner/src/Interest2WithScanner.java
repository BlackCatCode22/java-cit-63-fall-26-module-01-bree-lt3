import java.util.Scanner;

public class Interest2WithScanner 
{
  public static void main(String[] args) 
  {
    Scanner stdin = new Scanner(System.in);

    double principal;
    double rate;
    double interest;

    System.out.print("Enter the initial investment: ");
    principal = stdin.nextDouble();

    System.out.print("Enter the annual interest rate (as a decimal): ");
    rate = stdin.nextDouble();

    interest = principal * rate;
    principal = principal + interest;

    System.out.printf("The amount of interest is $%1.2f%n", interest);
    System.out.printf("The value after one year is $%1.2f%n", principal);
  }
}
