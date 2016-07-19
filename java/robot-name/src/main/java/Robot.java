import java.util.Random;

public class Robot
{
  private final int NUMLETTERS = 2;
  private final int NUMDIGITS = 3;

  private String name = null;


  public void reset() {
    name = null;
  }


  private String generateName() {
    StringBuilder newName = new StringBuilder(NUMLETTERS + NUMDIGITS);

    // generate two letters
    // (I was going to use something like
    //    IntStream.range(0, NUMLETTERS)
    //             .forEach(i -> { ... });
    // but it is a bit overkill, isn't it?)
    for (int i = 0; i < NUMLETTERS; i++) {
       // compute an int between 0 and 25 (26 letters from A to Z)
       // add the ascii code for A to get between the correct interval [A..Z]
       int mod = (int)'Z' - (int)'A' + 1;  // like a value for a modulo operation
       int code = (new Random()).nextInt(mod) + (int)'A';
       newName.append((char)code);
    };

    // generate the numeric part, from 000 to 999 in our case (3 digits),
    // formatting the number to NUMDIGITS digits, padding left with zeroes
    int number = (new Random()).nextInt((int)Math.pow(10, NUMDIGITS));
    newName.append(String.format("%1$0" + NUMDIGITS + "d", number));

    return newName.toString();
  }


  public String getName() {
    if (name != null) {
      return name;
    } else {
      name = generateName();
      return name;
    }
  }
}

