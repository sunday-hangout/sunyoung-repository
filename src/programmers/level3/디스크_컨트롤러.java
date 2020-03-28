package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class 디스크_컨트롤러 {

  public int solution(int[][] jobs) {

    int answer = 0;

    List<Disk> list = new ArrayList<>();

    // 우선순위 큐와  삽입
    for (int i = 0; i < jobs.length; i++){
      list.add(new Disk(jobs[i][0], jobs[i][1]));
    }

    list.sort(Collections.reverseOrder((o1, o2) -> o2.getTime() - o1.getTime()));

    int nowTime = 0;

    while(list.size() != 0){

      for(int i = 0; i<list.size(); i++){

        // 시작 가능한 상태면
        if(nowTime >= list.get(i).getStartAt()){
          Disk nowDisk = list.get(i);
          answer +=  nowTime - nowDisk.getStartAt() + nowDisk.getTime();

          nowTime += nowDisk.getTime();

          list.remove(i);

          break;

        } else if (i == list.size() - 1){
          nowTime++;
        }
      }
    }

    answer /= jobs.length;

    return answer;
  }

  @Test
  public void 정답(){
    Assert.assertEquals(9, solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
  }

}

class Disk {
  int startAt;
  int time;

  public Disk(int startAt, int time) {
    this.startAt = startAt;
    this.time = time;
  }

  public int getStartAt() {
    return startAt;
  }

  public int getTime() {
    return time;
  }
}