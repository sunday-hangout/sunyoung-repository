package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42629

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 라면공장 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;

        for(int i=0; i<k; i++){

            if(index < dates.length && i == dates[index]){
                queue.add(supplies[index++]);
            }

            if(--stock == -1){
                stock += queue.poll();
                answer++;
            }
        }

        return answer;
    }

    @Test
    public void 정답(){
        Assert.assertEquals(2, solution(4, new int[]{4,10,15}, new int[]{20,5,10}, 30));
    }
}
