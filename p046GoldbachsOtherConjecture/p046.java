package p046GoldbachsOtherConjecture;

public class p046
{
	/**
	 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
				
				9 = 7 + 2×12
				15 = 7 + 2×22
				21 = 3 + 2×32
				25 = 7 + 2×32
				27 = 19 + 2×22
				33 = 31 + 2×12

			It turns out that the conjecture was false.

			What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
		* @author Christopher Zhang
		* @param args
	 */
	public static void main(String[] args)
	{
		double start = System.currentTimeMillis();
		int[] primes = eratosthenes(10000);
		for (int i = 3; (i < 9999); i += 2)
		{
			if (primes[i] == 0) // for every odd composite number
			{
					boolean neverSquare = true;
					for (int k = 0; (k < i) && neverSquare; k++) // subtract every prime below it
					{
						if (primes[k] == 1)
						{
							int difference = i - k;
							difference = difference / 2;
							if (isSquare(difference))
							{
								neverSquare = false;
							}
						}
					}
					if (neverSquare)
					{
						System.out.println(i);
						System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
				        start);
						return;
					}
			}
		}
	}
	
	public static int[] eratosthenes(int upper)
	{
		int[] isPrime = new int[upper+1];
		
		for (int i = 0; i <= upper; i++)
		{
			isPrime[i] = 1;
		}
		isPrime[0] = 0;
		isPrime[1] = 0;
		for (int i = 2; i <= Math.sqrt(upper); i++)
		{
			if (isPrime[i] == 1) // if the number is prime
			{
					for (int j = 2; i * j <= upper; j++)
					{
						isPrime[i*j] = 0; // set all multiples to composite
					}
			}
		}
		return isPrime;
	}
	
	public static boolean isSquare(int n)
	{
		return (Math.sqrt(n) == (int) Math.sqrt(n));
	}
}