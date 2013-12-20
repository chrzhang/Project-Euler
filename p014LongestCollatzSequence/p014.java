package p014LongestCollatzSequence;

public class p014
{
  /**
   * The following iterative sequence is defined for the set of positive 
   * integers:

      n  n/2 (n is even)
      n  3n + 1 (n is odd)

   * Using the rule above and starting with 13, we generate the following 
   * sequence:

      13  40  20  10  5  16  8  4  2  1
      
   * It can be seen that this sequence (starting at 13 and finishing at 1) 
   * contains 10 terms. Although it has not been proved yet (Collatz Problem), 
   * it is thought that all starting numbers finish at 1.
   * Which starting number, under one million, produces the longest chain?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    long startingNumberAnswer = 0;
    long maxNumElements = 0;
    int BOUND = 1000000;
    // Iterate from 1 to 1000000
    for (long i = 1; i < BOUND; i++)
    {
      long w = findNumElementsInSequence(i);
      if (w > maxNumElements)
      {
        maxNumElements = w;
        startingNumberAnswer = i;
      }
    }
    System.out.println(startingNumberAnswer + " has a " + maxNumElements +
        "-count sequence.");
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static long findNumElementsInSequence(long n)
  {
    long counter = 1;
    while (n != 1)
    {
      if (n % 2 == 0)
      {
        n = n/2;
        counter++;
      }
      else
      {
        n = 3 * n + 1;
        counter++;
      }
    }
    return counter;
  }
}
