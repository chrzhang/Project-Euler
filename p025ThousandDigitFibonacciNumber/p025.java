package p025ThousandDigitFibonacciNumber;

import java.math.BigInteger;

public class p025
{

  /**
   * The Fibonacci sequence is defined by the recurrence relation:

      Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
      Hence the first 12 terms will be:
      
      F1 = 1
      F2 = 1
      F3 = 2
      F4 = 3
      F5 = 5
      F6 = 8
      F7 = 13
      F8 = 21
      F9 = 34
      F10 = 55
      F11 = 89
      F12 = 144

   * The 12th term, F12, is the first term to contain three digits.
   * What is the first term in the Fibonacci sequence to contain 1000 digits?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    boolean found = false;
    int counter = 3;
    BigInteger a = new BigInteger("1");
    BigInteger b = new BigInteger("1");
    BigInteger c;
    while (!found)
    {
      c = a.add(b);
      if (String.valueOf(c).length() == 1000)
      {
        found = true;
      }
      a = b;
      b = c;
      counter++;
    }
    System.out.println(counter - 1);
    System.out.printf("Running Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static BigInteger fibonacci(BigInteger n) 
  {
    if (n.equals(BigInteger.ZERO))
    {
      return (new BigInteger("0"));
    }
    else if (n.equals(BigInteger.ONE))
    {
      return (new BigInteger("1"));
    }
    else
    {
      return (fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(new BigInteger("2")))));
    }
  }

}
