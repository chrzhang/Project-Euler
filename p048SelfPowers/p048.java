package p048SelfPowers;

import java.math.BigInteger;

public class p048
{
	/**
	 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

		 Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
	 * @author Christopher Zhang
	 * @param args
	 */
	public static void main(String[] args)
	{
		double start = System.currentTimeMillis();
		BigInteger sum = BigInteger.ZERO;
		BigInteger square = BigInteger.ONE;
		BigInteger total = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++)
		{
			sum = square.pow(i);
			square = square.add(BigInteger.ONE);
			total = total.add(sum);
		}
		String digits = total.toString();
		for (int i = (digits.length() - 10); i <= (digits.length() - 1); i++)
		{
			System.out.print(digits.charAt(i));
		}
		System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
	}
}