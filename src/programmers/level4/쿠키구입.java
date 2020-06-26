package programmers.level4;

// https://programmers.co.kr/learn/courses/30/lessons/49995

import org.junit.Assert;
import org.junit.Test;

public class 쿠키구입 {

  public int solution(int[] cookie) {
    int answer = 0;

    for (int i = 0; i < cookie.length - 1; i++) {
      int left = i;
      int leftSum = cookie[i];

      int right = i + 1;
      int rightSum = cookie[i + 1];

      while (true) {
        if (leftSum == rightSum && answer < leftSum) { // 두 쿠키의 합이 같으며, 쿠키의 합이 기존 answer에 저장했던 값보다 큰 경우
          answer = leftSum; // answer에 새로 저장
        } else if (leftSum < rightSum && left != 0) { // 오른쪽이 더 많은 경우, 왼쪽을 늘려야함
          leftSum += cookie[--left];
        } else if (leftSum > rightSum && right != cookie.length - 1) { // 왼쪽이 더 많은 경우, 오른쪽을 늘려야함
          rightSum += cookie[++right];
        } else { // 더 이상 조절할 수 없을 때
          break;
        }
      }
    }

    return answer;
  }

  @Test
  public void 정답() {
    Assert.assertEquals(3, solution(new int[]{1, 1, 2, 3}));
    Assert.assertEquals(0, solution(new int[]{1, 2, 4, 5}));
    Assert.assertEquals(15, solution(new int[]{0, 3, 3, 3, 3, 3, 5, 5, 5, 6}));
  }
}
