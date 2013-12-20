package p033DigitCancelingFractions;

public class p033
{
  /**
   * The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
   * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, 
   * which is correct, is obtained by cancelling the 9s.
   * 
   * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
   * There are exactly four non-trivial examples of this type of fraction, less 
   * than one in value, and containing two digits in the numerator and 
   * denominator.
   * 
   * If the product of these four fractions is given in its lowest common terms, 
   * find the value of the denominator.
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int finalNumerator = 1;
    int finalDenominator = 1;
    for (int numerator = 1; numerator < 99; numerator++)
    {
      for (int denominator = 99; denominator > 0 && denominator > numerator; 
          denominator--)
      {
        if (sharesDigits(numerator, denominator))
        {
          if (cancelledEqualsActual(numerator, denominator) && (!isTrivial(numerator, denominator)))
          {
            System.out.println(numerator + " / " + denominator);
            finalNumerator *= numerator;
            finalDenominator *= denominator;
          }
        }
      }
    }
    System.out.println("Product: " + finalNumerator + " / " + finalDenominator);
    System.out.println("Simplified: " + simplify(finalNumerator, finalDenominator));
    System.out.printf("Running Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static boolean sharesDigits (int a, int b)
  {
    String aStr = Integer.toString(a);
    String bStr = Integer.toString(b);
    for (int i = 0; i < aStr.length(); i++)
    {
      if (bStr.contains(Character.toString(aStr.charAt(i))))
      {
        return true;
      }
    }
    return false;
  }
  
  public static boolean cancelledEqualsActual(int a, int b)
  {
    String aStr = Integer.toString(a);
    String bStr = Integer.toString(b);
    for (int i = 0; i < aStr.length(); i++)
    {
      if (bStr.contains(Character.toString(aStr.charAt(i))))
      {
        bStr = bStr.replace(Character.toString(aStr.charAt(i)), "");
        aStr = aStr.replace(Character.toString(aStr.charAt(i)), "");
      }
    }
    if (bStr.equals(""))
    {
      bStr = "1";
    }
    if (aStr.equals(""))
    {
      aStr = "1";
    }
    double aDouble = (double) a;
    double bDouble = (double) b;
    double aDoubleS = Double.parseDouble(aStr);
    double bDoubleS = Double.parseDouble(bStr);
    
    if ((aDoubleS / bDoubleS) == (aDouble / bDouble))
    {
      return true;
    }
    return false;
  }
  
  public static boolean isTrivial(int n, int d)
  {
    return ((n % 10 == 0) && (d % 10 == 0));
  }
  
  public static String simplify(int a, int b)
  {
    int gcm = gcm(a, b);
    return ((a / gcm) + " / " + (b / gcm));
  }
  
  public static int gcm(int a, int b)
  {
    if (b == 0)
    {
      return a;
    }
    return gcm(b, a % b);
  }
}
