package level2;

// https://programmers.co.kr/learn/courses/30/lessons/42888?language=java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class 오픈채팅방 {
  public String[] solution(String[] records) {

    List<String> answer = new ArrayList<>();
    Map<String, String> user = new HashMap<>(); // userid와 닉네임을 저장할 곳

    // 닉네임 바꾸기
    for (String record : records) {
      String[] data = record.split(" ");

      if (!record.contains("Leave")) { // 나간 경우는 닉네임이 없기 때문에 덮어쓰기 하지 않음

        if (user.containsKey(data[1])) { // 이미 있는 유저라면 덮어쓰기
          user.replace(data[1], data[2]);
        } else { // 없는 유저라면 새로 넣기
          user.put(data[1], data[2]);
        }
      }
    }

    // 출력하기
    for (String record : records) {
      if (!record.contains("Change")) {
        String[] data = record.split(" ");

        // 경우의 수가 두 가지 밖에 없기 때문에 삼항연산자 이용
        answer.add(data[0].equals("Enter") ? user.get(data[1]) + "님이 들어왔습니다."
            : user.get(data[1]) + "님이 나갔습니다.");
      }
    }

    return answer.toArray(new String[0]);
  }

  @Test
  public void 정답() {
    Assert.assertArrayEquals(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."},
        solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
  }

}
