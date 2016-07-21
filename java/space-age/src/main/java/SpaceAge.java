public class SpaceAge
{
  private static final long EARTH = 31557600;  // seconds/year
  private static final double MERCURY = 0.2408467;  // year/Earth_year
  private static final double VENUS = 0.61519726;
  private static final double MARS = 1.8808158;
  private static final double JUPITER = 11.862615;
  private static final double SATURN = 29.447498;
  private static final double URANUS = 84.016846;
  private static final double NEPTUNE = 164.016846;

  private long ageInSeconds;


  public SpaceAge(long sec) {
    ageInSeconds = sec;
  }


  public long getSeconds() {
    return ageInSeconds;
  }


  public double onEarth() {
    // 1 year is 31557600 seconds
    // 1 year / 31557600 seconds = x years / y seconds
    // ->  x years = y seconds / 31557600
    return (double)ageInSeconds / EARTH;
  }

  public double onMercury() {
    // 1 Mercury orbit (year) -> 0.2408467 Earth year
    // y Mercury orbits (years) -> x Earth years
    // ->  y Mercury orbits (years) = x Earth years / 0.2408467
    return onEarth() / MERCURY;
  }
 
  public double onVenus() {
    return onEarth() / VENUS;
  }

  public double onMars() {
    return onEarth() / MARS;
  }

  public double onJupiter() {
    return onEarth() / JUPITER;
  }

  public double onSaturn() {
    return onEarth() / SATURN;
  }

  public double onUranus() {
    return onEarth() / URANUS;
  }

  public double onNeptune() {
    return onEarth() / NEPTUNE;
  }
}

