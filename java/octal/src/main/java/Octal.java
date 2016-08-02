import java.util.stream.IntStream;


public class Octal
{
  /*
   * Copy of the Trinary class (see exercise trinary) with a few changes.
   */
  private static final int BASE = 8;
  private String octalNumber;


  public Octal(String input) {
    octalNumber = input;
  }


  public int getDecimal() {
    // Only 0, 1, ..., 7 (that is BASE-1) are allowed.
    if (octalNumber.matches(".*[^0-" + (BASE - 1) + "]+.*")) {
      return 0;
    }
   
    return IntStream.range(0, octalNumber.length())
                    .reduce(0, (acc, i) ->
                                 acc +
                                 Character.getNumericValue(octalNumber.charAt(i)) *
                                 (int)Math.pow(BASE, octalNumber.length() - 1 - i));
  }
}

