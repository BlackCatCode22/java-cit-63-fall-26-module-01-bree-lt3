// ============================================================================
// File Name: Zkcwoc02.java
// Author: Astra - instructor demonstration for Professor Mohle
// Date: October 22, 2026
// Course: CIT-63 Java Programming
// Instructor: Professor Mohle
// Description: Reads animalNames.txt into four lists organized by species.
// ============================================================================

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Demonstrates four name lists indexed by species in a HashMap.
 */
public class Zkcwoc02
{
    private static final String NAMES_FILE = "animalNames.txt";

    /**
     * Loads and displays the four species name lists.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args)
    {
        System.out.println("Zoo Keeper Challenge - Demonstration 02");
        System.out.println("Load animal names into four ArrayList values.");

        try
        {
            HashMap<String, ArrayList<String>> animalNames =
                    loadAnimalNames(NAMES_FILE);

            System.out.println();
            System.out.println("Each HashMap key identifies one species.");
            System.out.println("Its value is an ArrayList of that species' names.");
            System.out.println("Example: the key hyena retrieves the hyena list.");

            // Choose the display order explicitly; HashMap has no fixed order.
            displayNames("hyena", animalNames.get("hyena"));
            displayNames("lion", animalNames.get("lion"));
            displayNames("tiger", animalNames.get("tiger"));
            displayNames("bear", animalNames.get("bear"));
        }
        catch (IOException exception)
        {
            System.err.println("Could not load animal names: " +
                    exception.getMessage());
            System.err.println("Working directory: " +
                    System.getProperty("user.dir"));
            System.err.println("Check that animalNames.txt is in this directory.");
        }
    }

    /**
     * Reads species headings and adds comma-separated names to four lists.
     *
     * @param filePath path to the animal names input file
     * @return a map with hyena, lion, tiger, and bear name lists
     * @throws IOException if reading fails or the file format is invalid
     */
    public static HashMap<String, ArrayList<String>> loadAnimalNames(
            String filePath) throws IOException
    {
        HashMap<String, ArrayList<String>> animalNames =
                new HashMap<String, ArrayList<String>>();

        animalNames.put("hyena", new ArrayList<String>());
        animalNames.put("lion", new ArrayList<String>());
        animalNames.put("tiger", new ArrayList<String>());
        animalNames.put("bear", new ArrayList<String>());

        String currentSpecies = "";
        int lineNumber = 0;

        // The reader closes automatically, including when an exception occurs.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;

            while ((line = reader.readLine()) != null)
            {
                lineNumber++;
                line = line.trim();

                switch (line) {
                  case "":
                      continue;
                  case "Hyena Names:":
                      currentSpecies = "hyena";
                      break;
                  case "Lion Names:":
                      currentSpecies = "lion";
                      break;
                  case "Tiger Names:":
                      currentSpecies = "tiger";
                      break;
                  case "Bear Names:":
                      currentSpecies = "bear";
                      break;
                  default:
                      // Catch an unknown heading or a heading missing its colon.
                      if (line.contains(":") || line.endsWith("Names"))
                      {
                          throw new IOException("Line " + lineNumber +
                                  ": unknown or malformed species heading.");
                      }

                      if (currentSpecies.isEmpty())
                      {
                          throw new IOException("Line " + lineNumber +
                                  ": a names line appears before a species heading.");
                      }

                      // -1 retains empty tokens, including one after a final comma.
                      String[] names = line.split(",", -1);
                      ArrayList<String> speciesNames = animalNames.get(currentSpecies);

                      for (String name : names)
                      {
                          name = name.trim();

                          if (name.isEmpty())
                          {
                              throw new IOException("Line " + lineNumber +
                                      ": an animal name is empty.");
                          }

                          // Keep spaces inside names such as Winnie the Pooh.
                          // Add to the existing list if a section spans more lines.
                          speciesNames.add(name);
                      }
                      break;
                }
            }
        }

        String[] requiredSpecies =
        {
            "hyena", "lion", "tiger", "bear"
        };

        for (String species : requiredSpecies)
        {
            if (animalNames.get(species).isEmpty())
            {
                throw new IOException("No names were found for species: " + species);
            }
        }

        return animalNames;
    }

    /**
     * Displays one map key, its list size, and the list contents.
     *
     * @param species the map key used to find this list
     * @param names the names belonging to that species
     */
    private static void displayNames(String species, ArrayList<String> names)
    {
        System.out.println();
        System.out.println("Key: " + species + " | Number of names: " + names.size());
        System.out.println("Names: " + names);
    }
}
