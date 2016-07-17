import java.util.Map;
import java.util.HashMap;

public class Pangrams {
  public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

  /* The tests tell us that this method must be static.
   */
  public static boolean isPangram(String text) {
    // Letter present in the text, yes/no
    Map<Character, Boolean> lettPres  = new HashMap<>();

    // Initialise the map. No letter detected so far. All false.
    LETTERS.chars()
    .mapToObj(i -> (char)i)
    .forEach(c -> lettPres.put(c, false));

    // Process the text
    text.toLowerCase().chars()
      .mapToObj(i -> (char)i)
      .forEach(c -> {
        Boolean v = lettPres.get(c);
        if (v != null && !v) {
            lettPres.replace(c, true);  /* letter detected */
        }
      });
    
    // https://stackoverflow.com/questions/30089469/how-to-sum-values-in-a-map-with-a-stream
    // All letters have been detected? All values are true?
    return lettPres.values().stream().reduce(true, (a, b) -> a && b);
  }
}

