import java.util.ArrayList;
import java.util.Scanner;

public class ArrayVsArrayList
{
  public static void main(String[] args)
  {
    ArrayList<String> userList = getUserArrayList();
    System.out.println("Your list is: " + userList);

    System.out.println("Here is each element");
    for (int i = 0; i < userList.size(); i++)
    {
      System.out.println(userList.get(i));
    }
  }

  public static ArrayList<String> getUserArrayList()
  {
    ArrayList<String> userArrayList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    
    for (int i = 0; i < 5; i++)
    {
      System.out.print("Enter a word: ");
      String userInput = scanner.nextLine();
      if(userInput.equalsIgnoreCase("exit"))
      {
        break;
      }
      else 
      {
        userArrayList.add(userInput);
      }
    }

    return userArrayList;
  }
}
