import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;


public class PigLatin
{
  // As explained in the test file:
  // - Treated like vowels: any single vowel (a, e, i, o, u) or yt or xr
  // - Treated like consonants: ch, qu, <any single consonant>qu, th, thr, sch
  // - Treated like consonants: any other single letter
  // In any case, pig latin words end in ay.
  private static final String VOWELS = "([aeiou])|(yt)|(xr)";
  private static final String SPECIALCONSONANTS = "(ch)|([^aeiou]?qu)|(thr?)|(sch)";
  private static final String ENDING = "ay";


  // Translate a single word to Pig Latin
  private static String translateWord(String word) {
    String txt = word.trim().toLowerCase();
    StringBuilder result = new StringBuilder();

    Pattern pat = Pattern.compile("^" + VOWELS);
    Matcher mat = pat.matcher(txt);;

    if (mat.find()) {  // word starts with a vowel
      result.append(txt).append(ENDING);  // apple -> apple-ay -> appleay
    } else {
      pat = Pattern.compile("^" + SPECIALCONSONANTS);
      mat = pat.matcher(txt);

      if (mat.find()) {  // word starts with groups like ch, th, thr, etc.
        String conson = mat.group().substring(mat.start(), mat.end() - mat.start());
        result.append(txt.substring(conson.length()))
              .append(conson)
              .append(ENDING);  // school -> sch-ool -> ool-sch-ay -> oolschay
      } else {  // word starts with a single consonant (catch-all case)
        char firstChar = txt.charAt(0);
        result.append(txt.substring(1))
                         .append(firstChar)
                         .append(ENDING);  // xenon -> x-enon -> enon-x-ay -> enonxay
      }
    }

    return result.toString();
  }


  public static String translate(String phrase) {
    List<String> words = Arrays.asList(phrase.split(" +"));
    return String.join(" ", words.stream()
                                 .map( w -> translateWord(w) )
                                 .collect(Collectors.toList()));
  }
}

