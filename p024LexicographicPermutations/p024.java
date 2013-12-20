package p024LexicographicPermutations;

import java.util.ArrayList;

public class p024
{
  static ArrayList<String> allPerms = new ArrayList<String>();
  /**
   * A permutation is an ordered arrangement of objects. For example, 3124 is 
   * one possible permutation of the digits 1, 2, 3 and 4. If all of the 
   * permutations are listed numerically or alphabetically, we call it 
   * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

    012   021   102   120   201   210

   * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 
   * 5, 6, 7, 8 and 9?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    permute("0123456789");
    System.out.println(allPerms.get(999999));
    System.out.printf("Running Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  public static void permute(String s)
  {
    int length = s.length();
    boolean[] wasUsed = new boolean[length];
    StringBuffer result = new StringBuffer(length);
    permutation(s, length, result, wasUsed, 0);
  }
  
  public static void permutation(String str, int length, StringBuffer output, boolean[] 
      wasUsed, int position)
  {
    if (position == length)
    {
      allPerms.add(output.toString());
      return;
    }
    else
    {
      for(int i = 0; i < length; i++)
      {
        if (wasUsed[i]) continue;
        output.append(str.charAt(i));
        wasUsed[i] = true;
        permutation(str,length,output,wasUsed,position+1);
        output.deleteCharAt(output.length()-1);
        wasUsed[i]=false;
      }
    }
  }

}
