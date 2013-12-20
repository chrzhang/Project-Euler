package p005SmallestMultiple;

public class p005
{
  /**
   * 2520 is the smallest number that can be divided by each of the numbers 
   * from 1 to 10 without any remainder.
   * What is the smallest positive number that is evenly divisible by all of 
   * the numbers from 1 to 20?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int answer = 0;
    int starting = 1;
    int maxBound = 20;
    boolean found = false;
    
    while (!found)
    {
      boolean allRight = true;
      for (int i = maxBound; i > 0 && allRight; i--)
      {
        if (starting % i != 0)
        {
          found = false;
          allRight = false;
        }
        else
        {
          answer = starting;
          found = true;
        }
      }
      starting++;
    }
    System.out.println(answer);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}