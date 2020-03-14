package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 탑 {

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i=heights.length-1; i>0; i--) {
            for(int j=i-1; j>=0; j--) {
                if(heights[i] < heights[j]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }
        answer[0] = 0;

        return answer;
    }

    @Test
    public void 정답(){
        Assert.assertArrayEquals(new int[]{0,0,2,2,4}, solution(new int[]{6,9,5,7,4}));

    }

}
