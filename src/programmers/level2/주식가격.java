package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42584

import org.junit.Assert;
import org.junit.Test;

public class 주식가격 {

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length-1; i++){

            int count = 1;

            for(int j=i+1; j<prices.length; j++){
                if(prices[i]>prices[j] || j==prices.length-1){ // 가격이 떨어졌거나 마지막까지 다 돌았으면
                    answer[i] = count;
                    break;
                }
                else{ // 안떨어졌으면
                    count++;
                }
            }
        }

        answer[prices.length-1] = 0; // 마지막 요소는 무조건 0

        return answer;
    }

    @Test
    public void 정답(){
        Assert.assertArrayEquals(new int[]{4, 3, 1, 1, 0}, solution(new int[]{1, 2, 3, 2, 3}));
    }

}
