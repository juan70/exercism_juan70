import java.util.Map;
import java.util.HashMap;


public class Scrabble
{
  private Map<Character, Integer> letterScore;  // Initialised in the constructor
  private String word;


  public Scrabble(String inp) {
    word = (inp == null) ? "" : inp.trim().toUpperCase();

    // This is a temporary map
    Map<String, Integer> letters = new HashMap<>();
    letters.put("AEIOULNRST", 1);
    letters.put("DG", 2);
    letters.put("BCMP", 3);
    letters.put("FHVWY", 4);
    letters.put("K", 5);
    letters.put("JX", 8);
    letters.put("QZ", 10);

    // Initialise the real map for letters: 'A'->1, 'B'->3, etc.
    letterScore = new HashMap<>();
    letters.keySet()
           .forEach( s -> s.chars()
                           .mapToObj( i -> (char)i )
                           .forEach( c -> letterScore.put(c, letters.get(s)) ));
  }


  public int getScore() {
    return word.chars()
               .reduce(0, (acc, i) -> acc + letterScore.get((char)i) );
  }
}

