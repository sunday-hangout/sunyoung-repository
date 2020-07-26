package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 땅따먹기 {

  int solution(int[][] land) {
    int answer = 0;
    int n = 0;

    for (int i = 0; i < land.length; i++) {

      int max = land[i][0];
      int tempN = 0;

      for (int j = 1; j < land[i].length; j++) {
        if (max < land[i][j] && j != n) {
          max = land[i][j];
          tempN = j;
        }
      }

      n = tempN;
      answer += max;
    }


    return answer;
  }

  @Test
  public void 정답(){
    Assert.assertEquals(16, solution(new int[][]{{1, 2, 3, 5},{5, 6, 7, 8}, {4, 3, 2, 1}}));
  }

}
