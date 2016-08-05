public class Prime
{
  // Let's make this method public too.
  public static boolean isPrime(int number) {
    int lim = (int)Math.sqrt(number);

    // Test against 2 and odd numbers only, with a fancy for loop...
    int i;
    for (i = 2;
         i <= lim && number % i != 0;
         i += i == 2 ? 1 : 2);

    return i > lim;
  }


  public static int nth(int pos) {
    if (pos <= 0) {
      throw new IllegalArgumentException();
    }

    int count = pos;
    int num = 1;

    while (count > 0) {
      num++;
      while (!isPrime(num)) { num++; }
      count--;
    }     

    return num;
  }
}

