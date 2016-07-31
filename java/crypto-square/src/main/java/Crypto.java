import java.util.List;
import java.util.ArrayList;


public class Crypto
{
  private String plainText;


  public Crypto(String text) {
    plainText = text;
  }


  public String getNormalizedPlaintext() {
    // Keep only the letters and digits, ignore everything else.
    return plainText.replaceAll("\\W+", "").toLowerCase();
  }


  public int getSquareSize() {
    int lg = getNormalizedPlaintext().length();

    for (int i = 1; i < lg; i++) {
      int c1 = i;
      int r1 = i;
      int c2 = i + 1;
      int r2 = i + 1;

      // We are looking for a square that can hold the whole string.
      // That means we need: c * r >= string_length
      // The requirements for c (columns) and r (rows) are:
      //   c >= r  and  c - r <= 1
      // That is:
      //   either  c = r  or  c = r+1
      if (c1 * r1 >= lg) {  // condition met: c = r
       return c1;
      }
      if (c2 * r1 >= lg) {  // condition met: c = r+1
        return c2;
      }
      if (c2 * r2 >= lg) {  // condition met: c = r
        return c2;
      }
    }

    return -1;  // should never happen, but the compiler wants a return statement.
  }


  public List<String> getPlaintextSegments () {
    List<String> lst = new ArrayList<>();

    String plain = getNormalizedPlaintext();
    int lg = plain.length();
    int cols = getSquareSize();

    int rows = lg / cols;
    int charsLeft = lg % cols;

    for (int i = 0; i < rows; i++) {
      lst.add(plain.substring(i * cols, i * cols + cols));
    }
    if (charsLeft > 0) {
      lst.add(plain.substring(lg - charsLeft, lg));
    }

    return lst;
  }


  public String getCipherText() {
    StringBuilder ciphText = new StringBuilder();

    List<String> segs = getPlaintextSegments();
    int cols = getSquareSize();

    for (int i = 0; i < cols; i++) {
      for (String seg : segs) {
        if (i < seg.length()) {
          ciphText.append(seg.charAt(i));
        }
      }
    }

    return ciphText.toString();
  }


  public String getNormalizedCipherText() {
    StringBuilder result = new StringBuilder();
    String ciphText = getCipherText();

    int rows = getSquareSize();
    int cols = rows - (rows * (rows - 1) >= ciphText.length() ? 1 : 0);
    int nSpaces = rows * cols - ciphText.length();
    // The segments have length cols, but the last nSpaces strings have
    // length (cols-1), unless rows=cols, of course.

    // Process the strings of length cols.
    for (int i = 0; i < rows - nSpaces; i++) {
      int idx = i * cols;
      result.append(ciphText.substring(idx, idx + cols));
      if (i < rows - 1) {  // avoid trailing space
        result.append(" ");
      }
    }

    // Process the remaining rows contaning the strings of length cols-1,
    // taking into account that the previous rows had length cols.
    for (int i = 0; i < nSpaces; i++) {
      // compute the correct offset
      int idx = (rows - nSpaces) * cols + i * (cols - 1);
      result.append(ciphText.substring(idx, idx + (cols - 1)));
      if (i < nSpaces - 1) {
        result.append(" ");
      }
    }

    return result.toString();
  }


  /*
    // Hmmm... A comment here. This is a bit confusing...
    // Maybe I am wrong, but I guess we are supposed to:
    // 1st: Implement getCipherText()
    // 2nd: Implement getNormalizedCipherText() using getCipherText() to
    //      retrieve the ciphered string first, and then insert the spaces in
    //      the correct places.
    // But I find it much easier to do it the other way around, because we
    // already have the plain text segments, so we can directly have the
    // correct ciphered segments, and just put spaces in between them to get the
    // result.
    // Then, in getCipherText() we can just delete the spaces.
    // Actually, we *need* the plain text segments in order to perform the
    // ciphering.
    // I leave the code here for information (for myself, actually).

  public String getCipherText() {
    return getNormalizedCipherText().replaceAll(" ", "");
  }

  public String getNormalizedCipherText() {
    StringBuilder ciphSeg = new StringBuilder();
    List<String> segs = getPlaintextSegments();
    int cols = getSquareSize();
    List<String> cipherSegs = new ArrayList<>();

    for (int i = 0; i < cols; i++) {
      for (String seg : segs) {
        if (i < seg.length()) {
          ciphSeg.append(seg.charAt(i));
        }
      }
      cipherSegs.add(ciphSeg.toString());
      ciphSeg.delete(0, ciphSeg.length());
    }

    return String.join(" ", cipherSegs);
  }
  */
}

