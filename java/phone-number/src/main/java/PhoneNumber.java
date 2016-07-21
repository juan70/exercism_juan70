public class PhoneNumber {

  private static final int NUMDIGITS = 10;
  private String phoneNum;


  public PhoneNumber(String pn) {
    // clean the number: extract the digits only, ignoring non-digits characters
    String strDigs = pn.replaceAll("\\D+", "");

    if (strDigs.length() == NUMDIGITS) {
      phoneNum = strDigs;  // good number
    }
    else if (strDigs.length() == NUMDIGITS + 1 && strDigs.charAt(0) == '1') {
      phoneNum = strDigs.substring(1);  // extract good number
    }
    else {
      // everything else is a bad number
      phoneNum = String.format("%1$0" + NUMDIGITS + "d", 0);  // all zeroes
    }
  }


  public String getNumber() {
    return phoneNum;
  }


  public String getAreaCode() {
    return phoneNum.substring(0, 3);
  }


  public String pretty() {
    String fmt = "(%1$3s) %2$3s-%3$4s";
    return String.format(fmt, phoneNum.substring(0, 3),
                              phoneNum.substring(3, 6),
                              phoneNum.substring(6));
  }
}

