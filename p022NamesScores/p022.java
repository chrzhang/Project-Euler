package p022NamesScores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class p022
{
  public static String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", 
    "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
    "Y", "Z"};
  /**
   * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file 
   * containing over five-thousand first names, begin by sorting it into 
   * alphabetical order. Then working out the alphabetical value for each name, 
   * multiply this value by its alphabetical position in the list to obtain a 
   * name score.
   * For example, when the list is sorted into alphabetical order, COLIN, which 
   * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, 
   * COLIN would obtain a score of 938 x 53 = 49714.
   * What is the total of all the name scores in the file?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int totalSum = 0;
    try{
      String currentLine;
      BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
      currentLine = reader.readLine();
      String[] names = currentLine.split(",");
      Arrays.sort(names);
      // Iterate name by name
      for (int i = 0; i < names.length; i++)
      {
        int nameSum = 0;
        // Iterate through the individual name's letters
        for (int j = 1; j < names[i].length() - 1; j++)
        {
          nameSum += calculateLetterScore(names[i].charAt(j));
        }
        nameSum = nameSum * (i + 1);
        totalSum += nameSum;
        reader.close();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    System.out.println(totalSum);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static int calculateLetterScore(char c)
  {
    int returnVal = 0;
    boolean found = false;
    String s = Character.toString(c);
    for (int i = 0; i < letters.length && !found; i++)
    {
      if (s.equals(letters[i]))
      {
        returnVal = i + 1;
      }
    }
    return returnVal;
  }
}
