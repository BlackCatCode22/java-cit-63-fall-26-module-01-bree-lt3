ZOO KEEPER CHALLENGE WITHOUT CUSTOM ANIMAL CLASSES
Four Java Demonstrations for CIT-63
Instructor: Professor Mohle
Prepared by Astra on October 22, 2026

START HERE

Each demonstration is a complete, independent Java program. Create one
IntelliJ Java project at a time. No earlier demonstration must be compiled
or run first. Each file contains its own helper methods and one public class.
No package declaration, external library, Maven, or Gradle is required.

The course target is JDK 25. These programs use standard Java language and
library features available in Java 17 and later. They were compiled and run
on OpenJDK 17.0.20 during preparation; direct JDK 25 testing was not performed.

PROGRAMS AND INPUT FILES

Program          Purpose                         Required input files
Zkcwoc01.java    Read and parse animal arrivals   arrivingAnimals.txt
Zkcwoc02.java    Load four species name lists    animalNames.txt
Zkcwoc03.java    Assign names, IDs, and dates     Both input files
Zkcwoc04.java    Write the habitat report        Both input files

The ZIP contains four folders named zkcwoc01 through zkcwoc04. Each folder
has its Java source in src and the required input file(s) beside src.
These are plain source folders, not preconfigured IntelliJ projects.

INTELLIJ SETUP FOR ONE DEMONSTRATION

1. Create a new Java project, such as zkcwoc01, and select your course JDK 25.
2. In the project's src folder, create the matching Java class, such as
   Zkcwoc01. Do not add a package declaration.
3. Open the downloaded .java file and paste its entire contents into that
   class, replacing any generated starter code. Alternatively, copy the
   downloaded .java file directly into the project's src folder.
4. Copy the required input file(s) into the project root, beside src.
   Use exactly arrivingAnimals.txt and animalNames.txt as appropriate.
   Do not keep download suffixes such as (2) or (3) in these filenames.
5. Set the run configuration's working directory to the project root.
6. Run the matching class's main method.
7. Repeat in a new project for the next demonstration.

The public class and filename must match exactly: Zkcwoc01.java contains
public class Zkcwoc01, and the same rule applies to 02, 03, and 04.

If a file cannot be found, the program displays the working directory.
Place the input files in that directory or change the run configuration.

WHAT EACH DEMONSTRATION TEACHES

Zkcwoc01
Reads nonblank lines using BufferedReader and FileReader, stores them in an
ArrayList<String>, then displays the original text and seven parsed values:
age, sex, species, birth season, color, weight in pounds, and origin.
Age and weight are int values. The comma inside an origin is preserved.
The input contains 16 animals, with four animals per species.

Zkcwoc02
Loads the names by species heading into four ArrayList<String> values held
in a HashMap<String, ArrayList<String>>. Blank lines are ignored. Names are
split at commas, so spaces inside names such as Winnie the Pooh are kept.
It prints the four lists and their counts:
  Hyena: 11 names
  Lion:  12 names
  Tiger: 10 names
  Bear:  10 names
The names file places bears before tigers. Heading-based parsing keeps
those lists associated with the correct species.

Zkcwoc03
Combines both input files and displays 16 completed animal records.
The first four assigned names are:
  Hyena: Shenzi, Banzai, Ed, Zig
  Lion:  Scar, Mufasa, Simba, Kiara
  Tiger: Tony, Tigger, Amber, Cosimia
  Bear:  Yogi, Smokey, Paddington, Lippy
Each assigned entry is removed from its available list. Species IDs are
Hy01-Hy04, Li01-Li04, Ti01-Ti04, and Be01-Be04. Counters and available names
restart with each program run; these are not permanent database IDs.
Required helper names genUniqueID() and genBirthDay() are retained.

Zkcwoc04
Completes all records, groups them into habitat lists, and writes the
report in Hyena, Lion, Tiger, Bear order. It also displays the same report
in the console. The report is saved as zooPopulation.txt in the working
directory. Running this program again replaces that output file.

DATE AND REPORT CONVENTIONS

Programs 03 and 04 use a fixed reference and arrival date of 2026-10-22,
so classroom results are reproducible. Change REFERENCE_DATE near the top
of either class if a different demonstration date is wanted. To use the
computer's current local date instead, initialize that constant with
LocalDate.now(). Keep both programs consistent when comparing outputs.

Birth dates are estimates assigned using the lab's convention:
  birth year = reference year minus the age supplied in the arrival file
  spring  -> March 21
  summer  -> June 21
  fall or autumn -> September 21
  winter  -> December 21
  unknown -> January 1

These month/day values are classroom placeholders, not verified birthdays
or astronomical season boundaries. Preserve the source age; do not
recalculate it from an assigned birthday. The simple year-subtraction rule
can differ from an exact completed-years age when the assigned birthday
falls later than the reference date. The input does not establish an exact
birth date.

The report retains the lab's birthDate field label and includes an estimate
notice in its header. The program removes the input's leading word from
before adding the output label, so origins display as from: Friguia Park,
Tunisia, without a doubled from.

REFERENCE OUTPUTS

reference/expectedZooPopulation.txt is the generated output from program04
using the supplied inputs and the 2026-10-22 reference date.

reference/originalZooPopulation_2024.txt preserves the uploaded sample
report unchanged. It is a format reference, not an input file. It uses a
2024-04-07 arrival date, skips the first three names in each list, changes
five input ages, and contains doubled from labels. The new demonstrations
follow the lab's sequential name assignment and preserve input ages.

CIT-63 STYLE

The sources use Allman braces, explicit types, the traditional full main
signature near the top, helper methods below main, relative filenames,
standard library file I/O, and the course header. There are no separate
Animal, Hyena, Lion, Tiger, or Bear classes yet.

VALIDATION

All four sources compiled with javac 17.0.20 and -Xlint:all, with no errors
or warnings, and ran successfully against the supplied input files.
Checks covered all parsed fields, list counts, compound names, original
ages, assigned names, IDs, seasonal estimates, arrival dates, and habitat
order. Program04's written report matched its console report block.
A missing-input check produced a useful error and no output report.
