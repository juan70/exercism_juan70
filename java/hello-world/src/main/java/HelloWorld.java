public class HelloWorld {

  private static String defaultName = "World";

  /* Everyhting must be static for the tests to compile correctly */
  public static String hello(String name) {
    return "Hello, " + (name == null || name.trim().isEmpty() ? defaultName : name) + "!";
  }
}
