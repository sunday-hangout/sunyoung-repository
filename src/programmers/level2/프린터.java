package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42587

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 프린터 {

  public int solution(int[] priorities, int location) {

    List<Wait> result = new ArrayList<>();
    List<Wait> wating = new ArrayList<>();

    for (int i = 0; i < priorities.length; i++) {
      Wait wait = new Wait();

      wait.num = i;
      wait.value = priorities[i];

      wating.add(wait);
    }

    while (!wating.isEmpty()) {
      // 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
      int first = wating.get(0).value;

      if (isBiggest(first, wating)) {  // 3. 그렇지 않으면 J를 인쇄합니다.
        if (wating.get(0).num == location) {     // 원하는 고유값에 해당하는 값 찾기
          return result.size() + 1;
        }
        wating.remove(0);
        result.add(wating.get(0));
      } else { // 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
        wating.add(wating.get(0));
        wating.remove(0);
      }
    }

    return 0;
  }

  private boolean isBiggest(int first, List<Wait> wating) {

    for (Wait wait : wating) {
      if (first < wait.value) {
        return false;
      }
    }

    return true;
  }


  @Test
  public void 정답() {
    Assert.assertEquals(1, solution(new int[]{2, 1, 3, 2}, 2));
    Assert.assertEquals(5, solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
  }

}

class Wait {

  public int num; // 고유번호
  public int value; // 값
}
