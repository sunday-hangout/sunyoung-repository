package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    System.out.println(lists);
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> answer = new ArrayList<>();
    Arrays.sort(nums); // 오름차순으로 정렬

    // -4 -1 -1 0 1 2
    for (int i = 0; i < nums.length - 2; i++) { // 세개의 합까지 구해야하니까 nums.length - 2까지 반복
      if (i >= 1 && nums[i] == nums[i-1])  {  // 현재 숫자와 이전 숫자가 같으면 비교 X
        System.out.println("continue : " + nums[i]);
        continue;
      }

      int left = i + 1; // 현재 인덱스 + 1
      int right = nums.length - 1; // 마지막 인덱스

      while (left < right) {
        System.out.println(nums[i] + ", " + nums[left] + ", " + nums[right]);

        int sum = nums[left] + nums[i] + nums[right];

        if (sum == 0) {
          answer.add(Arrays.asList(nums[i], nums[left], nums[right]));

          // 다음 반복을 위해 범위를 줄여줌
          left++;
          right--;

          // 같은 요소는 반복을 건너뛰게 처리
          while (nums[left] == nums[left - 1] && left < right) {
            left++;
          }

          while (nums[right] == nums[right + 1] && left < right) {
            right--;
          }

          System.out.println("find! " + nums[i] + ", " + nums[left] + ", " + nums[right]);


        } else if (sum > 0) { // 합이 0보다 크다면
          right--;
        } else {  // 합이 0보다 작다면
          left++;
        }
      }

      System.out.println("pass " + nums[i]);

    }

    return answer;
  }


}
