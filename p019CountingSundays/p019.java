package p019CountingSundays;

public class p019
{
  /**
   * You are given the following information, but you may prefer to do some 
   * research for yourself.

      1 Jan 1900 was a Monday.
      Thirty days has September,
      April, June and November.
      All the rest have thirty-one,
      Saving February alone,
      Which has twenty-eight, rain or shine.
      And on leap years, twenty-nine.

   * A leap year occurs on any year evenly divisible by 4, but not on a century 
   * unless it is divisible by 400.
   * How many Sundays fell on the first of the month during the twentieth 
   * century (1 Jan 1901 to 31 Dec 2000)?
   * @author Christopher Zhang
   * @param args
   */
  public static void main(String[] args)
  {
    double start = System.currentTimeMillis();
    int total = monthsStartRange(0, 1901, 2000);
    System.out.println(total);
    System.out.printf("\nRunning Time: %fms\n", System.currentTimeMillis() - 
        start);
  }
  
  /**
   * Gaussian algorithm to determine the day of the week
   * @param year
   * @param month
   * @param day
   * @return the day of the week
   */
  public static double dayOfWeek(int year, int month, int day)
  {
    int Y;
    int d = day;
    int m = (month - 3) % 12 + 1;
    if (m > 10)
    {
      Y = year - 1;
    }
    else
    {
      Y = year;
    }
      int y = Y % 100;
      int c = (Y - (Y % 100)) / 100;
    return (d + Math.floor(2.6 * m - 0.2) + y + Math.floor(y/4) + 
        Math.floor(c/4) - 2*c) % 7;
  }
  
  /**
   * Finds the number of months starting on a given day of the week in 
   * 1 century
   * @param day
   * @param starting year
   * @param ending year
   * @return number of months 
   */
  public static int monthsStartRange(int day, int start, int end)
  {
    int total = 0;
    for (int year = start; year < end; year++)
    {
      for (int month = 1; month <= 12; month++)
      {
        if (dayOfWeek(year, month, 1) == day)
        {
          total += 1;
        }
      }
    }
    return total;
  }
}
