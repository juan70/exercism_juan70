public class RnaTranscription
{
  // The order is important: A->U, C->G, G->C, T->A
  // Kind of a poor man's map...
  private static final String DNA = "ACGT";
  private static final String RNA = "UGCA";


  public static String ofDna(String dna) {
    // The input DNA strand is assumed to be correct, no weird characters and
    // the like.
    return dna.toUpperCase().chars()
              .mapToObj( i -> RNA.charAt(DNA.indexOf((char)i)) )
              .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
              .toString();
  }
}

