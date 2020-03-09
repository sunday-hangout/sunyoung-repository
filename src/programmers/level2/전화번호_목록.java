package programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42577

import org.junit.Assert;
import org.junit.Test;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book.length; j++){
                if(j!=i && phone_book[j].indexOf(phone_book[i]) == 0){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void 정답(){
        Assert.assertEquals(false, solution(new String[]{"119", "97674223", "1195524421"}));
        Assert.assertEquals(true, solution(new String[]{"123", "456", "789"}));
        Assert.assertEquals(false, solution(new String[]{"12", "123", "1235", "567", "88"}));
        Assert.assertEquals(true, solution(new String[]{"23", "12345"})); // 접두사 아님

    }
}
