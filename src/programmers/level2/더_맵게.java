package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42626

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class 더_맵게 {

  public int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for(int i=0; i<scoville.length; i++){
      queue.add(scoville[i]);
    }

    // 가장 낮은거 + 두 번째로 낮은거
    while(queue.peek() <= K){
      if(queue.size() == 1 && queue.peek() < K){ // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
        return -1;
      }
      queue.add(queue.poll() + (queue.poll()*2));
      answer++;
    }

    return answer;
  }

  @Test
  public void 정답(){
    Assert.assertEquals(2, solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    Assert.assertEquals(1, solution(new int[]{1, 2}, 3));
    Assert.assertEquals(-1, solution(new int[]{1, 2}, 7));
  }

}
