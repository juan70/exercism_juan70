import java.util.List;
import java.util.ArrayList;


public class Allergies
{
  /*
   * The score for allergens is a binary coding:
   * cats | pollen | chocolate | tomatoes | strawberries | shellfish | peanuts | eggs
   * 128    64       32          16         8              4           2         1
   * 2**7  2**6      2**5        2**4       2**3           2**2        2**1      2**0
   *
   * A score of 6 would be the binary number 110 -> shellfish and peanuts.
   */

  private List<Allergen> allergens;


  public Allergies(int score) {
    // First, compute kind of a binary code, keeping only the 1s, ignoring the 0s.
    // This step is useful only if the Allergen Enum (in Allergen.java)
    // is declared without any order, for example CHOCOLATE(32) before PEANUTS(2).
    List<Integer> bins = new ArrayList<>();
    int num = score;
    int pos = 0;

    while (num > 0) {
      int rest = num % 2; 
      if (rest != 0) {
        bins.add(rest * (int)Math.pow(2, pos));
      }
      num /= 2;
      pos++;
    }

    // Second, convert the integers into Allergen values.
    // (The values() method for Enum is documented here:
    //  https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    //  Curiously, it is not documented in the javadoc for class Enum...)
    List<Allergen> alls = new ArrayList<>();

    for (Allergen ag : Allergen.values()) {
      if (bins.contains(ag.getScore())) {
        alls.add(ag);
      }
    }

    allergens = alls;
  }


  public List<Allergen> getList() {
    return allergens;
  }


  public boolean isAllergicTo(Allergen prod) {
    return allergens.contains(prod);
  }
}

