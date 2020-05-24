package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42860

import org.junit.Assert;
import org.junit.Test;

public class 조이스틱 {

  public int solution(String name) {
    int answer = 0;

    // 1. 조이스틱을 최소한으로 움직일 수 있는 값을 구한다.
    int[] min = new int[name.length()];

    for (int i = 0; i < name.length(); i++) {
      min[i] = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
    }

    // 2. 현재 위치부터 시작해서 min의 모든 요소가 0이 될 때 까지 반복
    int startAt = 0;

    while (true) {
      answer += min[startAt];
      min[startAt] = 0;

      if (everythingIsZero(min)) {
        break;
      }

      int[] goToAt = goToAt(min, startAt);

      startAt = goToAt[0];
      answer += goToAt[1];
    }

    return answer;
  }

  // 왼쪽, 오른쪽 중 더 가까운 곳을 찾고 가까운 곳의 위치와 더할 값을 찾음
  private int[] goToAt(int[] min, int startAt) {

    int[] minThings = new int[2]; // 0번째->위치, 1번째->더할 값

    // 오른쪽으로 가는 최소 횟수 구하기
    int rightAt = startAt + 1 > min.length - 1 ? 0 : startAt + 1;
    int right = 1;

    while (min[rightAt] == 0) {
      rightAt = rightAt + 1 > min.length - 1 ? 0 : rightAt + 1;
      right++;
    }

    // 왼쪽으로 가는 최소 횟수 구하기
    int leftAt = startAt - 1 < 0 ? min.length - 1 : startAt - 1;
    int left = 1;

    while (min[leftAt] == 0) {
      leftAt = leftAt - 1 < 0 ? min.length - 1 : leftAt - 1;
      left++;
    }

    if (right > left) {
      minThings[0] = leftAt;
      minThings[1] = left;
    } else {
      minThings[0] = rightAt;
      minThings[1] = right;
    }

    return minThings;

  }

  // 모든 요소가 0인지 검사하는 메소드
  private boolean everythingIsZero(int[] min) {

    for (int i = 0; i < min.length; i++) {
      if (min[i] != 0) {
        return false;
      }
    }
    return true;
  }


  @Test
  public void 정답() {
    Assert.assertEquals(11, solution("JAZ"));
    Assert.assertEquals(56, solution("JEROEN"));
    Assert.assertEquals(23, solution("JAN"));
  }

}
