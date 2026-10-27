// ============================================================================
// File Name: Zkcwoc04.java
// Author: Astra - instructor demonstration for Professor Mohle
// Date: October 22, 2026
// Course: CIT-63 Java Programming
// Instructor: Professor Mohle
// Description: Groups animal records by habitat and writes zooPopulation.txt.
// ============================================================================

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Demonstrates the complete procedural Zoo Keeper Challenge.
 */
public class Zkcwoc04
{
    private static final String ARRIVING_FILE = "arrivingAnimals.txt";
    private static final String NAMES_FILE = "animalNames.txt";
    private static final String OUTPUT_FILE = "zooPopulation.txt";
    private static final String[] SPECIES_ORDER =
    {
        "hyena", "lion", "tiger", "bear"
    };
    private static final String[] HABITAT_TITLES =
    {
        "Hyena Habitat:", "Lion Habitat:", "Tiger Habitat:", "Bear Habitat:"
    };

    // A fixed classroom date makes the example output reproducible.
    private static final LocalDate REFERENCE_DATE = LocalDate.of(2026, 10, 22);

    /**
     * Completes all animal records before opening and writing the output file.
     */
    public static void main(String[] args)
    {
        System.out.println("Zoo Keeper Challenge - Demo 04: Habitat Report");
        System.out.println();

        try
        {
            ArrayList<String> animalLines = readArrivingAnimals(ARRIVING_FILE);
            HashMap<String, ArrayList<String>> namesMap = loadAnimalNames(NAMES_FILE);
            HashMap<String, Integer> speciesCounts = new HashMap<String, Integer>();
            HashMap<String, ArrayList<String>> habitatMap =
                    new HashMap<String, ArrayList<String>>();

            for (String species : SPECIES_ORDER)
            {
                habitatMap.put(species, new ArrayList<String>());
            }

            for (int i = 0; i < animalLines.size(); i++)
            {
                addAnimalToHabitat(animalLines.get(i), i + 1,
                        namesMap, speciesCounts, habitatMap);
            }

            // All input processing succeeds before the output file is opened.
            writeZooReport(OUTPUT_FILE, habitatMap);
            System.out.println("Report successfully written to " + OUTPUT_FILE);
            System.out.println("Animals in report: " + animalLines.size());
        }
        catch (IOException exception)
        {
            System.err.println("File error: " + exception.getMessage());
            System.err.println("Working directory: " + System.getProperty("user.dir"));
            System.err.println("Check both input files and the output folder permissions.");
        }
        catch (IllegalArgumentException exception)
        {
            System.err.println("Invalid animal data: " + exception.getMessage());
            System.err.println("The report was not written.");
        }
    }

    /**
     * Completes one arrival and adds its record to the matching habitat list.
     */
    public static void addAnimalToHabitat(String rawLine, int animalNumber,
            HashMap<String, ArrayList<String>> namesMap,
            HashMap<String, Integer> speciesCounts,
            HashMap<String, ArrayList<String>> habitatMap)
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


        ArrayList<String> availableNames = namesMap.get(species);

        if (availableNames == null || availableNames.isEmpty())
        {
            throw new IllegalArgumentException(errorPrefix
                    + "no unused names remain for " + species + ".");
        }

        // Removing the assigned name prevents reuse during this run.
        String animalName = availableNames.remove(0);
        String uniqueID = genUniqueID(species, speciesCounts);
        String birthDate = genBirthDay(age, birthSeason);
        String arrivalDate = REFERENCE_DATE.toString();
        String soundLabel = getSpeciesSound(species);

        String record = uniqueID + "; "
                + age + " years old; "
                + animalName + "; "
                + "birthDate: " + birthDate + "; "
                + color + " color; "
                + sex + "; "
                + weightPounds + " pounds; "
                + soundLabel + "; "
                + "from: " + origin + "; "
                + "arrived: " + arrivalDate;

        habitatMap.get(species).add(record);
    }

    /**
     * Reads each nonblank arrival line and closes the reader automatically.
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
     * Loads names by species heading, preserving spaces within each name.
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

                if (line.isEmpty())
                {
                    continue;
                }

                // Match headings, so the file's species order does not matter.
                if (line.equals("Hyena Names:"))
                {
                    currentSpecies = "hyena";
                }
                else if (line.equals("Lion Names:"))
                {
                    currentSpecies = "lion";
                }
                else if (line.equals("Tiger Names:"))
                {
                    currentSpecies = "tiger";
                }
                else if (line.equals("Bear Names:"))
                {
                    currentSpecies = "bear";
                }
                else
                {
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

    /**
     * Creates the next species ID; counters restart when the program restarts.
     */
    public static String genUniqueID(String species,
            HashMap<String, Integer> speciesCounts)
    {
        String prefix;

        if (species.equals("hyena"))
        {
            prefix = "Hy";
        }
        else if (species.equals("lion"))
        {
            prefix = "Li";
        }
        else if (species.equals("tiger"))
        {
            prefix = "Ti";
        }
        else if (species.equals("bear"))
        {
            prefix = "Be";
        }
        else
        {
            throw new IllegalArgumentException("Unknown species: " + species);
        }

        int currentCount = speciesCounts.getOrDefault(species, 0) + 1;
        speciesCounts.put(species, currentCount);

        if (currentCount < 10)
        {
            return prefix + "0" + currentCount;
        }

        return prefix + currentCount;
    }

    /**
     * Assigns a lab birthday estimate using the reference year and parsed season.
     * These dates are conventions, not known birthdays or astronomical dates.
     */
    public static String genBirthDay(int animalAge, String birthSeason)
    {
        int birthYear = REFERENCE_DATE.getYear() - animalAge;
        String monthAndDay = "-01-01";

        if (birthSeason.equals("spring"))
        {
            monthAndDay = "-03-21";
        }
        else if (birthSeason.equals("summer"))
        {
            monthAndDay = "-06-21";
        }
        else if (birthSeason.equals("fall") || birthSeason.equals("autumn"))
        {
            monthAndDay = "-09-21";
        }
        else if (birthSeason.equals("winter"))
        {
            monthAndDay = "-12-21";
        }
        else if (!birthSeason.equals("unknown"))
        {
            throw new IllegalArgumentException("Unknown birth season: " + birthSeason);
        }

        // Preserve the supplied age: an assigned birthday is only an estimate.
        return birthYear + monthAndDay;
    }

    /**
     * Supplies the fixed species sounds used in the lab's complete program.
     */
    public static String getSpeciesSound(String species)
    {
        if (species.equals("hyena"))
        {
            return "laugh: haha";
        }
        else if (species.equals("lion"))
        {
            return "roar: Roarrr";
        }
        else if (species.equals("tiger"))
        {
            return "roar: Mew";
        }
        else if (species.equals("bear"))
        {
            return "roar: Grrrrr";
        }

        throw new IllegalArgumentException("Unknown species: " + species);
    }

    /**
     * Writes the same report lines to the file and console in habitat order.
     */
    public static void writeZooReport(String outputFilePath,
            HashMap<String, ArrayList<String>> habitatMap) throws IOException
    {
        ArrayList<String> reportLines = new ArrayList<String>();
        reportLines.add("******* Zoo Population and Habitat Assignment Report ********");
        reportLines.add("Reference and arrival date: " + REFERENCE_DATE);
        reportLines.add("Birth dates are assigned estimates; input ages are preserved.");
        reportLines.add("");

        // A HashMap stores the groups; this array controls their printed order.
        for (int i = 0; i < SPECIES_ORDER.length; i++)
        {
            reportLines.add(HABITAT_TITLES[i]);
            reportLines.add("");

            for (String record : habitatMap.get(SPECIES_ORDER[i]))
            {
                reportLines.add(record);
            }

            reportLines.add("");
        }

        // FileWriter replaces an existing report in this working directory.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath)))
        {
            for (String line : reportLines)
            {
                writer.write(line);
                writer.newLine();
            }
        }

        // Only display the completed report after writing succeeds.
        for (String line : reportLines)
        {
            System.out.println(line);
        }
    }
}
