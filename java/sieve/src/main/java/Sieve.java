import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class Sieve
{
  private int maxNumber;


  public Sieve(int num) {
    maxNumber = num;
  }


  public List<Integer> getPrimes() {
    // Mark for composite numbers. 0 is not prime...
    final int COMPOSITE = 0;
    List<Integer> numbers = new ArrayList<>();

    // I follow the instructions step by step.

    // Create the range from 2 up to and including the limit: [2, maxNumber].
    IntStream.rangeClosed(2, maxNumber)
             .forEach( i -> numbers.add(i) );

    // Repeat until each number is processed.
    for (int i = 0; i < numbers.size() - 1; i++) {
      // Take the next available unmarked number (I call it factor).
      int factor = numbers.get(i);
      if (factor == COMPOSITE) {
        continue;  // skip a marked number and see the next number
      }

      // Mark all the multiples of that number (factor).
      // (Except those that are already marked, of course.)
      for (int j = i + 1; j < numbers.size(); j++) {
        int number = numbers.get(j);
        if (number != COMPOSITE && number % factor == 0) {
          numbers.set(j, COMPOSITE);  // mark as composite number
        }
      }
    }

    // Extract the unmarked numbers: they are prime.
    return numbers.stream()
                  .filter( i -> i != COMPOSITE )
                  .collect(Collectors.toList());
  }
}

