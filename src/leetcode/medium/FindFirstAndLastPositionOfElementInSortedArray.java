package leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {

  // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

  public static void main(String[] args) {
    FindFirstAndLastPositionOfElementInSortedArray array = new FindFirstAndLastPositionOfElementInSortedArray();
    int[] search = array.searchRange(new int[]{1}, 1);

    System.out.println(search[0] + "/" + search[1]);

  }

  public int[] searchRange(int[] nums, int target) {
    int[] location = {-1, -1};

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        if (location[0] == -1) {
          location[0] = i;
        }
        location[1] = i;
      }
    }

    return location;
  }
}
