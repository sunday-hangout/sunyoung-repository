package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/12911

import org.junit.Assert;
import org.junit.Test;

/*
조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 */

public class 다음_큰_숫자 {

  public int solution(int n) {
    int count = Integer.bitCount(n); // 비드 데이터의 이진수에서 1비트의 갯수 카운트

    for (int i = n + 1; ; i++) {
      if (count == Integer.bitCount(i)) { // 다음 숫자의 1비트 갯수를 구함
        return i;
      }
    }
  }


  @Test
  public void 정답() {
    Assert.assertEquals(83, solution(78));
    Assert.assertEquals(23, solution(15));
  }
}
