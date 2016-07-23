import java.util.Arrays;

public class Acronym
{
  private static final String SPLITREGEXP = "(\\W+)|(?<=[^\\p{Lu}])(?=\\p{Lu})";
  // Select locations:
  // 1. A bunch of non-alphanumeric characters; this is the (\\W+) part
  //      ex: metal-oxide -> metal oxide
  //          metal !#$%, . oxide -> metal oxide
  // 2. Or after a non-uppercase letter AND before a following uppercase letter
  //      ex: HyperText -> Hyper Text
  //          PHP -> PHP
  //          semiconductor -> semiconductor


  public static String generate(String text) {
    return Arrays.asList(text.split(SPLITREGEXP))
           .stream()
           .filter( s -> s.length() > 0 )
           .collect(StringBuilder::new,
                    (acc, s) -> acc.append(s.charAt(0)),
                    StringBuilder::append)
           .toString()
           .toUpperCase();
  }
}

