import java.util.stream.IntStream;


public class Hexadecimal
{
  /*
   * Reusing the Trinary class (see exercise Trinary), and making a few changes.
   */
  private static final int BASE = 16;
  private static final String HEXDIGITS = "0123456789abcdef";
  // The index of the digits gives the value: 7=7, b=11, etc.


  public static int toDecimal(String input) {
    String hexNumber = input.toLowerCase();
    // Only 0, 1, up to 15 (that is BASE-1) are allowed.
    if (hexNumber.matches(".*[^" + HEXDIGITS + "]+.*")) {
      return 0;
    }
   
    return IntStream.range(0, hexNumber.length())
                    .reduce(0, (acc, i) ->
                                 acc +
                                 HEXDIGITS.indexOf(hexNumber.charAt(i)) *
                                 (int)Math.pow(BASE, hexNumber.length() - 1 - i));
  }
}

