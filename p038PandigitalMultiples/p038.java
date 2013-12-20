package p038PandigitalMultiples;

import java.util.ArrayList;

public class p038
{
  /**
   * Take the number 192 and multiply it by each of 1, 2, and 3:

      192 x 1 = 192
      192 x 2 = 384
      192 x 3 = 576
  
      By concatenating each product we get the 1 to 9 pandigital, 192384576. We 
      will call 192384576 the concatenated product of 192 and (1,2,3)

      The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, 
      and 5, giving the pandigital, 918273645, which is the concatenated product 
      of 9 and (1,2,3,4,5).
   * What is the largest 1 to 9 pandigital 9-digit number that can be formed as 
   * the concatenated product of an integer with (1,2, ... , n) where n  1?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    long max = -1;
    int fixedN = -1;
    for (int fixedNumber = 1; fixedNumber < 10000; fixedNumber++)
    {
      String number = "";
      for(int product = 1; number.length() < 9; product++)
      {
        number += "" + (fixedNumber * product);
      }
      long l = Long.parseLong(number);
      if (hasOnlyDigits1to9(l) && (l > max))
      {
        max = l;
        fixedN = fixedNumber;
      }
    }
    System.out.println("Maximum: " + max);
    System.out.println("Fixed Number: " + fixedN);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean hasOnlyDigits1to9(long a)
  {
    String aStr = Long.toString(a);
    if (aStr.length() == 9 && !aStr.contains("0"))
    {
      ArrayList<Character> digits = new ArrayList<Character>();
      for (int i = 0; i < aStr.length(); i++)
      {
        if (!digits.contains(aStr.charAt(i)))
        {
          digits.add(aStr.charAt(i));
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
