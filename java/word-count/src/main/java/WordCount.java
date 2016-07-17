import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class WordCount {
  /* From what can be seen in the test file, we need to implement
   * phrase(String), returning a Map<String, Integer>.
   * Must be case-insensitive, keeping all in lower case.
   * Consider only letters and numbers, ignore punctuation and symbols.
   */

  public Map<String, Integer> phrase(String ph) {
    /* Okay, let's use a regex.
     * A separator is anything but letter/digit or group of letter/digit,
     * i.e. a non-word character or a group of non-word characters.
     * Hence: separator is \W+ (underscore _ is a valid char).
     */
    String[] str_list = ph.toLowerCase().split("\\W+");
    Map<String, Integer> counts = new HashMap<>();

    Arrays.asList(str_list)
      .forEach(s -> {
        Integer v = counts.putIfAbsent(s, 1);
        if (v != null) {
          counts.replace(s, v.intValue() + 1);
        }
      });

    return counts;
  }
}

