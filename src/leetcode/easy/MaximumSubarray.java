package leetcode.easy;

// https://leetcode.com/problems/maximum-subarray/

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarray {

  public int maxSubArray(int[] nums) {

    int nowValue = nums[0];
    int maxValue = nums[0];

    for (int i = 0; i < nums.length; i++) {
      nowValue = Math.max(nums[i] + nowValue, nums[i]);
      maxValue = Math.max(nowValue, maxValue);
    }

    return maxValue;

  }

  @Test
  public void 정답(){
    Assert.assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}
