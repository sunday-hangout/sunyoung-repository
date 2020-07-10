package programmers.level3;

// https://programmers.co.kr/learn/courses/30/lessons/12979

import org.junit.Assert;
import org.junit.Test;

public class 기지국_설치 {

  public int solution(int n, int[] stations, int w) {
    int answer = 0;
    int location = 1;
    int index = 0;

    while (location <= n) {
      if (index <= stations.length - 1 && location >= stations[index] - w) {
        location = stations[index++] + w + 1;
      } else {
        location += 2 * w + 1;
        answer++;
      }
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assert.assertEquals(3, solution(11, new int[]{4, 11}, 1));
  }


}
