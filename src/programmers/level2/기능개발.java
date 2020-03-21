package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 기능개발 {

  public int[] solution(int[] progresses, int[] speeds) {

    // array to stack
    List<Integer> progressesList = Arrays.stream(progresses).boxed().collect(Collectors.toList());
    List<Integer> speedsList = Arrays.stream(speeds).boxed().collect(Collectors.toList());

    List<Integer> answer = new ArrayList<>();


    while (!progressesList.isEmpty()) {

      // progresses[i]가 speeds[i]로 얼마나 해야 도달하는지 체크
      int progress = progressesList.get(0);
      int day = 0;
      int sum = 0;

      while (progress < 100) {
        progress += speedsList.get(0);
        day++;
      }

      progressesList.remove(0);
      speedsList.remove(0);

      sum++;

      // 추가로 배포하는 할 수 있는 건이 있으면 배포
      while(!progressesList.isEmpty() && 100 <= progressesList.get(0) + (day * speedsList.get(0))) {

        progressesList.remove(0);
        speedsList.remove(0);

        sum++;
      }
      answer.add(sum);
    }

    return answer.stream().mapToInt(i -> i).toArray();
  }

  @Test
  public void 정답() {
    Assert.assertArrayEquals(new int[]{2, 1}, solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
    Assert.assertArrayEquals(new int[]{1, 2, 3}, solution(new int[]{40, 93, 30, 55, 60, 65}, new int[]{60, 1, 30, 5, 10, 7}));
  }

}
