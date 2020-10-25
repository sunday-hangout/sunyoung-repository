package leetcode.medium;

// https://leetcode.com/problems/permutations/

import java.util.ArrayList;

public class Permutations {

  public ArrayList<ArrayList<Integer>> permute(int[] nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());

    for (int num : nums) {
      ArrayList<ArrayList<Integer>> current = new ArrayList<>();

      for (ArrayList<Integer> combination : result) {
        for (int j = 0; j < combination.size() + 1; j++) {
          combination.add(j, num);

          ArrayList<Integer> temp = new ArrayList<>(combination);

          current.add(temp);
          combination.remove(j);
        }
      }

      result = new ArrayList<>(current);
    }

    return result;
  }

}
