import java.util.stream.IntStream;


public class RomanNumeral
{
  // Let's do it as easy as possible
  private final String[][] ROMANS = { {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                                      {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                                      {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                                      {"", "M", "MM", "MMM"} };

  private int number;


  public RomanNumeral(int inp) throws IllegalArgumentException {
    // If Romans didn't use a zero, it's unlikely that they used negative numbers...
    number = Math.abs(inp);

    if (number > 3000) {
      throw new IllegalArgumentException("Number should not exceed 3000.");
    }
  }


  // Scan the number from left to right, as a string
  public String getRomanNumeral() {
    StringBuilder roman = new StringBuilder();
    String snum = Integer.toString(number);

    IntStream.range(0, snum.length())
             .forEach( pos -> {
               int dig = Character.getNumericValue(snum.charAt(pos));
               roman.append(ROMANS[snum.length() - 1 - pos][dig]);
             });

    return roman.toString();
  }
  


  /*
   * I don't usually leave dead code, but I will leave this one here just because.
   * The typical version, scanning the number from right to left.
   */
  /*
  public String getRomanNumeral() {
    StringBuilder roman = new StringBuilder();

    int num = number; 
    int digit = 0;
    int pos = 0;

    while (num != 0) {
      digit = num % 10;

      roman.insert(0, ROMANS[pos][digit]);

      num /= 10;
      pos++;
    }

    return roman.toString();
  }
  */
}

