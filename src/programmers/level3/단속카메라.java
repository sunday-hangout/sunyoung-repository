package programmers.level3;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

// https://programmers.co.kr/learn/courses/30/lessons/42884

public class 단속카메라 {
    public int solution(int[][] routes) {
      int answer = 0;
      int place = -30001;

      Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

      for (int[] route : routes) {
        if (place < route[0]) {
          place = route[1];
          answer++;
        }
      }

      return answer;
    }

  @Test
  public void 정답(){
    Assert.assertEquals(2, solution(new int[][]{{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}));
  }

}
