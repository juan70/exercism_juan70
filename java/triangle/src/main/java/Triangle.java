public class Triangle
{
  private double side1;
  private double side2;
  private double side3;


  public Triangle(double a, double b, double c) throws TriangleException {
    // Could a triangle with only one side of length 0 be valid?
    if (a <= 0 || b <= 0 || c <= 0) {
      throw new TriangleException();
    }

    // Check triangle inequality
    if (a + b <= c
     || a + c <= b
     || b + c <= a) {
      throw new TriangleException();
    }

    side1 = a;
    side2 = b;
    side3 = c;
  }


  public TriangleKind getKind() {
    if (side1 == side2
     && side2 == side3) {
      return TriangleKind.EQUILATERAL;
    }

    if (side1 != side2
     && side1 != side3
     && side2 != side3) {
      return TriangleKind.SCALENE;
    }

    return TriangleKind.ISOSCELES;
  }
}

