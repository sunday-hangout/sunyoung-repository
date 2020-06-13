package level1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/12906

public class 같은_숫자는_싫어 {

    public int[] solution(int []arr) {

        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for(int i=1; i<arr.length; i++){
            if(answer.get(answer.size()-1) != arr[i]){
                answer.add(arr[i]);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    @Test
    public void 정답(){
        Assert.assertArrayEquals(new int[]{1,3,0,1}, solution(new int[]{1,1,3,3,0,1,1}));
    }

}
