package p009SpecialPythagoreanTriplet;

public class p009
{
  /**
   * A Pythagorean triplet is a set of three natural numbers, a  b  c, for 
   * which,
   * a^2 + b^2 = c^2
   * For example, 32 + 42 = 9 + 16 = 25 = 52.
   * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
   * Find the product abc.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int sum = 1000;
    for (int a = 1; a <= sum/3; a++)
    {
      for (int b = a + 1; b <= sum/2; b++)
      {
        int c = sum - a -b;
        if (c > 0 && (a*a + b*b == c*c))
        {
          System.out.println(String.format("a = %d, b = %d, c = %d", a, b, c));
          System.out.println("a * b * c = " + a*b*c);
        }
      }
    }
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}