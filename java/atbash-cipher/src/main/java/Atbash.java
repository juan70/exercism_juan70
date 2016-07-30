import java.util.List;
import java.util.ArrayList;


public class Atbash
{
  /*
   * The algorithm can be implemented using a simple mathematical function, both
   * for encoding and decoding:
   *     encodedChar = -(plainChar) + 'z' + 'a'
   *     decodedChar = -(encodedChar) + 'z' + 'a'
   *  That is a line passing by the points (0, 'z'+'a') and ('z', 'a')
   *  and with slope -1.
   *  'z' and 'a' being the numeric code (ASCII or Unicode or whatever) of the
   *  letters.
   */

  // It is a symmetric encryption algorithm, thus encryption and decryption
  // are performed using the same function.
  private static String coding(String text) {
    // Ignore non-letters and non-digits
    String txt = text.toLowerCase().replaceAll("\\W+", "");

    return txt.chars()
              .mapToObj( i -> Character.isLetter((char)i) ?
                              (char)((int)'z' - i + (int)'a') :
                              (char)i )
              .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
              .toString();
  }


  // Organise the text by groups of a certain number of characters separated by
  // a space.
  private static String putSpaces(String text, int nbChars) {
    List<String> lst = new ArrayList<>();

    int nbGroups = text.length() / nbChars;
    int charsLeft = text.length() % nbChars;

    for (int i = 0; i < nbGroups; i++) {
        lst.add(text.substring(i * nbChars, i * nbChars + nbChars));
    }
    if (charsLeft > 0) {
      lst.add(text.substring(nbGroups * nbChars, nbGroups * nbChars + charsLeft));
    }

    return String.join(" ", lst);
  }


  public static String encode(String text) {
    return putSpaces(coding(text), 5);
  }


  public static String decode(String text) {
    return coding(text);
  }
}

