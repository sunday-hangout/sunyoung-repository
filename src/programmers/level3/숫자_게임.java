package programmers.level3;

// https://programmers.co.kr/learn/courses/30/lessons/12987

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class 숫자_게임 {

  public int solution(int[] a, int[] b) {
    int answer = 0;

    Arrays.sort(a);
    Arrays.sort(b);

    int bIdx = b.length - 1;

    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i] < b[bIdx]) { // b가 더 크면 bIdx--
        bIdx--;
        answer++;
      }
    }

    return answer;
  }


  @Test
  public void 정답() {
    Assert.assertEquals(3, solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
    Assert.assertEquals(0, solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
  }

}
