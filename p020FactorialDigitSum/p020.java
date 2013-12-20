package p020FactorialDigitSum;

import java.math.BigInteger;

public class p020
{

  /**
   * n! means n x (n - 1) x ... x 3 x 2 x 1
   * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
   * and the sum of the digits in the number 10! is 
   * 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
   * Find the sum of the digits in the number 100!
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sum = 0;
    BigInteger product = new BigInteger("1");
    BigInteger one = new BigInteger("1");
    BigInteger number = new BigInteger("100");
    while (number.compareTo(one) == 1)
    {
      product = product.multiply(number);
      number = number.subtract(new BigInteger("1"));
    }
    String pString = product.toString();
    for (int i = 0; i < pString.length(); i++)
    {
      int n = Character.getNumericValue(pString.charAt(i));
      sum += n;
    }
    System.out.println(sum);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }

}
