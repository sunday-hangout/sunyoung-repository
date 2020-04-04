package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 카펫 {

  public int[] solution(int brown, int red) {
    int[] answer = new int[2];

    int sum = brown + red;

    for(int col=1; col<=(sum)/2; col++){
      if(sum % col == 0){

        int row = sum / col;

        if((row*2) + ((col-2)*2) == brown){
          answer[0] = col;
          answer[1] = row;
        }
      }
    }

    return answer;
  }

  @Test
  public void 정답(){
    Assert.assertArrayEquals(new int[]{4,3}, solution(10, 2));
    Assert.assertArrayEquals(new int[]{3,3}, solution(8, 1));
    Assert.assertArrayEquals(new int[]{8,6}, solution(24, 24));
  }

}
