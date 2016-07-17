import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Etl {
   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
     Map<String, Integer> newMap = new HashMap<>();

     /* I am using Java 8, so lambda expressions are available */
     old.forEach((number, lst) ->
                   lst.forEach(str ->
                     newMap.put(str.toLowerCase(), number)));

     return newMap;
   }
}
