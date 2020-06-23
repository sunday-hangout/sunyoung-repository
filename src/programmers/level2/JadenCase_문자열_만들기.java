package level2;

// https://programmers.co.kr/learn/courses/30/lessons/12951

import org.junit.Assert;
import org.junit.Test;

public class JadenCase_문자열_만들기 {

  public String solution(String s) {
    StringBuilder answer = new StringBuilder(); // 문자열을 더하기 때문에 StringBuilder 사용

    String firstStr = s.charAt(0) + "";
    answer.append(firstStr.toUpperCase()); // 첫 글자는 무조건 대문자

    for (int i = 1; i < s.length(); i++) {
      String now = s.charAt(i) + "";
      if (now.equals(' ')) { // 공백이면 그대로 넘어가기
        answer.append(" ");
      } else if (s.charAt(i - 1) == ' ') { // 전 문자열이 공백이면
        answer.append(now.toUpperCase()); // 대문자
      } else {
        answer.append(now.toLowerCase()); // 소문자
      }
    }

    return answer.toString();
  }

  @Test
  public void 정답() {
    Assert.assertEquals("3people Unfollowed Me", solution("3people unFollowed me"));
    Assert.assertEquals("For The Last Week", solution("for the last week"));
    Assert.assertEquals("For", solution("for"));
    Assert.assertEquals("Hello  World", solution("hello  World"));
  }
}
