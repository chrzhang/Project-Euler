package p031CoinSums;

public class p031
{
  /**
   * In England the currency is made up of pound, £, and pence, p, and there are 
   * eight coins in general circulation:

      1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
      It is possible to make £2 in the following way:
      
      1£1 + 150p + 220p + 15p + 12p + 31p

   * How many different ways can £2 be made using any number of coins?
   * @author Christopher Zhang
   * @param args
   */
  static int[] monies = {1, 2, 5, 10, 20, 50, 100, 200};
  static final int GOAL = 200;
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    System.out.println(getNofPossibleCombos());
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  public static int getNofPossibleCombos()
  {
    return getCombos(monies.length - 1, 0);
  }
  public static int getCombos(int denomination, int amount)
  {
    int possibilities = 0;
    while (true)
    {
      // Check values greater than the target
      if ((amount + monies[denomination] > GOAL && denomination >= 1))
      {
        // Use a lower denomination
        return possibilities + getCombos(denomination - 1, amount);
      }
      // Using a lower denomination, find the combinations possible for it
      if (denomination >= 1)
      {
        possibilities += getCombos(denomination - 1, amount);
      }
      // If the combination yields the desired goal, return all possibilities
      if (amount +  monies[denomination] == GOAL)
      {
        return possibilities + 1;
      }
      // If the target is not reached, add one of the current denomination and 
      // continue
      if (amount + monies[denomination] < GOAL)
      {
        amount += monies[denomination];
      }  
    }
  }
 }