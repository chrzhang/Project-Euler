package p018MaximumPath1;

public class p018
{
  /**
   * By starting at the top of the triangle below and moving to adjacent numbers 
   * on the row below, the maximum total from top to bottom is 23.

          3
         7 4
        2 4 6
       8 5 9 3

    That is, 3 + 7 + 4 + 9 = 23.
    
   * Find the maximum total from top to bottom of the triangle below:

                                75
                               95 64
                              17 47 82
                             18 35 87 10
                            20 04 82 47 65
                           19 01 23 75 03 34
                          88 02 77 73 07 63 67
                         99 65 04 28 06 16 70 92
                        41 41 26 56 83 40 80 70 33
                       41 48 72 33 47 32 37 16 94 29
                      53 71 44 65 25 43 91 52 97 51 14
                     70 11 33 28 77 73 17 78 39 68 17 57
                   91 71 52 38 17 14 91 43 58 50 27 29 48
                  63 66 04 68 89 53 67 30 73 16 69 87 40 31
                 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int[] row1 = {75};
    int[] row2 = {95, 64};
    int[] row3 = {17, 47, 82};
    int[] row4 = {18, 35, 87, 10};
    int[] row5 = {20, 4, 82, 47, 65};
    int[] row6 = {19, 1, 23, 75, 3, 34};
    int[] row7 = {88, 2, 77, 73, 07, 63, 67};
    int[] row8 = {99, 65, 04, 28, 6, 16, 70, 92};
    int[] row9 = {41, 41, 26, 56, 83, 40, 80, 70, 33};
    int[] row10 = {41, 48, 72, 33, 47, 32, 37, 16, 94, 29};
    int[] row11 = {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14};
    int[] row12 = {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57};
    int[] row13 = {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48};
    int[] row14 = {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31};
    int[] row15 = {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23};

    int[][] rows = {row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, 
        row11, row12, row13, row14, row15};
    // Iterate through each row from the second last to the top
    for (int i = 13; i >= 0; i--)
    {
      int[] row = rows[i];
      int[] childRow = rows[i+1]; // This is the row under the current row
      // Iterate through each element in the current row
      for (int j = 0; j < row.length; j++)
      {
        // Set the parent to the max of itself plus one child versus the other
        row[j] = Math.max(row[j] + childRow[j], row[j] + childRow[j+1]);
      }
    }
    System.out.println(rows[0][0]);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
}
