package com.breanna.zoo;

public class Animal
{
  private final String animalID;
  private final String species;
  private int age;
  private double weight;
  private final String sex;

  public Animal(String animalID, String species, int age, double weight, String sex)
  {
    this.animalID = animalID;
    this.species = species;
    this.sex = sex;
    setAge(age);
    setWeight(weight);
  }

  public String getAnimalID() { return animalID; }
  public String getSpecies() { return species; }
  public int getAge() { return age; }
  public double getWeight() { return weight; }
  public String getSex() { return sex; }
  public void setAge(int age) 
  {
    if(age < 0) throw new IllegalArgumentException("Negative age");
    this.age = age;
  }
  public void setWeight(double weight)
  {
    if(!Double.isFinite(weight) || weight <= 0)
      throw new IllegalArgumentException("Invalid weight");
    this.weight = weight;
  }
  public String makeSound() { return "unknown"; }
  public void displayInfo()
  {
    System.out.println("%s | %s | %d years | %1 f lb | %s%n, animalID, species, age, weight, sex");
  }
}
