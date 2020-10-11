package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingPositive {

  // https://leetcode.com/problems/first-missing-positive/submissions/


  public static void main(String[] args) {

    FirstMissingPositive positive = new FirstMissingPositive();
    int i = positive.firstMissingPositive(new int[]{2});

    System.out.println(i);
  }


  public int firstMissingPositive(int[] nums) {

    ArrayList<Integer> positiveNums = new ArrayList<>();

    for (int num : nums) {
      if (num > 0 && !positiveNums.contains(num)) {
        positiveNums.add(num);
      }
    }

    Collections.sort(positiveNums);

    for (int i = 1; i <= positiveNums.size(); i++) {
      if (i != positiveNums.get(i - 1)) {
        return i;
      }
    }

    return positiveNums.size() + 1;
  }
}
