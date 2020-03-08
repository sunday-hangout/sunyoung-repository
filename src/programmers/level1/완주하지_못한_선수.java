package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/42576?language=java

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class 완주하지_못한_선수 {

    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }

        return participant[participant.length-1];

    }

    @Test
    public void 정답(){
        Assert.assertEquals("leo", solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        Assert.assertEquals("a", solution(new String[]{"a", "a", "b"}, new String[]{"a", "b"}));
    }



}
