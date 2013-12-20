package p035CircularPrimes;

public class p035
{
  /**
   * The number, 197, is called a circular prime because all rotations of the 
   * digits: 197, 971, and 719, are themselves prime.
   * There are thirteen such primes below 100: 
   * 
   * 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
   * 
   * How many circular primes are there below one million?
   * @author Christopher Zhang
   * @param args
   */
  static boolean[] primes;
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int count = 0;
    primes = new boolean[1000001];
    for (int i = 2; i < primes.length; i++)
    {
      if (isPrime(i))
      {
        primes[i] = true;
      }
    }
    for (int i = 2; i < primes.length; i++)
    {
      if (primes[i])
      {
        if (allRotationsArePrime(i))
        {
          count++;
        }
      }
    }
    System.out.println(count);
    System.out.printf("Running Time: %fms\n", System.currentTimeMillis() - 
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
  
  public static boolean allRotationsArePrime(int number)
  {
    String s = Integer.toString(number);
    for (int i = 1; i < s.length(); i++)
    {
      String rs = "";
      for (int j = 1; j < s.length(); j++)
      {
        rs = rs.concat(Character.toString(s.charAt(j)));
      }
      rs = rs.concat(Character.toString(s.charAt(0)));
      s = rs;
      if (!(primes[Integer.parseInt(rs)]))
      {
        return false;
      }
    }
    return true;
  }
}
