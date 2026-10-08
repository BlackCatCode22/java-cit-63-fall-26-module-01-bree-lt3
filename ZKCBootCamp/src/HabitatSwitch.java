import java.util.Scanner;

public class HabitatSwitch
{
  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter habitat number (1-4): ");

    // see what nextInt does

    int myInt = scanner.nextInt();

    System.out.println("myInt is " + myInt);

    //int habitatNumber = Integer.parseInt(scanner.nextLine());

    switch (myInt)
    {
      case 1:
        System.out.println("Hyena Habitat");
        break;
      case 2:
        System.out.println("Lion Habitat");
        break;
      case 3:
        System.out.println("Tiger Habitat");
        break;
      case 4:
        System.out.println("Bear Habitat");
        break;
      default:
        System.out.println("Unknown Habitat");
        break;
    }

    scanner.close();
  }
}
