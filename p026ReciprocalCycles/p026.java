package p026ReciprocalCycles;

import java.util.HashMap;
import java.util.Map;

public class p026
{
  /**
   * A unit fraction contains 1 in the numerator. The decimal representation of 
   * the unit fractions with denominators 2 to 10 are given:

      1/2 =   0.5
      1/3 =   0.(3)
      1/4 =   0.25
      1/5 =   0.2
      1/6 =   0.1(6)
      1/7 =   0.(142857)
      1/8 =   0.125
      1/9 =   0.(1)
      1/10  =   0.1

      Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can 
      be seen that 1/7 has a 6-digit recurring cycle.

   * Find the value of d < 1000 for which 1/d contains the longest recurring 
   * cycle in its decimal fraction part.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int longest = 0;
    for (int i = 0; i < 1000; i++)
    {
      if (willRepeat(i))
      {
        int temp = findLengthRepeatingCycle(i);
        if (temp > longest)
        {
          longest = i;
        }
      }
    }
    System.out.println(longest);
    System.out.printf("Running Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean willRepeat(int denominator)
  {
    int i = 2;
    int d = denominator;
    while (d > 1)
    {
      if (d % i == 0)
      {
        if (i != 2 && i != 5)
        {
          return true;
        }
        d = d / i;
      }
      else
      {
        i++;
      }
    }
    return false;
  }
  
  public static int findLengthRepeatingCycle(int denominator)
  {
    Map<Integer,Integer> digitToPlace = new HashMap<Integer,Integer>();
    int digit = 1;
    int place = 0;
    while (!digitToPlace.containsKey(digit)) 
    {
      digitToPlace.put(digit, place);
      digit = digit * 10 % denominator;
      place++;
    }
    return place - digitToPlace.get(digit);
  }

}
