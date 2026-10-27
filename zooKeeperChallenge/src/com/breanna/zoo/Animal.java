package com.breanna.zoo;

public class Animal
{
  // Constructor 
  public Animal(int ID, String name, int age, String birthDate, String arrivalDate, String sex, int weight, String color, String origin)
  {
    this.ID = ID;
    this.name = name;
    this.age = age;
    this.birthDate = birthDate;
    this.arrivalDate = arrivalDate;
    this.sex = sex;
    this.weight = weight;
    this.color = color;
    this.origin = origin;
  }

  private int ID;
  private String name;
  private int age;
  private String birthDate;
  private String arrivalDate;
  private String sex;
  private int weight;
  private String color;
  private String origin;

  public int getID() 
  {
    return ID;
  }

  public String getName()
  {
    return name;
  }

  public int getAge()
  {
    return age;
  }

  public String getBirthDate()
  {
    return birthDate;
  }

  public String getArrivalDate()
  {
    return arrivalDate;
  }

  public String getSex()
  {
    return sex;
  }

  public int getWeight()
  {
    return weight;
  }

  public String getColor()
  {
    return color;
  }
  
  public String getOrigin()
  {
    return origin;
  }
}
