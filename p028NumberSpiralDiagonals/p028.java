package p028NumberSpiralDiagonals;

public class p028
{
  /**
   * Starting with the number 1 and moving to the right in a clockwise direction 
   * a 5 by 5 spiral is formed as follows:

      21 22 23 24 25
      20  7  8  9 10
      19  6  1  2 11
      18  5  4  3 12
      17 16 15 14 13

    It can be verified that the sum of the numbers on the diagonals is 101.

   * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral 
   * formed in the same way?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int dimension = 1001;
    int rounds = (dimension - 1) / 2;
    int currentRound = 1;
    int currentRoundSum = 1;
    int counter = 0;
    int interval = 2;
    int totalAnswer = 0;
    while (currentRound <= rounds)
    {
      counter++;
      if (counter > 4)
      {
        counter = 1;
        interval += 2;
        currentRound++;
      }
      totalAnswer += currentRoundSum;
      currentRoundSum += interval;
    }
    System.out.println(totalAnswer);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}
