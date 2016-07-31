import java.util.stream.IntStream;


public class Trinary
{
  private static final int BASE = 3;


  public static int toDecimal(String input) {
    // Only 0, 1, 2 (that is BASE-1) are allowed.
    if (input.matches(".*[^0-" + (BASE - 1) + "]+.*")) {
      return 0;
    }
   
    return IntStream.range(0, input.length())
                    .reduce(0, (acc, i) ->
                                 acc +
                                 Character.getNumericValue(input.charAt(i)) *
                                 (int)Math.pow(BASE, input.length() - 1 - i));
  }
}

