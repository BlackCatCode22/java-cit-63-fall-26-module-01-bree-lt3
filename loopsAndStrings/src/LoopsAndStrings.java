// ===============================
// File Name: LoopsAndStrings.java
// Programmer: Breanna Rayburn
// ===============================

public class LoopsAndStrings 
{
  public static void main() 
  {
    System.out.println("Welcome to my Loop Program");

    // Create a for loop that prints hello a hundred times

    for (int i = 1; i <= 100; i++) 
    {
      System.out.println("Loop number " + i);
    }

    // A while loop
    // create a loop control variable, and initialize check and change

    int myLoopCtrlVar = 10;

    while (myLoopCtrlVar == 10)
    {
      System.out.println("While loop working " + myLoopCtrlVar);
      myLoopCtrlVar++;
    }

    int[] scores = {88, 92, 79, 95, 84};

    for (int score : scores)
    {
      System.out.println(score);
    }
  }
}

