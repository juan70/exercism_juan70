import java.util.stream.IntStream;


public class Binary
{
  private static final int BASE = 2;

  private String binaryNum;


  public Binary(String bin) {
    // What if the string is empty or null?
    binaryNum = bin.trim();

    // Only 0s and 1s are allowed, and nothing else.
    if (binaryNum.matches(".*[^01].*")) {
      binaryNum = "0";
    }
  }


  public int getDecimal() {
    int lg = binaryNum.length();

    return (int)IntStream.range(0, lg)
                         .mapToLong( i -> Character.getNumericValue(binaryNum.charAt(i)) *
                                          (long)Math.pow(BASE, (lg - 1 - i)))
                         .sum();
  }
}

