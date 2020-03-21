package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42583

import org.junit.Assert;
import org.junit.Test;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int count = 0;

        int[] bridge = new int[bridge_length+1];

        int i = 0;
        int sum = 0;

        while(i != truck_weights.length){

            // 한 칸씩 뒤로 옮기기
            for(int j=bridge.length-1; j>=1; j--){
                bridge[j] = bridge[j-1];
            }
            bridge[0] = 0;

            // 도착지에 도착하면 합계에 집계 X
            if(bridge[bridge.length-1] != 0){
                sum -= bridge[bridge.length-1];
            }

            // 다리가 견딜 수 있으면 0번째에 추가
            if(sum+truck_weights[i]<=weight) {
                bridge[0] = truck_weights[i];
                sum += truck_weights[i];
                i++;
            }

            // 도착지에 있는 트럭 비우기
            bridge[bridge.length-1] = 0;
            count ++;

        }

        // 마지막 트럭이 배열의 0번째에 도착하면 반복문이 종료
        // 마지막 트럭이 도착지까지 걸리는 시간은 무조건 다리길이 - 1
        count += bridge.length-1;


        return count;
    }

    @Test
    public void 정답(){
        Assert.assertEquals(8, solution(2, 10, new int[]{7,4,5,6}));
        Assert.assertEquals(101, solution(100, 100, new int[]{10}));
        Assert.assertEquals(110, solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}

