package programmers.level3;

import org.junit.Assert;
import org.junit.Test;

public class 타일_장식물 {

  public long solution(int n) {
    long answer = 2;
    long pibo[] = new long[80];

    pibo[0] = 1;
    pibo[1] = 1;

    for (int i = 2; i < 80; i++) {
      pibo[i] = pibo[i - 1] + pibo[i - 2];
    }

    if (n > 2) {
      answer = pibo[n - 1] + pibo[n];
    }

    return answer * 2;
  }

  @Test
  public void 정답() {
    Assert.assertEquals(26, solution(5));
    Assert.assertEquals(42, solution(6));

  }
}
