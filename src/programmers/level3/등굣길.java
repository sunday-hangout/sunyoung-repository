package programmers.level3;

import org.junit.Assert;
import org.junit.Test;

public class 등굣길 {
  public int solution(int m, int n, int[][] puddles) {
    int[][] street = new int[n][m];

    // 웅덩이는 -1
    for (int[] puddle : puddles)
      street[puddle[1] - 1][puddle[0] - 1] = -1;

    street[0][0] = 1;

    for (int i = 0; i < n; i++) { // 시작점은 1로 저장
      for (int j = 0; j < m; j++) {

        if(street[i][j] == -1) { // 웅덩이면 0으로 바꾸고 continue
          street[i][j] = 0;
          continue;
        }

        if(i != 0)
          street[i][j] += street[i - 1][j] % 1000000007; // 숫자가 이 값을 초과할 수 있기 때문에 계산 과정에서 나머지 구하기

        if(j != 0)
          street[i][j] += street[i][j - 1] % 1000000007; // 왼쪽
      }
    }

    return street[n - 1][m - 1] % 1000000007;
  }

  @Test
  public void 정답(){
    Assert.assertEquals(4, solution(4, 3, new int[][]{{2,2}}));
    Assert.assertEquals(7, solution(4, 4, new int[][]{{3,2}, {2,4}}));
    Assert.assertEquals(7, solution(5, 3, new int[][]{{4,2}}));
    Assert.assertEquals(0, solution(2, 2, new int[][]{{2,1}, {1, 2}}));
    Assert.assertEquals(0, solution(3, 1, new int[][]{{2,1}}));

  }
}
