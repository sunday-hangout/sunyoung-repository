package programmers.level2;

import java.util.Arrays;

public class 가장_큰_수 {
  public String solution(int[] numbers) {
    String answer = "";
    String[] arr = new String[numbers.length];

    // int형을 String형으로 반환
    for (int i = 0; i < numbers.length; i++){
      arr[i] = String.valueOf(numbers[i]);
    }

    // 정렬
    Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

    // arr[0]가 앞자리가 0이면
    if(arr[0].equals("0")) {
      return "0";
    }

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < arr.length; i++){
      builder.append(arr[i]);
    }

    answer = builder.toString();

    return answer;
  }

}
