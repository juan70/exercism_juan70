import java.util.List;
import java.util.ArrayList;


public class PrimeFactors
{
  public static List<Long> getForNumber(long number) {
    List<Long> factors = new ArrayList<>();
    long num = number;
    long fact = 2;

    while (num > 1) {
      if (num % fact == 0) {
        factors.add(fact);
        num /= fact;
      } else {
        fact++;
      }
    }

    return factors;
  }



  /*
   * I wanted to use fancy stuff like a recursive function.
   * It works, but I get a StackOverflowError when numbers are too big, unless
   * I use a "java -Xss68m" option or something like that to increase the stack.
   * Is Java suggesting to use loops instead of recursion...?
   * I leave the code here, for information...
   */
  /*
  private static List<Long> getFactors(long num, long fact, List<Long> res) {
    if (num <= 1) {
      return res;
    } else {
      if (num % fact == 0) {
        res.add(fact);
        return getFactors(num / fact, fact, res);
      } else {
        return getFactors(num, fact + 1, res);
      }
    }
  }

  public static List<Long> getForNumber(long number) {
    return getFactors(number, 2, new ArrayList<Long>());
  }
  */
}

