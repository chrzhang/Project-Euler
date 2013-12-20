package p040ChamernownesConstant;

public class p040
{

  /**
   * An irrational decimal fraction is created by concatenating the positive 
   * integers:

      0.123456789101112131415161718192021...

    It can be seen that the 12th digit of the fractional part is 1.

    If dn represents the nth digit of the fractional part, find the value of the 
    following expression.

    d1 x d10 x d100 x d1000 x d10000 x d100000 x d1000000
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int product = 1;
    int i = 1;
    StringBuilder s = new StringBuilder();
    // TODO Auto-generated method stub
    while (s.length() < 1000000)
    { 
      s.append(i);
      i++;
    }
    product *= Character.getNumericValue(s.charAt(0));
    product *= Character.getNumericValue(s.charAt(9));
    product *= Character.getNumericValue(s.charAt(99));
    product *= Character.getNumericValue(s.charAt(999));
    product *= Character.getNumericValue(s.charAt(9999));
    product *= Character.getNumericValue(s.charAt(99999));
    product *= Character.getNumericValue(s.charAt(999999));
    System.out.println(product);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }

}
