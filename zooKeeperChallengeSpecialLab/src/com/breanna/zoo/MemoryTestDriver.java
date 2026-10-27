package com.breanna.zoo;

public class MemoryTestDriver 
{
  public static void main(String[] args)
  {
    PersonalObject objA = new PersonalObject("Breanna");
    System.out.println(objA.getFirstName());

    PersonalObject objB = new PersonalObject("Breanna");
    PersonalObject objC = objA;

    assert objA != objB: "Distinct instance exposed";
    assert objA == objC: "Shared reference expected";
    assert objA.getFirstName().equals(objB.getFirstName()): "Equal names expected";

    System.out.println("PASS: identity and value checks");
  }
}
