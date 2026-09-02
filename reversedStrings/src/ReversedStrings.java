import java.util.Scanner;

public class ReversedStrings 
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);    
    
    System.out.print("Enter your favorite word: ");
    String userInput = scanner.nextLine();
   
    String reverseInput = "";

    // run for each character in userInput
    for (int i = 0; i < userInput.length(); i++)
    {
      // assign reverseInput the userInput characters at our i counter + reverseInput preappending
      reverseInput = userInput.charAt(i) + reverseInput;
    }

    System.out.println(reverseInput);
  }
}
