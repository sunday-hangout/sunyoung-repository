package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42747

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class H_Index {

  public int solution(int[] request) {

    Arrays.sort(request);

    int hIndex = 0;

    for (int i = 0; i < request.length; i++) {

      int number = request[i];
      int sum = request.length - i;

      if (number > sum) {
        number = sum;
      }

      if (hIndex < number) {
        hIndex = number;
      }
    }

    return hIndex;
  }

  @Test
  public void 정답() {
    Assert.assertEquals(3, solution(new int[]{3, 0, 6, 1, 5}));
    Assert.assertEquals(2, solution(new int[]{22, 42}));
    Assert.assertEquals(3, solution(new int[]{1, 7, 0, 1, 6, 4}));
    Assert.assertEquals(6, solution(new int[]{1542, 2, 999, 790, 540, 10, 22}));
  }
}

/*
1542 이상 인용된건 1
2 이상 인용된건 7
999 이상 인용된건 2
790 이상 인용된건 3
540 이상 인용된건 4
10 이상 인용된건 6
22 이상 인용된건 5
 */

