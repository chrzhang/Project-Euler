package p010SumationOfPrimes;

public class p010
{
  /**
   * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17
   * Find the sum of all the primes below two million.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    long upper = 2000000;
    boolean[] primes = new boolean[(int) upper];
    long sum = 0;
    for (int i = 1; i < upper; i++)
    {
      if (primes[i] == false)
      {
        if (i == 1)
        {
          primes[i] = true;
        }
        else if (isPrime(i))
        {
          for (int k = 2; k*i < upper; k++)
          {
            primes[k*i] = true;
          }
        }
      }
    }
    for (int i = 0; i < upper; i++)
    {
      if (primes[i]==false)
      {
        sum += i;
      }
    }
    System.out.println(sum);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean isPrime(int number)
  {
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
}