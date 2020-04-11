package programmers.level3;

// https://programmers.co.kr/learn/courses/30/lessons/42886

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class 저울 {
  public int solution(int[] weight) {

    Arrays.sort(weight);

    int sum = weight[0];

    for (int i=1; i<weight.length; i++){
      sum += weight[i];

      if (i != weight.length - 1 && sum < weight[i+1]) break;
    }

    return sum + 1;
  }

  @Test
  public void 정답(){
    Assert.assertEquals(21, solution(new int[]{3, 1, 6, 2, 7, 30, 1}));

  }
}
