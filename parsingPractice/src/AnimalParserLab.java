// =========================
//
// File Name: AnimalParserLab
// Programmer Name: Breanna
// 
// =========================

public class AnimalParserLab
{
  public static void main(String[] args)
  {
    System.out.println("Hello Practice Lab!");

    String arrivingAnimal = "4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia";

    String[] parts = arrivingAnimal.split(", ");

    for (int i = 0; i < parts.length; i++)
    {
      System.out.println("part[" + i + "] " + parts[i]);

    }

    String[] words = parts[0].split(" ");

    for (int t = 0; t < words.length; t++)
    {
      System.out.println("words[" + t + "] " + words[t]);
    }

  }
}
