public class Bob
{
  /* My interpretation:
   * - Consider only letters, not digits or punctuation or spaces, etc.
   * - If all letters are uppercase, it's yelling
   * - Otherwise, if a ? is a the end of the sentence, it's a question.
   */ 

  private final String SILENCE = "Fine. Be that way!";
  private final String YELLING = "Whoa, chill out!";
  private final String QUESTION = "Sure.";
  private final String OTHER = "Whatever.";


  private boolean isAllUpcase(String s) {
    // Ignore whatever is not a letter, working with Unicode characters
    String onlyLetters = String.join("", s.split("[^\\p{L}]+"));

    // The regex checks for the existence of at least one non-uppercase letter.
    // This regex only works on a non empty string (an empty string never has
    // any non-uppercase letter, for it has no letter whatsoever).
    return !onlyLetters.isEmpty() &&
           !onlyLetters.matches("^.*[^\\p{Lu}]+.*$");
  }


  public String hey(String text) {
    String txt = text.trim();

    if (txt.isEmpty()) {
      return SILENCE;
    }

    if (isAllUpcase(txt)) {
      return YELLING;
    }

    if (txt.endsWith("?")) {
      return QUESTION;
    }

    return OTHER; 
  }
}

