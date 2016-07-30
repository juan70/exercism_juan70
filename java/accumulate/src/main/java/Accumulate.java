import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class Accumulate
{
  public static <T,R> List<R> accumulate(List<T> list, Function<T,R> fun) {
    List<R> result = new ArrayList<>();

    for (T elem : list) {
      result.add(fun.apply(elem));
    }

    return result;
  }
}

