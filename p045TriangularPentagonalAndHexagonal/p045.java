package p045TriangularPentagonalAndHexagonal;

public class p045
{
	/**
	 * Triangle, pentagonal, and hexagonal numbers are generated by the following 
	 * formulae:

			Triangle	 	Tn=n(n+1)/2	= 	1, 3, 6, 10, 15, ...
			Pentagonal	 	Pn=n(3n1)/2	= 	1, 5, 12, 22, 35, ...
			Hexagonal	 	Hn=n(2n1)	= 	1, 6, 15, 28, 45, ...

			It can be verified that T285 = P165 = H143 = 40755.

			Find the next triangle number that is also pentagonal and hexagonal.
	 * @author Christopher Zhang
	 * @param args
	 */
	public static void main(String[] args)
	{
		double start = System.currentTimeMillis();
		long i = 286;
		boolean found = false;
		while (!found)
		{
			long tri = (i+1)*i/2;
			if (isPentagonal(tri) && isHexagonal(tri))
			{
				System.out.println(tri);
				found = true;
			}
			i++;
		}
		System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
	}
	public static boolean isPentagonal(long number) 
	{
		double test = (Math.sqrt(24 * number + 1) + 1) / 6;
		return test == (int) test;
	}
	
	public static boolean isHexagonal(long number)
	{
		double test = (Math.sqrt(8 * number + 1) + 1) / 4;
		return test == (int) test;
	}
}
