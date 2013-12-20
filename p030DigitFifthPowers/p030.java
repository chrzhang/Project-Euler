package p030DigitFifthPowers;

public class p030
{
  /**
   * Surprisingly there are only three numbers that can be written as the sum 
   * of fourth powers of their digits:
      
      1634 = 14 + 64 + 34 + 44
      8208 = 84 + 24 + 04 + 84
      9474 = 94 + 44 + 74 + 44
      As 1 = 14 is not a sum it is not included.
      
      The sum of these numbers is 1634 + 8208 + 9474 = 19316.

   * Find the sum of all the numbers that can be written as the sum of fifth 
   * powers of their digits.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int grandSum = 0;
    int originalN = 10;
    for (int i = 0; i <= 354394; i++)
    {
      int sum = 0;
      // for each number
      int number = originalN;
      while (number > 0)
      {
        sum += Math.pow(number % 10, 5);
        number = number / 10;
      }
      if (sum == originalN)
      {
        grandSum += sum;
      }
      originalN++;
    }
    System.out.println("Total: " + grandSum);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}
