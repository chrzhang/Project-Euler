package p042CodedTriangleNumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p042
{
	/**
	 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); 
	 * so the first ten triangle numbers are:

			1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

			By converting each letter in a word to a number corresponding to its 
			alphabetical position and adding these values we form a word value. For 
			example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word 
			value is a triangle number then we shall call the word a triangle word.

			Using words.txt (right click and 'Save Link/Target As...'), a 16K text 
			file containing nearly two-thousand common English words, how many are 
			triangle words?
	 * @author Christopher Zhang
	 * @param args
	 */
	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args)
	{
		double start = System.currentTimeMillis();
		int numOfTriWords = 0;
		try
		{
			String currentLine;
			BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
			currentLine = reader.readLine();
			String[] words = currentLine.split(",");
			for (int i = 0; i < words.length; i++)
			{
				if (isTriangle(getWordVal(words[i])))
				{
					numOfTriWords++;
				}
			}
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(numOfTriWords);
		System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
	}
	
	public static boolean isTriangle(int i)
	{
		int n = 8 * i + 1;
		if ((int) Math.sqrt(n) == Math.sqrt(n))
		{
			return true;
		}
		return false;
	}
	
	public static int getWordVal(String word)
	{
		int wordV = 0;
		for(int i = 0; i < word.length(); i++)
		{
			if (alphabet.contains(Character.toString(word.charAt(i))))
			{
				wordV += alphabet.indexOf(Character.toString(word.charAt(i))) + 1;
			}
		}
		return wordV;
	}
}
