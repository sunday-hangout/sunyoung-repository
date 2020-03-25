package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42587

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터 {

  public int solution(int[] priorities, int location) {
    int answer = 1; // 순번이기 때문에 1번째부터 시작

    PriorityQueue priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

    // 우선순위가 높은 순서대로 정렬
    for(int task : priorities){
      priorityQueue.add(task);
    }

    // priorities : { 2, 1, 3, 2 }
    // priorityQueue : { 3, 2, 2, 1 }

    while(!priorityQueue.isEmpty()){
      for(int i=0; i<priorities.length; i++){
        if(priorities[i] == (int)priorityQueue.peek()) { // 배열의 값과 큐의 맨 위에 있는 값이 같고
          if(i == location){ // 원하는 위치(location)과 i(위치)가 같으면
            return answer;
          }
          priorityQueue.poll(); // 큐 제거
          answer++;
        }
      }
    }

    return answer;
  }



  @Test
  public void 정답() {
    Assert.assertEquals(1, solution(new int[]{2, 1, 3, 2}, 2));
    Assert.assertEquals(5, solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
  }

}
