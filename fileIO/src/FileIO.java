// ==================
//
// File Name: FileIO.java
// Programmer: Breanna Rayburn
//
// ==================

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO 
{
  public static void main(String[] args)
  {
    System.out.println("\n Welcome to File I/O \n");
    try 
    {
      BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
      writer.write("Writing to a file");
      writer.write("\n on a Tuesday");
      writer.write("\n write anything here");
      writer.close();
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
    }
  }
}
