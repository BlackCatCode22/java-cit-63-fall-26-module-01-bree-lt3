package com.breanna.zoo;

public class ZooKeeperApp
{
  public static void main(String[] args) 
  {
    System.out.println("ZooKeeperApp Init");

    Animal myNewAnimal = new Animal("Hy05", "hyena", 10, 58.5, "f");
    System.out.println(myNewAnimal.getAge());
  }
}
