public class HelloWorld {

  private static String default_name = "World";

  /* Everyhting must be static for the tests to compile correctly */
  public static String hello(String name) {
    return "Hello, " + (name == null || name.trim().isEmpty() ? default_name : name) + "!";
  }
}
