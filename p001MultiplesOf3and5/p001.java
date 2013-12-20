package p001MultiplesOf3and5;

import java.util.ArrayList;

public class p001
{
  /**
   * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
   * we get 3, 5, 6 and 9. The sum of these multiples is 23.
   * 
   * Find the sum of all the multiples of 3 or 5 below 1000.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int upper = 1000;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for(int i = 1; i < upper; i++)
    {
      if ((i % 3 == 0) || (i % 5 == 0))
      {
        numbers.add(i);
      }
    }
    int sum = 0;
    for (int i : numbers)
    {
      sum += i;
    }
    System.out.println(sum);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}