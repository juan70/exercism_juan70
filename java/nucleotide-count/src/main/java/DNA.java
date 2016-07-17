import java.util.Map;
import java.util.HashMap;

public class DNA {
  /* Judging by the test file, we have to implement three functions:
   * 1. DNA(String), the constructor
   * 2. count(char), counting how many chars in the DNA string, and if
   *                 the char is not a nucleotide, throw an exception
   * 3. nucleotideCounts(), return a list of pairs or something like that...
   */

  public static final String NUCS = "ACGT";
  private String DNA_strand;


  public DNA(String s) {
    DNA_strand = s;
  }


  public int count(char nuc) {
    /* Information here https://stackoverflow.com/questions/22435833/why-is-string-chars-a-stream-of-ints-in-java-8 */
    if (NUCS.contains("" + nuc)) {
     /* return value must be an int, because the tests expect an int, not a long... */
      return (int)DNA_strand.chars()
                         .mapToObj(i -> (char)i)
                         .filter(c -> c == nuc)
                         .count();
    } else {
      throw new IllegalArgumentException();
    }
  }


  public Map<Character, Integer> nucleotideCounts() {
    Map<Character, Integer> pairs = new HashMap<>();

    NUCS.chars()
          .mapToObj(i -> (char)i)
          .forEach(c -> pairs.put(c, count(c)));

    return pairs;
  }
}

