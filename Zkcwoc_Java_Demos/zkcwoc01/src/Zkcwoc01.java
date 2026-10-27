// ============================================================================
// File Name: Zkcwoc01.java
// Author: Astra - instructor demonstration for Professor Mohle
// Date: October 22, 2026
// Course: CIT-63 Java Programming
// Instructor: Professor Mohle
// Description: Reads arrivingAnimals.txt and displays usable data elements
//              parsed from each animal description.
// ============================================================================

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Demonstrates reading and parsing animal data without custom animal classes.
 */
public class Zkcwoc01
{
    private static final String ARRIVING_FILE = "arrivingAnimals.txt";

    /**
     * Reads the input file and displays each animal's parsed fields.
     */
    public static void main(String[] args)
    {
        System.out.println("Zoo Keeper Challenge - Demo 01: Read and Parse");
        System.out.println();

        try
        {
            ArrayList<String> animalLines = readArrivingAnimals(ARRIVING_FILE);

            for (int i = 0; i < animalLines.size(); i++)
            {
                displayParsedAnimal(animalLines.get(i), i + 1);
            }

            System.out.println("Successfully parsed " + animalLines.size()
                    + " arriving animals.");
        }
        catch (IOException exception)
        {
            System.out.println("Unable to read " + ARRIVING_FILE + ": "
                    + exception.getMessage());
            System.out.println("Place the input file in the working directory:");
            System.out.println(System.getProperty("user.dir"));
        }
        catch (IllegalArgumentException exception)
        {
            System.out.println("Invalid animal data: " + exception.getMessage());
        }
    }

    /**
     * Reads all nonblank lines; try-with-resources closes the reader automatically.
     */
    public static ArrayList<String> readArrivingAnimals(String filePath)
            throws IOException
    {
        ArrayList<String> animalLines = new ArrayList<String>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String currentLine = reader.readLine();

            while (currentLine != null)
            {
                if (!currentLine.trim().isEmpty())
                {
                    animalLines.add(currentLine.trim());
                }

                currentLine = reader.readLine();
            }
        }

        if (animalLines.isEmpty())
        {
            throw new IOException("The file contains no animal records.");
        }

        return animalLines;
    }

    /**
     * Separates one description into typed variables and prints their values.
     */
    public static void displayParsedAnimal(String rawLine, int animalNumber)
    {
        // A limit of 5 preserves the comma inside the complete origin field.
        String[] parts = rawLine.split(",", 5);
        String errorPrefix = "Animal " + animalNumber + ": ";

        if (parts.length != 5)
        {
            throw new IllegalArgumentException(errorPrefix
                    + "expected description, season, color, weight, and origin.");
        }

        for (int i = 0; i < parts.length; i++)
        {
            parts[i] = parts[i].trim();
        }

        String[] descriptionWords = parts[0].split("\\s+");

        if (descriptionWords.length != 5
                || !descriptionWords[1].equalsIgnoreCase("year")
                || !descriptionWords[2].equalsIgnoreCase("old"))
        {
            throw new IllegalArgumentException(errorPrefix
                    + "expected a description such as '4 year old female hyena'.");
        }

        if (!parts[2].endsWith(" color") || !parts[3].endsWith(" pounds")
                || !parts[4].startsWith("from "))
        {
            throw new IllegalArgumentException(errorPrefix
                    + "expected the labels 'color', 'pounds', and 'from'.");
        }

        int age;
        int weightPounds;

        try
        {
            age = Integer.parseInt(descriptionWords[0]);
            String weightText = parts[3].substring(0,
                    parts[3].length() - " pounds".length()).trim();
            weightPounds = Integer.parseInt(weightText);
        }
        catch (NumberFormatException exception)
        {
            throw new IllegalArgumentException(errorPrefix
                    + "age and weight must be whole numbers.");
        }

        String sex = descriptionWords[3].toLowerCase(Locale.ROOT);
        String species = descriptionWords[4].toLowerCase(Locale.ROOT);
        String birthSeason = parseBirthSeason(parts[1]);
        String color = parts[2].substring(0,
                parts[2].length() - " color".length()).trim();
        String origin = parts[4].substring("from ".length()).trim();

        if (age < 0 || weightPounds <= 0 || color.isEmpty() || origin.isEmpty())
        {
            throw new IllegalArgumentException(errorPrefix
                    + "check age, weight, color, and origin for missing or invalid data.");
        }

        if (!sex.equals("female") && !sex.equals("male"))
        {
            throw new IllegalArgumentException(errorPrefix + "unrecognized sex: " + sex);
        }

        if (!species.equals("hyena") && !species.equals("lion")
                && !species.equals("tiger") && !species.equals("bear"))
        {
            throw new IllegalArgumentException(errorPrefix
                    + "unrecognized species: " + species);
        }

        System.out.println("Animal " + animalNumber);
        System.out.println("Original: " + rawLine);
        System.out.println("  Age (int):           " + age);
        System.out.println("  Sex (String):        " + sex);
        System.out.println("  Species (String):    " + species);
        System.out.println("  Birth season:        " + birthSeason);
        System.out.println("  Color (String):      " + color);
        System.out.println("  Weight (int, pounds): " + weightPounds);
        System.out.println("  Origin (String):     " + origin);
        System.out.println();
    }

    /**
     * Extracts a known season or explicitly identifies an unknown birth season.
     */
    public static String parseBirthSeason(String seasonSection)
    {
        String normalizedSection = seasonSection.trim().toLowerCase(Locale.ROOT);

        if (normalizedSection.equals("unknown birth season"))
        {
            return "unknown";
        }

        if (normalizedSection.startsWith("born in "))
        {
            String season = normalizedSection.substring("born in ".length()).trim();

            if (season.equals("spring") || season.equals("summer")
                    || season.equals("fall") || season.equals("autumn")
                    || season.equals("winter"))
            {
                return season;
            }
        }

        throw new IllegalArgumentException("Unrecognized birth season: " + seasonSection);
    }
}
