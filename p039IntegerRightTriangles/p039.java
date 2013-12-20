package p039IntegerRightTriangles;

public class p039
{
  /**
   * If p is the perimeter of a right angle triangle with integral length sides, 
   * {a,b,c}, there are exactly three solutions for p = 120.

      {20,48,52}, {24,45,51}, {30,40,50}

   * For which value of p  1000, is the number of solutions maximised?
   * @author Chrisotpher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int max = 0;
    int magicP = 0;
    // Iterate through possible perimeters from 3 to 1000
    for (int perim = 3; perim <= 1000; perim++)
    {
      int possiblesForThisPerimeter = 0;
      // Starting with a = 1 to a = (p/2)-1
      for (int a = 1; a <= (perim / 2 - 1); a++)
      {
      // Starting with b = 1 to b = (p/2)-1
        for (int b = 1; b <= (perim / 2 - 1); b++)
        {
          // We instantly know that c = p - a - b
          int c = perim - a - b;
          // Test to see if a, b, and c can form a valid triangle
          if (a*a + b*b == c*c)
          {
            possiblesForThisPerimeter++;
          }
        }
      }
      if (possiblesForThisPerimeter > max)
      {
        max = possiblesForThisPerimeter;
        magicP = perim;
      }
    }
    System.out.println(magicP);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}
