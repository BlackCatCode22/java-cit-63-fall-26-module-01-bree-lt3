import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrivingAnimals
{
  public static void main(String[] args) 
  {
    try 
    {
      BufferedReader reader = new BufferedReader(new FileReader("arrivingAnimals.txt"));
      String line;
    
      while ((line = reader.readLine()) != null)
      {
        String[] words = line.split(" ");

        for (String word : words)
        {
          System.out.println(word);
        }
      }

      reader.close();
    }
    catch (IOException e)
    {
      System.out.println(e);
    }
  }
}
