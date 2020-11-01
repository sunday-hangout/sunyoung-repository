package leetcode.easy;

public class ClimbingStairs {

  public int climbStairs(int n) {
    if (n < 2) {
      return n;
    }

    int number[] = new int[n + 1];

    number[1] = 1;
    number[2] = 2;

    for (int i = 3; i <= n; i++) {
      number[i] = number[i - 1] + number[i - 2];
    }

    return number[n];
  }


}
