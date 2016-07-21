import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class School
{
  // The database is a simple map: <grade. list of names>
  private Map<Integer, List<String>> schoolDB;


  public School() {
    // DB is initially empty, not null
    schoolDB = new HashMap<>();
  }


  public Map<Integer, List<String>> db() {
    return schoolDB;
  }


  public void add(String name, int grd) {
    List<String> names = this.grade(grd);

    names.add(name);
    if (schoolDB.putIfAbsent(grd, names) == null) {
      schoolDB.replace(grd, names);
    }
  }


  public List<String> grade(int grd) {
    return schoolDB.getOrDefault(grd, new ArrayList<>());
  }


  public Map<Integer, List<String>> sort() {
    Map<Integer, List<String>> newMap = new HashMap<>();

    schoolDB.keySet()
            .stream()
            .sorted()
            .forEach( k -> newMap.put(k, schoolDB.get(k)
                                         .stream()
                                         .sorted()
                                         .collect(Collectors.toList())));

    return newMap;
  }
}

