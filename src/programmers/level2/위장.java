package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesKinds = new HashMap<>();

        for(String[] cloth : clothes){

            String key = cloth[1];

            if(clothesKinds.containsKey(key)){
                clothesKinds.replace(key, clothesKinds.get(key)+1);
            }
            else{
                clothesKinds.put(key, 1);
            }

        }

        // 곱하기
        for(String key : clothesKinds.keySet()){
            answer *= clothesKinds.get(key) + 1;
        }

        return answer - 1;
    }

    @Test
    public void 프로그래머스_정답(){
        Assert.assertEquals(5, solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        Assert.assertEquals(3, solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

}
