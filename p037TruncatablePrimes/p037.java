package p037TruncatablePrimes;

public class p037
{
  /**
   * The number 3797 has an interesting property. Being prime itself, it is 
   * possible to continuously remove digits from left to right, and remain 
   * prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right 
   * to left: 3797, 379, 37, and 3.
   * Find the sum of the only eleven primes that are both truncatable from left 
   * to right and right to left.
   * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sum = 0;
    int count = 2;
    int found = 0;
    while (found < 11)
    {
      if (isPrime(count))
      {
        if (isPrimeTruncLtoR(count) && isPrimeTruncRtoL(count))
        {
          found++;
          System.out.println(found + ". " + count);
          sum += count;
          
        }
      }
      count++; 
    }
    System.out.println("Sum: " + sum);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }

  public static boolean isPrime(int number)
  {
    if (number <= 0)
    {
      return false;
    }
    boolean returnVal = true;
    if (number == 1)
    {
      returnVal = false;
    }
    for (int i = 2; i <= Math.sqrt(number); i ++)
    {
      if (number % i == 0)
      {
        returnVal = false;
      }
    }
    return returnVal;
  }
  
  public static boolean isPrimeTruncLtoR(int n)
  {
    if (n < 10)
    {
      return false;
    }
    else
    {
      String s = Integer.toString(n);
      boolean condition = true;
      while (condition && s.length() > 1)
      {
        s = s.substring(1);
        if (!isPrime(Integer.parseInt(s)))
        {
          return false;
        }
      }
      return true;
    }
  }
  
  public static boolean isPrimeTruncRtoL(int n)
  {
    if (n < 10)
    {
      return false;
    }
    else
    {
      String s = Integer.toString(n);
      boolean condition = true;
      while (condition && s.length() > 1)
      {
        s = s.substring(0, s.length() - 1);
        if (!isPrime(Integer.parseInt(s)))
        {
          return false;
        }
      }
      return true;
    }
  }
}
