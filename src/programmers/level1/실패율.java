package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class 실패율 {

  public int[] solution(int N, int[] stages) {

    List<Stage> list = new ArrayList<>();

    for (int i = 1; i < N + 1; i++) {
      int now = 0;
      int clear = 0;

      for (int stage : stages) {
        if (i <= stage) {
          clear += 1;
        }
        if (i == stage) {
          now += 1;
        }
      }

      if (clear == 0) {
        list.add(new Stage(i, 0));
      } else {
        list.add(new Stage(i, (double) now / clear));
      }
    }

    list.sort(Stage::compareTo);
    return list.stream().mapToInt(Stage::getNum).toArray();
  }

  @Test
  public void 정답() {
    Assert.assertArrayEquals(new int[]{3, 4, 2, 1, 5}, solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    Assert.assertArrayEquals(new int[]{4, 1, 2, 3}, solution(4, new int[]{4, 4, 4, 4, 4}));
    Assert.assertArrayEquals(new int[]{7, 6, 5, 4, 3, 2, 1, 8}, solution(8, new int[]{1, 2, 3, 4, 5, 6, 7}));
  }

}

class Stage implements Comparable<Stage> {

  private int num;
  private double failure; // 실패율

  public int getNum() {
    return num;
  }

  public Stage(int num, double failure) {
    this.num = num;
    this.failure = failure;
  }

  @Override
  public int compareTo(Stage o) {
    if (this.failure == o.failure) {
      return this.num < o.num ? -1 : 1;
    } else {
      return this.failure > o.failure ? -1 : 1;
    }
  }
}
