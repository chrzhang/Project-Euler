package p015LatticePaths;

import java.math.BigInteger;

public class p015
{
  /**
   * Starting in the top left corner of a 2x2 grid, and only being able to move 
   * to the right and down, there are exactly 6 routes to the bottom right 
   * corner.W
   * How many such routes are there through a 20x20 grid?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    // The algorithm for this shortest path calculation is (2n)!/(n!)^2
    int SIDE_LENGTH = 20;
    BigInteger numerator = new BigInteger("1");
    BigInteger denominator = new BigInteger("1");
    
    // Find the numerator
    for (int i = 2 * SIDE_LENGTH; i != 1; i--)
    {
      numerator = numerator.multiply(BigInteger.valueOf(i));
    }
    
    // Find the denominator
    for (int i = SIDE_LENGTH; i !=1; i--)
      {
        denominator = denominator.multiply(BigInteger.valueOf(i));
      }
    denominator = denominator.multiply(denominator);
    
    System.out.println(numerator.divide(denominator) + " possible paths");
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}
