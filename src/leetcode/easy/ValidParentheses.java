package leetcode.easy;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char chr = s.charAt(i);

      if (chr == '(' || chr == '[' || chr == '{') {
        stack.push(chr);
        continue;
      }

      if (stack.isEmpty()) {
        return false;
      }

      Character pop = stack.pop();

      switch (chr) {
        case ')':
          if (pop != '(') {
            return false;
          }
          break;
        case '}':
          if (pop != '{') {
            return false;
          }
          break;
        case ']':
          if (pop != '[') {
            return false;
          }
          break;
      }
    }

    return stack.isEmpty();
  }


  @Test
  public void 정답() {
    Assert.assertEquals(false, isValid("())"));
    Assert.assertEquals(true, isValid("()"));
    Assert.assertEquals(true, isValid("()[]{}"));
    Assert.assertEquals(false, isValid("(]"));
    Assert.assertEquals(false, isValid("()((("));
  }


}
