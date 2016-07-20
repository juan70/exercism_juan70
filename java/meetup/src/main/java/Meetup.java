// Let's use the same classes as in the tests
// http://joda-time.sourceforge.net/apidocs/org/joda/time/DateTime.html
// http://joda-time.sourceforge.net/apidocs/org/joda/time/DateTimeConstants.html
import org.joda.time.DateTime;

import java.util.List;
import java.util.ArrayList;


public class Meetup
{
  private int month;
  private int year;


  public Meetup(int month, int year) {
    this.month = month;
    this.year = year;
  }


  // Note: tests do not compile if weekday is declared as type DateTimeConstants
  // (compiler complains about incompatible types)
  public DateTime day(int weekday, MeetupSchedule sched) {
    // Let's say weekday is MONDAY
    // Retrieve all the mondays in month-year
    // MONTEENTH is monday 13th (thirTEENTH) or 14th or ... 19th (nineTEENTH)

    // how many days in this month
    int maxDay = new DateTime(year, month, 1, 0, 0).dayOfMonth().getMaximumValue();
    // at most, there are 5 mondays in a month
    // and only 1 teenth for a specific weekday
    List<Integer> days = new ArrayList<>();

    for (int i = 1; i <= maxDay; i++) {
      if ( (new DateTime(year, month, i, 0, 0)).getDayOfWeek() == weekday ) {
        days.add(i);
      }
    }

    // now we extract from the list the day we are looking for
    int theDay;
    switch (sched) {
      case FIRST:
        theDay = days.get(0);
        break;
      case SECOND:
        theDay = days.get(1);
        break;
      case THIRD:
        theDay = days.get(2);
        break;
      case FOURTH:
        theDay = days.get(3);
        break;
      case LAST:
        theDay = days.get(days.size() - 1);
        break;
      case TEENTH:
        theDay = days.stream()
                     .filter(d -> d >= 13 && d <= 19)
                     .findFirst()
                     .get();  // I know the value exists, so I use get()
        break;
      default:
        throw new IllegalArgumentException();  // should not occur
    }

    return new DateTime(year, month, theDay, 0, 0);
  }
}

