package p044PentagonNumbers;

import java.util.ArrayList;

public class p044
{
	/**
	 * Pentagonal numbers are generated by the formula, Pn=n(3n1)/2. The first 
	 * ten pentagonal numbers are:

			1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
			
			It can be seen that P4 + P7 = 22 + 70 = 92 = P8. However, their 
			difference, 70  22 = 48, is not pentagonal.

			Find the pair of pentagonal numbers, Pj and Pk, for which their sum and 
			difference are pentagonal and D = |Pk  Pj| is minimised; what is the 
			value of D?
	 * @author Christopher Zhang
	 * @param args
	 */
	public static void main(String[] args)
	{
		double start = System.currentTimeMillis();
		ArrayList<Integer> pentagonals = new ArrayList<Integer>();
		int i = 0;
		boolean found = false;
		while (!found)
		{
			i ++;
			int p = (3*i*i - i) / 2;
			pentagonals.add(p);
			for (int n : pentagonals)
			{
				if (pentagonals.contains(p - n) && pentagonals.contains(p - 2*n))
				{
					System.out.println(p - 2*n);
					found = true;
				}
			}				
		}
		System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
	}
}
