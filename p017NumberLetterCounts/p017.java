package p017NumberLetterCounts;

public class p017
{
  /**
   * If the numbers 1 to 5 are written out in words: one, two, three, four, 
   * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
   * 
   * If all the numbers from 1 to 1000 (one thousand) inclusive were written out 
   * in words, how many letters would be used?
   * 
   * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and 
   * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 
   * 20 letters. The use of "and" when writing out numbers is in compliance 
   * with British usage.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    // Initialize accumulator
    int letterCount = 0;
    // Iterate from 1 to 1000 inclusive
    for (int i = 1; i <= 999; i++)
    {
      String s = Integer.toString(i);
      // Find the leftmost digit, and any after this position
      int leftmost = Character.getNumericValue(s.charAt(0));
      // If in the 1s place, run if-statements and comparisons to find number
      if (i < 10)
      {
        letterCount += findNumLOneToNine(i);
      }
      else if (i < 20)
      {
        letterCount += findNumLTenToNineteen(i);
      }
      else if (i < 100)
      {
        int rightmost = Character.getNumericValue(s.charAt(1));
        if (rightmost != 0)
        {
          letterCount += findNumLOneToNine(rightmost);
        }
        letterCount += findNumLTwentyToNinetyTens(leftmost);
      }
      else
      {
        int rightmost = Character.getNumericValue(s.charAt(2));
        int middle = Character.getNumericValue(s.charAt(1));
        letterCount += findNumLOneToNine(leftmost);
        letterCount += 10;
        if (middle + rightmost == 0)
        {
          letterCount -= 3;
        }
        if (middle != 0)
        {
          if (middle < 2)
          {
            letterCount += findNumLTenToNineteen(middle * 10 + rightmost);
          }
          else
          {
            letterCount += findNumLTwentyToNinetyTens(middle);
            letterCount += findNumLOneToNine(rightmost);
          }
        }
        else if (rightmost != 0)
        {
          letterCount += findNumLOneToNine(rightmost);
        }
      }
    }
    letterCount += 11;
    System.out.println("The total letter count is: " + letterCount);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static int findNumLOneToNine(int n)
  {
    int lCount = 0;
    if (n == 0)
    {
      lCount = 0;
    }
    else if (n < 3 || n == 6)
    {
      lCount += 3;
    }
    else if (n == 3 || n == 7 || n == 8)
    {
      lCount += 5; 
    }
    else
    {
      lCount += 4;
    }
    return lCount;
  }
  
  public static int findNumLTenToNineteen(int n)
  {  
    int lCount = 0;
    if (n == 10)
    {
      lCount += 3;
    }
    else if (n < 13)
    {
      lCount += 6;
    }
    else if (n == 14 || n == 18 || n == 19 || n == 13)
    {
      lCount += 8;
    }
    else if (n == 15 || n == 16)
    {
      lCount += 7;
    }
    else
    {
      lCount += 9;
    } 
    return lCount;
  }
  
  public static int findNumLTwentyToNinetyTens(int n)
  {
    int lCount = 0;
    if (n == 2 || n == 3 || n == 8 || n == 9)
    {
      lCount += 6;
    }
    else if (n == 5 || n == 6 || n == 4)
    {
      lCount += 5;
    }
    else
    {
      lCount += 7;
    }
    return lCount;    
  }

}