package p004LargestPalindromeProduct;

import java.util.ArrayList;

public class p004
{

  /**
   * A palindromic number reads the same both ways. The largest palindrome made 
   * from the product of two 2-digit numbers is 9009 = 91 99.
   * Find the largest palindrome made from the product of two 3-digit numbers.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    int answer = 0;
    for (int i = 999; i > 99; i--)
    {
      for (int j = 999; j > 99; j--)
      {
        int k = i * j;
        int reverse = 0;
        while (k != 0)
        {
          reverse = reverse * 10;
          reverse = reverse + k%10;
          k = k/10;
        }
        if (reverse == (i * j))
        {
          answer = reverse;
          numbers.add(answer);
        }
      }
    }
    answer = numbers.get(0);
    for (int i : numbers)
    {
      if (i > answer)
      {
        answer = i;
      }
    }
    System.out.println(answer);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}