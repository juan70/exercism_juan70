public class BeerSong {

  private static final int INITIALBEERS = 99;


  private static String capitalize(String text) {
    StringBuilder newText = new StringBuilder();

    return newText.append(Character.toUpperCase(text.charAt(0)))
                  .append(text.substring(1))
                  .toString();
  }


  // One specific verse.
  public static String verse(int nVerse) {
    /*
    * Let's find the repeated patterns (maybe it's a bit confusing because there
    * are patterns within patterns...).
    * First line:
    *   <<n bottle<s> of beer> on the wall>, <<n> bottle<s> of beer>.\n
    * Second line:
    *   when n > 1:
    *     <Take <one> down and pass it around>, <<<n-1> bottle<s> of beer> on the wall>.\n\n
    *   when n = 1:
    *     <Take <it> down and pass it around>, <<<no more> bottle<s> of beer> on the wall>>.\n\n
    *   when n = 0 (= no more):
    *     <Go to the store and buy some more>, <<99 bottles of beer> on the wall>.\n\n
    */
    String fmtGeneral = "%1$s, %2$s.\n%3$s, %4$s.\n\n";
    String fmtBottles = "%1$s bottle%2$s of beer";
    String fmtWall = "%1$s on the wall";
    String fmtTake = "Take %1$s down and pass it around";
    String store = "Go to the store and buy some more";
    String noMore = "no more";

    StringBuilder verse = new StringBuilder();

    // 0 is "translated" into "no more"
    String howMany = nVerse == 0 ? noMore : String.format("%d", nVerse);
    String howManyNext = nVerse - 1 == 0 ? noMore : String.format("%d", nVerse - 1);

    String bottles =  String.format(fmtBottles, howMany, nVerse == 1 ? "" : "s");
    String wall =  String.format(fmtWall, bottles);
    String theVerse;

    if (nVerse == 0) {
      String newBottles = String.format(fmtBottles, INITIALBEERS, "s");
      String newWall = String.format(fmtWall, newBottles);
      theVerse = String.format(fmtGeneral, wall, bottles, store, newWall);
    } else {
      String take = String.format(fmtTake, nVerse == 1 ? "it" : "one");
      String newBottles = String.format(fmtBottles, howManyNext, nVerse - 1 == 1 ? "" : "s");
      String newWall = String.format(fmtWall, newBottles);
      theVerse = String.format(fmtGeneral, wall, bottles, take, newWall);
    }

    return capitalize(theVerse.toString()); // Just in case "no more" starts the verse.
  }


  // A range of verses, from nStart downto nEnd.
  public static String sing(int nStart, int nEnd) {
    StringBuilder song = new StringBuilder();
    for (int i = nStart; i >= nEnd; i--) {
      song.append(verse(i));
    }

    return song.toString();
  }


  // The whole song from start to end.
  public static String singSong() {
    return sing(INITIALBEERS, 0);
  }
}

