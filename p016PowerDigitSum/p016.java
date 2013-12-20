package p016PowerDigitSum;

import java.math.BigInteger;

public class p016
{
  /**
   * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
   * What is the sum of the digits of the number 2^1000?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sum = 0;
    String nString;
    BigInteger n = new BigInteger("2");
    n = n.pow(1000);
    nString = n.toString();
    for (int i = 0; i < nString.length(); i++)
    {
      sum += Character.getNumericValue(nString.charAt(i));
    }
    System.out.println(sum);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }

}
