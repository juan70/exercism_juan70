import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Anagram {

  private String word;


  public Anagram(String str) {
    word = str;
  }


  private String sortChars(String str) {
    // https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/StringBuilder.html
    return str.chars()
              .sorted()
              .mapToObj(i -> (char)i)
              .collect(StringBuilder::new, StringBuilder::append, StringBuilder:: append)
              .toString();
  }


  public List<String> match(List<String> wordsList) {
    Set<String> result = new HashSet<>();  // sets ignore duplicates
    String sortedWord = sortChars(word.toLowerCase());

    wordsList
      .forEach(w -> {
        String str = w.toLowerCase();
        if (!str.equals(word) &&
            sortChars(str).equals(sortedWord)) {
          result.add(w);
        }
      });

    // convert the set into a list of strings
    return Arrays.asList(result.toArray(new String[0]));
  }
}

