package leetcode.easy;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);

      if (x == '(' || x == '[' || x == '{') {
        stack.push(x);
        continue;
      }

      if (stack.isEmpty()) {
        return false;
      }

      switch (x) {
        case ')':
          if (stack.peek() != '(') {
            return false;
          }
          stack.pop();
          break;
        case '}':
          if (stack.peek() != '{') {
            return false;
          }
          stack.pop();
          break;
        case ']':
          if (stack.peek() != '[') {
            return false;
          }
          stack.pop();
          break;
      }
    }

    return stack.isEmpty();
  }


  @Test
  public void 정답() {
    Assert.assertEquals(true, isValid("()"));
    Assert.assertEquals(true, isValid("()[]{}"));
    Assert.assertEquals(false, isValid("(]"));
    Assert.assertEquals(false, isValid("()((("));
  }


}
