package programmers.level3;

// https://programmers.co.kr/learn/courses/30/lessons/43237

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class 예산 {

  public int solution(int[] budgets, int M) {

    Arrays.sort(budgets);

    // 원하는 금액을 모두 나눠줄 수 있으면 최대 금액 리턴
    long sum = 0;

    for (int bgt : budgets) {
      sum += bgt;
    }

    if (sum <= M) {
      return budgets[budgets.length - 1];
    }

    // 그렇지 않을경우 이분탐색으로 최적의 해를 찾음
    int left = 0;
    int right = budgets[budgets.length - 1];

    while (true) {

      int celling = (left + right) / 2;

      long total = 0;

      for (int want : budgets) {
        total += Math.min(celling, want);
      }

      if (total == M) {
        return celling;
      } else if (total < M) {
        left = celling;
      } else {
        right = celling;
      }

      if ((left + right) / 2 == left) {
        return left;
      }

    }
  }

  @Test
  public void 정답() {
    Assert.assertEquals(127, solution(new int[]{120, 110, 140, 150}, 485));
    Assert.assertEquals(150, solution(new int[]{10, 12}, 600));
  }

}
