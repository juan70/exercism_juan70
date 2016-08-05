public class PascalsTriangle
{
  public static int[][] computeTriangle(int rows) {
    if (rows < 0) {
      throw new IllegalArgumentException("Negative number of rows.");
    }

    // I use a triangle with added 0s on the edges so I can easily add pairs of
    // numbers:
    //    0 1 0      0  1    0
    //   0 1 1 0     0  0+1  1+0  0
    //  0 1 2 1 0    0  0+1  1+1  1+0  0
    //  etc.
    int[][] tmpTri = new int[rows][];

    for (int r = 0; r < rows; r++) {
      if (r == 0) {
        tmpTri[r] = new int[]{0, 1, 0};
      } else {
        tmpTri[r] = new int[r + 1 + 2];

        for (int c = 0; c < r + 1 + 2; c++) {

          if (c == 0 || c == r + 2) {
            tmpTri[r][c] = 0;
          } else {
            tmpTri[r][c] = tmpTri[r-1][c-1] + tmpTri[r-1][c];
          }
        }
      }
    }

    // Shave the 0s at the edges to get the actual triangle.
    int[][] triangle = new int[rows][];
    for (int r = 0; r < rows; r++) {
      triangle[r] = new int[r + 1];

      for (int c = 1; c < r + 2; c++) {
        triangle[r][c-1] = tmpTri[r][c];
      }
    }

    return triangle;
  }


  public static boolean isTriangle(int[][] triangle) {
    int rows = triangle.length;
    int[][] good = new int[rows][];

    good = computeTriangle(rows);

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < r; c++) {
        if (triangle[r][c] != good[r][c]) {
          return false;
        }
      }
    }

    return true;
  }
}

