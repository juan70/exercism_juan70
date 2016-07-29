import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Strain
{
  public static <T> List<T> keep(List<T> list, Predicate<T> pred) {
    return list.stream()
               .filter(pred)
               .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }


  public static <T> List<T> discard(List<T> list, Predicate<T> pred) {
    return keep(list, pred.negate());
  }
}

