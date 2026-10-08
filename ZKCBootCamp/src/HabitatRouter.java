import java.util.Scanner;

public class HabitatRouter 
{
  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter species: ");
    String species = scanner.nextLine();

    if (species.equalsIgnoreCase("hyena"))
    {
      System.out.println("Route to Heyna Habitat");
    }
    else if (species.equalsIgnoreCase("tiger"))
    {
      System.out.println("Route to Tiger Habitat");
    }
    else
    {
      System.out.println("Route to temporary holding");
    }

    scanner.close();
  }
}
