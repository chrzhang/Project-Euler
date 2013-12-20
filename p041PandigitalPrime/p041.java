package p041PandigitalPrime;

public class p041
{
  /**
   * We shall say that an n-digit number is pandigital if it makes use of all 
   * the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital 
   * and is also prime.
   * 
   * What is the largest n-digit pandigital prime that exists?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
  	double start = System.currentTimeMillis();
    boolean found = false;
    for (long i = 7654321; !found; i--)
    {
      if (lengthValid(i) && isPandigital(i) && isPrime(i))
      {
    	  System.out.println(i);
    	  found = true;
      }
    }
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  private static boolean lengthValid(long i) {
	String s = Long.toString(i);
	if (s.length() == 1 || s.length() == 4 || s.length() == 7)
	{
		return true;
	}
	return false;
}

public static boolean isPandigital(long i)
  {
    String s = "" + i;
    boolean[] digits = new boolean[10];
    if (s.contains("0"))
    {
      return false;
    }
    int biggestDigit = 0;
    for (int k = 0; k < s.length(); k++)
    {
      int x = Character.getNumericValue(s.charAt(k));
      if (x > biggestDigit)
      {
        biggestDigit = x;
      }
      if (digits[x])
      {
    	  return false;
      }
      digits[x] = true;
      
    }
    for (int m = 1; m <= biggestDigit; m++)
    {
      if (!digits[m])
      {
        return false;
      }
    }
    return true;
  }
  
  public static boolean isPrime(long number)
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
  
  

}
