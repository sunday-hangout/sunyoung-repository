package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

  List<String> result = new ArrayList<>();

  public static void main(String[] args) {
    GenerateParentheses g = new GenerateParentheses();
    g.generateParenthesis(3);
  }


  public List<String> generateParenthesis(int n) {
    dfs("", n, n);
//    result.forEach(System.out::println);
    return result;
  }

  public void dfs(String s, int left, int right) {
    System.out.println(s + " " + left + " " + right);
    if (left > right) {
      return;
    }

    if (left == 0 && right == 0) {
      System.out.println("추가 : " + s);
      result.add(s);
      return;
    }

    if (left > 0) {
      dfs(s + "(", left - 1, right);
    }

    if (right > 0) {
      dfs(s + ")", left, right - 1);
    }
  }


}
