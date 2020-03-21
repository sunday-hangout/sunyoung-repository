package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42585

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class 쇠막대기 {
    public int solution(String arrangement) {
        int answer = 0;

        Stack<Character> sticks = new Stack<>();
        int stickCount = 0; // 막대의 갯수

        for(int i=0; i<arrangement.length(); i++){

            if(arrangement.charAt(i) == '('){
                if(arrangement.charAt(i+1) == ')'){ // 레이저인 경우
                    answer += sticks.size();
                    i++;
                }
                else{ // 막대인 경우
                    sticks.push('(');
                    stickCount++;
                }
            }
            else if(arrangement.charAt(i) == ')'){ // 막대의 끝인 경우
                sticks.pop();
            }
        }

        answer += stickCount;

        return answer;
    }

    @Test
    public void 정답(){
        Assert.assertEquals(17, solution("()(((()())(())()))(())"));
    }
}

// 막대 갯수 + 레이저가 나올 때 마다 스택 갯수만큼 누적