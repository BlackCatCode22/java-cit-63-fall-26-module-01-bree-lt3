// ======================================
// File Name: Hyena.java
// Author: Breanna
// Date: 09/17/26
// Course: CIT63
// Instructor: Professor Mohle
// =====================================

package com.agentlabsbreanna.zoo;

import java.time.LocalDate;

public class Hyena extends Animal
{
  private static int numOfHyenas = 0;

  private String laugh;

  public Hyena(
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
    super(
      animalID,
      name,
      age,
      birthDate,
      color,
      sex,
      weight,
      origin,
      arrivalDate);

    this.laugh = "haha";

    numOfHyenas++;
  }

  public static int getNumOfHyenas()
  {
    return numOfHyenas;
  }

  public String getLaugh()
  {
    return laugh;
  }

  public void setLaugh(String laugh)
  {
    this.laugh = laugh;
  }

  @Override
  public String toString()
  {
    return super.toString()
      + "; laugh: " + laugh;
  }
}
