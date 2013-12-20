package p021AmicableNumbers;

public class p021
{
  /**
   * Let d(n) be defined as the sum of proper divisors of n (numbers less than 
   * n which divide evenly into n).
   * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair 
   * and each of a and b are called amicable numbers.
   * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 
   * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 
   * 71 and 142; so d(284) = 220.
   * Evaluate the sum of all the amicable numbers under 10000.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sumAll = 0;
    boolean[] numbers = new boolean[10000];
    for (int i = 0; i < numbers.length; i++)
    {
      if (!numbers[i])
      {
        int h = sumOfDivisors(i);
        if (sumOfDivisors(h) == i)
        {
          if (h != i)
          {
            numbers[h] = true;
            sumAll += h;
            sumAll += i;
          }
        }
      }
    }
    System.out.println(sumAll);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static int sumOfDivisors(int n)
  {
    int sum = 0;
    for (int i = 1; i < n; i++)
    {
      if (n % i == 0)
      {
        sum += i;
      }
    }
    return sum;
  }
}
