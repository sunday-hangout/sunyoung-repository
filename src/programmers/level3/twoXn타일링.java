package programmers.level3;

import org.junit.Assert;
import org.junit.Test;

public class twoXn타일링 {

  public int solution(int n) {
    int answer = 1;

    int a = 1;
    int b = 1;

    for (int i = 1; i < n; i++) {
      answer = (a + b)  % 1000000007;

      a = b;
      b = answer;
    }

    return answer;
  }


  @Test
  public void 정답() {
    Assert.assertEquals(5, solution(4));
    Assert.assertEquals(8, solution(5));
    Assert.assertEquals(1, solution(1));
  }


}
