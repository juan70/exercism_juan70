import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Strain
{
  /*
   * I didn't read that we should not use the filter() function/method.
   * I modify my program accordingly...
   */
  public static <T> List<T> keep(List<T> list, Predicate<T> pred) {
    List<T> result = new ArrayList<>();

    for (T elem : list) {
      if (pred.test(elem)) { result.add(elem); }
    }

    return result;
  }


  public static <T> List<T> discard(List<T> list, Predicate<T> pred) {
    return keep(list, pred.negate());
  }
}

