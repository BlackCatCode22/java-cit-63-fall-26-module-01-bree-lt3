import java.util.Scanner;

public class SpeciesWhileLoop
{
  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a species or quit: ");
    String species = scanner.nextLine();

    while (!species.equalsIgnoreCase("quit"))
    {
      System.out.println("You entered: " + species);

      System.out.print("Enter another species or quit: ");
      species = scanner.nextLine();
    }

    System.out.println("Program finished.");
    scanner.close();

    int[] myOneDArray = {1,2,3};
    System.out.println("myOneDArray[1] is " + myOneDArray[1]);

    // create a loop
    for (int i = 0; i <= 2; i++)
    {
      myOneDArray[i] = i*3;
    }
    for (int i = 0; i <= 2; i++)
    {
      System.out.println("myOneDArray[" + i + "] = " + myOneDArray[i]);
    }
  }
}
