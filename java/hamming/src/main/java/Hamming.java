import java.util.stream.IntStream;

public class Hamming {

  public static int compute(String dna1, String dna2) {
    if (dna1.length() != dna2.length()) {
      throw new IllegalArgumentException();
    }

    // mimic the zip function found in functional languages
    // http://blog.agiledeveloper.com/2014/10/working-around-lack-of-zip-function-in.html
    return (int)IntStream.range(0, dna1.length())
                         .mapToLong(i -> dna1.charAt(i) != dna2.charAt(i) ? 1 : 0)
                         .sum();

  }
}

