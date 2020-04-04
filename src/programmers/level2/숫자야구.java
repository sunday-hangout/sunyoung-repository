package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42841

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

public class 숫자야구 {

  public int solution(int[][] baseball) {

    int answer = 0;

    // 만들 수 있는 모든 수를 만듬 (124~987)
    Stack<String> things = makeThings(baseball);

    boolean flag = true;

    // 스택 하나씩 꺼내서 모든 strike와 ball의 조건에 해당되면 answer++
    while(!things.isEmpty()) {

      String num = things.pop();

      for(int i = 0; i < baseball.length && flag; i++) {

        int strike = strike(num, String.valueOf(baseball[i][0])); // 스트라이크 확인
        int ball = ball(num, String.valueOf(baseball[i][0])) - strike; // 볼 확인

        if(strike != baseball[i][1] || ball != baseball[i][2]) {
          flag = false;
        }

      }

      if(flag) {
        answer++;
      }

      flag = true;
    }

    return answer;
  }

  public static int strike(String num, String target) {
    int cnt = 0;
    for(int i = 0; i < target.length(); i++) {
      cnt = num.charAt(i) == target.charAt(i) ? cnt + 1 : cnt;
    }
    return cnt;
  }

  public static int ball(String num, String target) {
    int cnt = 0;
    for(int i = 0; i < target.length(); i++) {
      cnt = num.contains(String.valueOf(target.charAt(i))) ? cnt + 1 : cnt;
    }
    return cnt;
  }

  private Stack<String> makeThings(int[][] baseball) {

    Stack<String> stack = new Stack<>();

    for(int i = 1; i <= 9; i++) {
      for(int j = 1; j <= 9; j++) {
        for(int k = 1; k <= 9; k++) {
          if(i != j && j != k && i != k) {
            stack.add(String.valueOf(i * 100 + j * 10 + k));
          }
        }
      }
    }

    return stack;

  }

  @Test
  public void 정답() {
    Assert
        .assertEquals(2, solution(new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
  }

}
