package p043SubstringDivisibility;

import java.util.ArrayList;

public class p043
{
	static ArrayList<String> perms = new ArrayList<String>();
	/**
	 * The number, 1406357289, is a 0 to 9 pandigital number because it is made 
	 * up of each of the digits 0 to 9 in some order, but it also has a rather 
	 * interesting sub-string divisibility property.

				Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, 
				we note the following:
				
				d2d3d4=406 is divisible by 2
				d3d4d5=063 is divisible by 3
				d4d5d6=635 is divisible by 5
				d5d6d7=357 is divisible by 7
				d6d7d8=572 is divisible by 11
				d7d8d9=728 is divisible by 13
				d8d9d10=289 is divisible by 17

	 * Find the sum of all 0 to 9 pandigital numbers with this property.
	 * @author Christopher Zhang
	 * @param args
	 */
	public static void main(String[] args)
	{
		double start = System.currentTimeMillis();
		permute("", "0123456789");
		long answer = 0;
		for (String s : perms)
		{
			answer += Long.valueOf(s).longValue();
		}
		System.out.println(answer);
		System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
	}
	
	 public static void permute(String beginningString, String 
			 endingString) 
	 {
	   if (endingString.length() <= 1)
	   {
	  	 if (check(beginningString + endingString))
	  	 {
	  		 perms.add(beginningString + endingString);
	  	 }	 
	   }
	   else
	   {
	  	 for (int i = 0; i < endingString.length(); i++) 
	     {
	        try {
	          String newString = endingString.substring(0, i) + 
	          		endingString.substring(i + 1);
	          permute(beginningString + endingString.charAt(i), newString);
	        } 
	        catch (StringIndexOutOfBoundsException exception) 
	        {
	          exception.printStackTrace();
	        }
	      }
	   }
	 }
	 
	 public static boolean check(String s)
	 {
		 // cannot start with 0
		 if (("" + s.charAt(0)).equals("0"))
		 {
			 return false;
		 }
		 // d4 must be even
		 else if ((Integer.parseInt("" + s.charAt(3))) % 2 != 0)
		 {
			 return false;
		 }
		 // d6 must be 5
		 else if ((Integer.parseInt("" + s.charAt(5))) != 5)
		 {
			 return false;
		 }
		 // d3d4d5 must be divisible by 3
		 else if ((Integer.parseInt(s.substring(2, 5))) % 3 != 0)
		 {
			 return false;
		 }
		 // d5d6d7 must be divisible by 7
		 else if ((Integer.parseInt(s.substring(4, 7))) % 7 != 0)
		 {
			 return false;
		 }
		 // d6d7d8 must be divisible by 11
		 else if ((Integer.parseInt(s.substring(5, 8))) % 11 != 0)
		 {
			 return false;
		 }
		 // d7d8d9 must be divisible by 13
		 else if ((Integer.parseInt(s.substring(6, 9))) % 13 != 0)
		 {
			 return false;
		 }
		 // d8d9d10 must be divisible by 17
		 else if ((Integer.parseInt(s.substring(7))) % 17 != 0)
		 {
			 return false;
		 }
		 return true;
	 }
}
