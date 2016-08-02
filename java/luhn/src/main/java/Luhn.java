public class Luhn
{
  private long luhnNumber;


  public Luhn(long num) {
    luhnNumber = num;
  }


  public int getCheckDigit() {
    return (int)(luhnNumber % 10L);
  }


  public int[] getAddends() {
    long num = luhnNumber;

    int lg = String.format("%d", num).length();
    int[] addends = new int[lg];

    // Process from right to left
    for (int i = lg - 1; i >= 0; i--) {
      addends[i] = (int)(num % 10L);

      if ((lg - 1 - i) % 2 != 0) {
        addends[i] *= 2;

        if (addends[i] >= 10) {
          addends[i] -= 9;
        }
      }

      num /= 10L;
    }

    return addends;
  }


  public int getCheckSum() {
    int[] addends = getAddends();

    int sum = 0;
    for (int i = 0; i < addends.length; i++) {
      sum += addends[i];
    }

    return sum;
  }


  public boolean isValid() {
    return getCheckSum() % 10 == 0;
  }


  public static long create(long number) {
    // Let's use some brute force here.
    long num = number * 10L;  // add the last digit
    Luhn ln = new Luhn(num);

    while (!ln.isValid()) {
      ln = new Luhn(++num);
    }

    return num;
  }
}

