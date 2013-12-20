package p032PandigitalProducts;

import java.util.ArrayList;

public class p032
{
  /**
   * We shall say that an n-digit number is pandigital if it makes use of all 
   * the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 
   * 1 through 5 pandigital.
   * 
   * The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing 
   * multiplicand, multiplier, and product is 1 through 9 pandigital.
   * 
   * Find the sum of all products whose multiplicand/multiplier/product identity 
   * can be written as a 1 through 9 pandigital.
   * HINT: Some products can be obtained in more than one way so be sure to only 
   * include it once in your sum.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sum = 0;
    int count = 1;
    while (count < 9999)
    {
      count++;
      if (isPandigital(count))
      {
        sum += count;
      }
    }
    System.out.println(sum);
    System.out.printf("Running Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean isPandigital(int n)
  {
    for (int i = 1; i <= ((int) Math.sqrt(n)); i++)
    {
      if (n % i == 0)
      {
        int m1 = i;
        int m2 = n / i;
        if ((hasOnlyDigits1to9(m1, m2, n)))
        {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean hasOnlyDigits1to9(int a, int b, int c)
  {
    String abcStr = Integer.toString(a) + Integer.toString(b) + 
        Integer.toString(c);
    if (abcStr.length() == 9 && !abcStr.contains("0"))
    {
      ArrayList<Character> digits = new ArrayList<Character>();
      for (int i = 0; i < abcStr.length(); i++)
      {
        if (!digits.contains(abcStr.charAt(i)))
        {
          digits.add(abcStr.charAt(i));
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
