package p034DigitFactorials;

public class p034
{
  /**
   * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
   * Find the sum of all numbers which are equal to the sum of the factorial of 
   * their digits.
   * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sum = 0;
    for (int i = 10; i < 2540160; i++)
    {
      if (isEqualToSumOfDigitFactorials(i))
      {
        System.out.println(i);
        sum += i;
      }
    }
    System.out.println("Sum: " + sum);
    System.out.printf("Running Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean isEqualToSumOfDigitFactorials(int a)
  {
    int sum = 0;
    String aStr = Integer.toString(a);
    for (int i = 0; i < aStr.length(); i++)
    {
      int temp = Character.getNumericValue(aStr.charAt(i));
      sum += getFactorial(temp);
    }
    return (sum == a);
  }
  
  public static int getFactorial(int b)
  {
    int product = 1;
    int n = b;
    while (n > 1)
    {
      product *= n;
      n--;
    }
    return product;
  }
  
  

}
