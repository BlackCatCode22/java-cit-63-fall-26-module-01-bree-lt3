// ======================================
// File Name: Animal.java
// Author: Breanna
// Date: 09/17/26
// Course: CIT63
// Instructor: Professor Mohle
// =====================================

package com.agentlabsbreanna.zoo;

import java.time.LocalDate;

public class Animal
{
  private static int numOfAnimals = 0;

  private String animalID;
  private String name;
  private int age;
  private LocalDate birthDate;
  private String color;
  private String sex;
  private int weight;
  private String origin;
  private LocalDate arrivalDate;

  public Animal(
    String animalID,
    String name,
    int age,
    LocalDate birthDate,
    String color,
    String sex,
    int weight,
    String origin,
    LocalDate arrivalDate)
  {
    this.animalID = animalID;
    this.name = name;
    this.age = age;
    this.birthDate = birthDate;
    this.color = color;
    this.sex = sex;
    this.weight = weight;
    this.origin = origin;
    this.arrivalDate = arrivalDate;

    numOfAnimals++;
  }

  public static int getNumOfAnimals()
  {
    return numOfAnimals;
  }

  public String getAnimalID()
  {
    return animalID;
  }

  public void setAnimalID(String animalID)
  {
    this.animalID = animalID;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public LocalDate getBirthDate()
  {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate)
  {
    this.birthDate = birthDate;
  }

  public String getColor()
  {
    return color;
  }

  public void setColor(String color)
  {
    this.color = color;
  }

  public String getSex()
  {
    return sex;
  }

  public void setSex(String sex)
  {
    this.sex = sex;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
  }

  public String getOrigin()
  {
    return origin;
  }

  public void setOrigin(String origin)
  {
    this.origin = origin;
  }

  public LocalDate getArrivalDate()
  {
    return arrivalDate;
  }

  public void setArrivalDate(LocalDate arrivalDate)
  {
    this.arrivalDate = arrivalDate;
  }

  @Override
  public String toString()
  {
    return animalID
      + "; " + age + " years old"
      + "; " + name
      + "; birthDate: " + birthDate
      + "; " + color + " color"
      + "; " + sex
      + "; " + weight + " pounds"
      + "; from: " + origin
      + "; arrived: " + arrivalDate;
  }
}
