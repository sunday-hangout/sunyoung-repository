package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42839

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class 소수찾기 {

  public int solution(String numbers) {

    int[] numList = new int[numbers.length()];

    // 한 글자씩 분리해서 배열에 삽입
    for (int i = 0; i < numbers.length(); i++) {
      numList[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
    }

    Arrays.sort(numList);

    Set<Integer> primeList = new HashSet<>(); // HashSet을 이용하면 중복 제거 가능
    for (int i = 1; i <= numList.length; i++) {
      perm(numList, 0, i, primeList);
    }

    return primeList.size();

  }

  // 순열
  public void perm(int[] arr, int depth, int num, Set primeList) {
    if (depth == num) {
      int resultNumber = 0;
      for (int i = 0; i < num; i++) {
        resultNumber += arr[i] * Math.pow(10, num - 1 - i);
      }

      boolean isPrime = true;
      if (resultNumber <= 1) {
        return;
      }

      for (int j = 2; j <= Math.sqrt(resultNumber); j++) {
        if (resultNumber % j == 0) {
          isPrime = false;
          break;
        }
      }

      if (isPrime) {
        primeList.add(resultNumber); // 중복이면 안들어감
      }

      return;

    } else {
      for (int i = depth; i < arr.length; i++) {
        swap(arr, i, depth);
        perm(arr, depth + 1, num, primeList);
        swap(arr, i, depth);
      }
    }
  }

  // 변경
  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  @Test
  public void 정답() {
    Assert.assertEquals(3, solution("17"));
    Assert.assertEquals(2, solution("011"));
  }

}
