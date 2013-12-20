package p023NonAbundantSums;

public class p023
{
  /**
   * A perfect number is a number for which the sum of its proper divisors is 
   * exactly equal to the number. For example, the sum of the proper divisors 
   * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect 
   * number.
   * 
   * A number n is called deficient if the sum of its proper divisors is less 
   * than n and it is called abundant if this sum exceeds n.
   * 
   * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest 
   * number that can be written as the sum of two abundant numbers is 24. 
   * 
   * By mathematical analysis, it can be shown that all integers greater than 
   * 28123 can be written as the sum of two abundant numbers. However, this 
   * upper limit cannot be reduced any further by analysis even though it is 
   * known that the greatest number that cannot be expressed as the sum of two 
   * abundant numbers is less than this limit.
   * 
   * Find the sum of all the positive integers which cannot be written as the 
   * sum of two abundant numbers.
   * @author Christopher Zhang
   * @param args
   */
  private static boolean[] abundants = new boolean[28124];
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sum = 0;
    
    for (int i = 1; i < abundants.length; i++)
    {
      abundants[i] = isAbundant(i);
    }
        
    for (int i = 1; i < 28123; i++) {
      if (!isSumOfTwoAbundants(i))
      {
        sum += i;
      }
    }
    System.out.println(sum);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean isAbundant(int n)
  {
    int sum = 1;
    int b = (int) Math.sqrt(n);
    for (int i = 2; i <= b; i++)
    {
      if (n % i == 0)
      {
        sum += i + n / i;
      }
    }
    if (b * b == n)
    {
      sum -= b;
    }
    return sum > n;
  }
  
  public static boolean isSumOfTwoAbundants(int n)
  {
    for (int i = 1; i <= n; i++)
    {
      if (abundants[i] && abundants[n - i])
      {
        return true;
      }
    }
    return false;
  }
}
