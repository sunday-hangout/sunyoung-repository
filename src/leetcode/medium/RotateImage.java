package leetcode.medium;

// https://leetcode.com/problems/rotate-image/

public class RotateImage {

  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; i++) {
      for (int j = i; j < matrix.length - i - 1; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[matrix.length - j - 1][i];
        matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
        matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
        matrix[j][matrix.length - i - 1] = temp;
      }
    }
  }
}
