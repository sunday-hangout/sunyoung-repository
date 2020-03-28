package programmers.level3;

// https://programmers.co.kr/learn/courses/30/lessons/42628

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Assert;
import org.junit.Test;

public class 이중우선순위큐 {

  public int[] solution(String[] operations) {
    int[] answer = {0,0};
    PriorityQueue<Integer> qMax = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> qMin = new PriorityQueue<>();

    for (String operation : operations) {

      String[] str = operation.split(" ");

      if (str[0].equals("I")) {
        qMax.add(Integer.parseInt(str[1]));
        qMin.add(Integer.parseInt(str[1]));
      }

      if (str[0].equals("D")) {
        if (!qMax.isEmpty()) {
          if (str[1].equals("1")) {
            int max = qMax.peek();
            qMax.remove(max);
            qMin.remove(max);
          } else {
            int min = qMin.peek();
            qMax.remove(min);
            qMin.remove(min);
          }
        }
      }

    }
    if (!qMax.isEmpty()) {
      answer[0] = qMax.peek();
      answer[1] = qMin.peek();
    }
    return answer;
  }

  @Test
  public void 정답(){
    Assert.assertArrayEquals(new int[]{0, 0}, solution(new String[]{"I 16","D 1"}));
  }

}
