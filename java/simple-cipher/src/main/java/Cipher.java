import java.util.Random;


public class Cipher
{
  private final int KEYLENGTH = 100;
  private String key;


  public Cipher() {
    // Generate random key containing only letters
    Random rnd = new Random();
    key = rnd.ints((int)'a', (int)'z')
             .limit(KEYLENGTH)
             .mapToObj( i -> (char)i )
             .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
             .toString();
  }


  public Cipher(String key) {
    if (key == null || key.isEmpty()) {  // test for null first...
      throw new IllegalArgumentException("Key empty.");
    }
    if (!key.matches("^[a-z]+$")) {
      throw new IllegalArgumentException("Key must contain only lower case letters 'a' to 'z'.");
    }

    this.key = key;
  }


  public String getKey() {
    return key;
  }


  private final int ENCODE = 1;
  private final int DECODE = -1;

  // Encode or decode 1 character
  private char codeChar(char original, char keyChar, int way) {
    int alphabetLength = (int)'z' - (int)'a' + 1;
    int charIndex = (int)original - (int)'a';
    int offset = 0;

    switch (way) {
      case ENCODE:
        offset = (int)keyChar - (int)'a';
        break;
      case DECODE:
        offset = (int)'z' - (int)keyChar + 1;
        break;
    }

    return (char)( ((charIndex + offset) % alphabetLength) + (int)'a' );
  }

  // Encode or decode a string
  private String codeString(String text, int way) {
    StringBuilder coded = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
      int j = i % key.length();
      coded.append(codeChar(text.charAt(i), key.charAt(j), way));   
    }

    return coded.toString();
  }


  public String encode(String text) {
    return codeString(text, ENCODE);
  }


  public String decode(String text) {
    return codeString(text, DECODE);
  }
}

