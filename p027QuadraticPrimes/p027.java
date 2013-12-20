package p027QuadraticPrimes;

import java.util.ArrayList;

public class p027
{
  /**
   * Euler discovered the remarkable quadratic formula:
      
      n² + n + 41

      It turns out that the formula will produce 40 primes for the consecutive 
      values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 
      is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly 
      divisible by 41.

    The incredible formula  n² - 79n + 1601 was discovered, which produces 80 
    primes for the consecutive values n = 0 to 79. The product of the 
    coefficients, 79 and 1601, is 126479.

    Considering quadratics of the form:
    
    n² + an + b, where |a| < 1000 and |b| < 1000
    
    where |n| is the modulus/absolute value of n
    e.g. |11| = 11 and |4| = 4
    
    Find the product of the coefficients, a and b, for the quadratic expression 
    that produces the maximum number of primes for consecutive values of n, 
    starting with n = 0.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int tempMaxNOfPrimes = 0;
    int magicA = 0;
    int magicB = 0;
    ArrayList<Integer> primesBetween2and1000 = new ArrayList<Integer>();
    for (int b = 2; b < 1000; b++)
    {
      if (isPrime(b))
      {
        primesBetween2and1000.add(b);
      }
    }
    for (int a = -999; a < 1000; a++)
    {
      for (int b : primesBetween2and1000)
      {
        if (findNumberOfNsThatYieldedPrimes(a, b) > tempMaxNOfPrimes)
        {
          tempMaxNOfPrimes = findNumberOfNsThatYieldedPrimes(a, b);
          magicA = a;
          magicB = b;
        }
      }
    }
    System.out.println("a = " + magicA + " " + "b = " + magicB + " yields " + 
    tempMaxNOfPrimes + " consecutive primes.");
    System.out.println("a * b = " + (magicA * magicB));
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static int findNumberOfNsThatYieldedPrimes(int a, int b)
  {
    int counterForNsThatYieldedPrimes = 0;
    int n = 0;
    int c = b;
    while (isPrime(c))
    {
      counterForNsThatYieldedPrimes++;
      n++;
      c = (n*n) + (a*n) + (b);
    }
    return counterForNsThatYieldedPrimes;
  }
  
  public static boolean isPrime(int number)
  {
    if (number < 0)
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
}
