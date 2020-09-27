package leetcode.hard;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

public class LongestValidParentheses {

  public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>(); // index를 담을 스택
    stack.push(-1);

    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else { // )
        stack.pop();

        if (!stack.empty()) {
          result = Math.max(result, i - stack.peek()); // 기존 길이 vs 새로운 길이
        } else {
          stack.push(i); // 비어있다면 i
        }
      }
    }

    return result;
  }

  @Test
  public void 정답() {
    Assert.assertEquals(2, longestValidParentheses("(()")); // ()
    Assert.assertEquals(4, longestValidParentheses(")()())")); // ()
  }
}
