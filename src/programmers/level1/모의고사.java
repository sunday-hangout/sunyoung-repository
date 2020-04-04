package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class 모의고사 {
  public int[] solution(int[] answers) {

    List<Integer> first_li = Arrays.stream(new int[]{1, 2, 3, 4, 5}).boxed().collect(Collectors.toList());
    List<Integer> second_li = Arrays.stream(new int[]{2, 1, 2, 3, 2, 4, 2, 5}).boxed().collect(Collectors.toList());
    List<Integer> third_li = Arrays.stream(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}).boxed().collect(Collectors.toList());

    int cnt[] = new int[3];


    for (int i = 0; i < answers.length; i++) {

      if (answers[i] == first_li.get(0)) {
        cnt[0]++;
      }

      if (answers[i] == second_li.get(0)) {
        cnt[1]++;
      }

      if (answers[i] == third_li.get(0)) {
        cnt[2]++;
      }

      first_li.add(first_li.get(0));

      second_li.add(second_li.get(0));
      third_li.add(third_li.get(0));

      first_li.remove(first_li.get(0));
      second_li.remove(second_li.get(0));
      third_li.remove(third_li.get(0));
    }

    int winner = cnt[0];

    for (int i = 1; i < 3; i++) {
      if (winner < cnt[i]) {
        winner = cnt[i];
      }
    }

    List<Integer> winnerList = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      if (winner <= cnt[i]) {
        winnerList.add(i+1);
      }
    }

    return winnerList.stream().mapToInt(i -> i).toArray();
  }

  @Test
  public void 정답() {
    Assert.assertArrayEquals(new int[]{1}, solution(new int[]{1, 2, 3, 4, 5}));
    Assert.assertArrayEquals(new int[]{1, 2, 3}, solution(new int[]{1, 3, 2, 4, 2}));
  }
}

/*
1번 수포자가 찍는 방식은 1~5 부터 순서대롱
2번 수포자가 찍는 방식은 2 n . 1~5(단, 2는 제외)
3번 수포자가 찍는 방식 31245 순서로 두 번씩

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]

 */