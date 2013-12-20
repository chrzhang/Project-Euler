package p036DoubleBasePalindromes;

public class p036
{
  /**
   * The decimal number, 585 = 10010010012 (binary), is palindromic in both 
   * bases.
   * Find the sum of all numbers, less than one million, which are palindromic 
   * in base 10 and base 2.
   * (Please note that the palindromic number, in either base, may not include 
   * leading zeros.)
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int total = 0;
    for (int i = 1; i < 1000000; i++)
    {
      if (isPalindromic(Integer.toString(i)) && isPalindromic(Integer.toBinaryString(i)))
      {
        total += i;
      }
    }
    System.out.println(total);
    System.out.printf("Running Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean isPalindromic(String s)
  {
    String firstHalf = s.substring(0, s.length() / 2);
    String secondHalf;
    if (s.length() % 2 == 0)
    {
      secondHalf = s.substring(s.length() / 2);
    }
    else
    {
      secondHalf = s.substring(s.length() / 2 + 1);
    }
    secondHalf = reverse(secondHalf);
    return firstHalf.equals(secondHalf);
  }
  
  public static String reverse(String str)
  {
    if (str == null || str.length() <= 1)
    {
      return str;
    }
    return (reverse(str.substring(1)) + str.charAt(0));
  }

}
