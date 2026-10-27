package com.breanna.zoo;

public class App 
{
  // Input File Paths
  private static final String ARRIVING_FILE = "arrivingAnimals.txt";
  private static final String NAMES_FILE = "animalNames.txt";

  // Output File Paths
  private static final String POPULATION_FILE = "zooPopulation.txt";

  public static void main(String[] args) 
  {
    System.out.println("Welcome to my Zookeeper's Challenge!");

    Hyena hyena = new Hyena(1, "name", 10, "10/10/10", "5/5/5", "f", 100, "red", "somewhere");

    System.out.println(hyena.getID());
  }
}
