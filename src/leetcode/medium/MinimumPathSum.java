package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

// https://leetcode.com/problems/minimum-path-sum/submissions/

public class MinimumPathSum {

  public int minPathSum(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (i == 0 && j == 0) {
          continue;
        } else if (i == 0) {
          grid[i][j] += grid[i][j - 1];
          continue;
        } else if (j == 0) {
          grid[i][j] += grid[i - 1][j];
          continue;
        } else {
          grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
        }
      }
    }

    return grid[grid.length-1][grid[0].length-1];
  }

  @Test
  public void 정답(){
    Assert.assertEquals(7, minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
  }

}
