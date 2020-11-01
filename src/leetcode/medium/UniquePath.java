package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

// https://leetcode.com/problems/unique-paths/

public class UniquePath {

  public int uniquePaths(int m, int n) {
    // 가로나 세로가 0이라면 경우의 수는 0이다.
    if (m <= 0 || n <= 0) {
      return 0;
    }

    int[][] a = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = 1;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        a[i][j] = a[i - 1][j] + a[i][j - 1]; // 위 + 왼쪽 값
      }
    }

    return a[m - 1][n - 1];
  }

  @Test
  public void 정답(){
    Assert.assertEquals(28, uniquePaths(3, 7));
  }

}
