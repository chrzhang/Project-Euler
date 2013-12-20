package p007TenThousandAndFirstPrime;

public class p007
{
  /**
   * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can 
   * see that the 6th prime is 13.
   * What is the 10,001st prime number?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int counter = 0;
    int number = 1;
    int whichPrime = 10001;
    while (counter != whichPrime)
    {
      number++;
      if (isPrime(number))
      {
        counter++;
      }
    }
    System.out.println(number);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean isPrime(int number)
  {
    boolean returnVal = true;
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