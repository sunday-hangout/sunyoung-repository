package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {

    if (p.length() == 0) { // p의 빈문자열이라면 s가 빈문자열이면 true, 아니라면 false 리턴
      return s.length() == 0;
    }

    if (p.length() == 1 || p.charAt(1) != '*') { // p의 길이가 1이거나 p의 다음글자가 *이 아니라면
      if (s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
        return false;
      }
      return isMatch(s.substring(1), p.substring(1)); // 1번째부터 끝까지 잘라서 재귀호출
    } else {
      int len = s.length();
      int i = -1;

      while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) { // i가 s의 길이보다 작고, (i가 0보다 작거나, p의 첫 글자가 .이거나, p의 0번째와 s의 i번째가 같으면)
        if (isMatch(s.substring(i + 1), p.substring(2))) {
          return true;
        }
        i++;
      }
    }
    return false;
  }


  @Test
  public void 정답() {
    Assert.assertEquals(false, isMatch("aa", "a"));
    Assert.assertEquals(true, isMatch("aa", "a*"));
  }

}
