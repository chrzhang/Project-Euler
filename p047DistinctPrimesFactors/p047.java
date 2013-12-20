package p047DistinctPrimesFactors;

import java.util.ArrayList;

public class p047 
{
	/**
	 * The first two consecutive numbers to have two distinct prime factors are:

			14 = 2 × 7
			15 = 3 × 5
			
			The first three consecutive numbers to have three distinct prime factors are:
			
			644 = 2² × 7 × 23
			645 = 3 × 5 × 43
			646 = 2 × 17 × 19.

			Find the first four consecutive integers to have four distinct prime factors. 
			What is the first of these numbers?
		* @author Christopher Zhang
		* @param args
	 */
	public static void main(String[] args) 
	{
		double startTime = System.currentTimeMillis();
		final int NUM_CONSECUTIVE_INTS = 4;
		final int NUM_DISTINCT_PRIMES = 4;
		int currConsecCount = 1;
		int start = 2 * 3 * 5 * 7; // First number to have four unique prime factors
		
		// Incrementing from the start var
		while (currConsecCount != NUM_CONSECUTIVE_INTS)
		{
			start++;
			ArrayList<Integer> uniquePrimes = uniquePrimeFactors(start);
			if (uniquePrimes.size() == NUM_DISTINCT_PRIMES)
				currConsecCount++;
			else
				currConsecCount = 0;
		}
		System.out.println(start - NUM_DISTINCT_PRIMES + 1);
		System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        startTime);
	}
	
	/**
	 * Gets the prime factors (without duplicates) of an input integer
	 * @param num, the integer to be factorized into primes
	 * @return collection of unique prime factors
	 */
	public static ArrayList<Integer> uniquePrimeFactors(int num)
	{
		ArrayList<Integer> retColl = new ArrayList<Integer>();
		for (int i = 2; i <= Math.sqrt(num); i++)
		{
			if (num % i == 0)
			{
				while (num % i == 0)
				{
					num = num/i;
				}
				retColl.add(i);
			}
		}
		if (num != 1)
			retColl.add(num);
		return retColl;
	}
}