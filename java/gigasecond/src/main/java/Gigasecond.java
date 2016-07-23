import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond
{
  private static final long GIGASECOND = 1000000000L;  // 10e9

  private LocalDateTime dateOfBirth;


  public Gigasecond(LocalDate ld) {
    dateOfBirth = ld.atTime(0, 0);
  }

  public Gigasecond(LocalDateTime ldt) {
    dateOfBirth = ldt;
  }


  public LocalDateTime getDate() {
    return dateOfBirth.plusSeconds(GIGASECOND);
  }
}

