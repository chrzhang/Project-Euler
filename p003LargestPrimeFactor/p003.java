package p003LargestPrimeFactor;

import java.math.BigInteger;
import java.util.ArrayList;

public class p003
{
  /**
   * The prime factors of 13195 are 5, 7, 13 and 29.
   * What is the largest prime factor of the number 600851475143 ?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
    BigInteger n = new BigInteger("600851475143");
    BigInteger i = new BigInteger("2");
    while (n.compareTo(new BigInteger("1")) > 0)
    {
      if (n.mod(i).equals(new BigInteger("0")))
      {
        numbers.add(i);
        n = n.divide(i);
      }
      else
      {
        i = i.add(new BigInteger("1"));
      }
    }
    System.out.println(i);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}