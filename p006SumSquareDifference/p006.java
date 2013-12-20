package p006SumSquareDifference;

public class p006
{
  /**
   * The sum of the squares of the first ten natural numbers is,
   * 1^2 + 2^2 + ... + 10^2 = 385
   * The square of the sum of the first ten natural numbers is,
   * (1 + 2 + ... + 10)^2 = 552 = 3025
   * Hence the difference between the sum of the squares of the first ten 
   * natural numbers and the square of the sum is 3025 - 385 = 2640.
   * Find the difference between the sum of the squares of the first one 
   * hundred natural numbers and the square of the sum.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sumOfSquares = 0;
    int squareOfSums = 0;
    int amount = 100;
    for (int i = 1; i <= amount; i++)
    {
      squareOfSums += i;
      sumOfSquares += (Math.pow(i, 2));
    }
    squareOfSums = squareOfSums * squareOfSums;
    System.out.println(squareOfSums - sumOfSquares);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}