public class TensorArray 
{
  public static void main(String[] args) 
  {
    System.out.println("Welcome to Tensor Arrays"); 

    int[] scalarArray = new int[8];

    int num1 = 0;
    for (int i = 0; i < 8; i++)
    {
      num1++;
      scalarArray[i] = num1;
    }

    for (int i = 0; i < 8; i++)
    {
      System.out.println("scalarArray[" + i + "] is..." + scalarArray[i]);
    }

    int[][] twoDimArray = new int[8][8];

    int num2 = 0;
    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
      {
        num2++;
        twoDimArray[i][j] = num2;
      }
    }

    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
      {
        System.out.println("twoDimArray[" + i + "][" + j +"] is ..." + twoDimArray[i][j]);
      }
    }

    int[][][] threeDimArray = new int[8][8][8];

    int num3 = 0;
    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
      {
        for (int k = 0; k < 8; k++)
        {
          num3++;
          threeDimArray[i][j][k] = num3;
        }
      }
    }

    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
      {
        for (int k = 0; k < 8; k++)
        {
          System.out.println("threeDimArray[" + i + "][" + j +"][" + k + "] is ..." + threeDimArray[i][j][k]);
        }
      }
    }

    int[][][][] tesnorArray = new int[8][8][8][8];

    int num4 = 0;
    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
      {
        for (int k = 0; k < 8; k++)
        {
          for (int l = 0; l < 8; l++)
          {
            num4++;
            tesnorArray[i][j][k][l] = num4;
          }
        }
      }
    }

    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
      {
        for (int k = 0; k < 8; k++)
        {
          for (int l = 0; l < 8; l++)
          {
            System.out.println("tensorArray[" + i + "][" + j +"][" + k + "][" + l + "] is ..." + tesnorArray[i][j][k][l]);
          }
        }
      }
    }
  }
}
