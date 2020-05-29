package level2;

import org.junit.Assert;
import org.junit.Test;

public class 문자열_압축 {

  public int solution(String s) {
    int min = s.length();

    for (int i = 1; i <= s.length() / 2; i++) {
      int compLeng = compression(s, i).length();
      min = Math.min(min, compLeng);
    }

    return min;
  }

  /**
   * 문자열 압축
   *
   * @param s 입력받은 문자열
   * @param i i값
   * @return 압축된 문자열
   */
  private String compression(String s, int i) {

    int count = 1;
    String compression = "";
    String pattern = "";

    for (int j = 0; j <= s.length() + i; j += i) {
      String nowStr;

      // 전 문자열과 비교할 현재 문자열
      if (j >= s.length()) { // 현재 문자열이 없을 때
        nowStr = "";
      } else if (s.length() < j + i) { // 마지막 현재 문자열일 때
        nowStr = s.substring(j);
      } else {
        nowStr = s.substring(j, j + i);
      }

      // 1. 전 문자열이랑 똑같은지 비교한다. (맨 처음, 맨 끝이면 비교 X)
      if (j != 0) {
        if (nowStr.equals(pattern)) { // 똑같으면
          count++;
        } else if (count >= 2) { // 다르고 count가 2회 이상이면 압축 가능
          compression += count + pattern;
          count = 1;
        } else { // 압축 불가능하면 그냥 그대로 문자열 이어붙이기
          compression += pattern;
        }
      }
      // 2. i 길이만큼 문자열을 자른다.
      pattern = nowStr;
    }

    return compression;
  }

  @Test
  public void 정답() {
    Assert.assertEquals(7, solution("aabbaccc"));
    Assert.assertEquals(9, solution("ababcdcdababcdcd"));
    Assert.assertEquals(8, solution("abcabcdede"));
    Assert.assertEquals(14, solution("abcabcabcabcdededededede"));
    Assert.assertEquals(17, solution("xababcdcdababcdcd"));
  }

}
